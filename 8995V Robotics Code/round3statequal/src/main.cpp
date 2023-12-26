// ---- START VEXCODE CONFIGURED DEVICES ----
// Robot Configuration:
// [Name]               [Type]        [Port(s)]
// Controller1          controller                    
// RFM                  motor         16              
// RBM                  motor         13              
// LFM                  motor         3               
// LBM                  motor         10              
// straightTrack        encoder       G, H            
// intake               motor         20              
// endgame              motor         1               
// fly1                 motor         8               
// Inertial             inertial      11              
// autonSwitch          bumper        C               
// indexer              motor         18              
// ---- END VEXCODE CONFIGURED DEVICES ----



#include "vex.h"
#include "helpers.h"
#include "autonMovers.h"
#include "autonRoutines.h"
#include "gui.h"

using namespace vex;

// A global instance of competition
competition Competition;

// define your global instances of motors and other devices here


/*---------------------------------------------------------------------------*/
/*                          Pre-Autonomous Functions                         */
/*                                                                           */
/*  You may want to perform some actions before the competition starts.      */
/*  Do them in the following function.  You must return from this function   */
/*  or the autonomous and usercontrol tasks will not be started.  This       */
/*  function is only called once after the V5 has been powered on and        */
/*  not every time that the robot is disabled.                               */
/*---------------------------------------------------------------------------*/

void pre_auton(void) {
  // Initializing Robot Configuration. DO NOT REMOVE!
  vexcodeInit();

  // All activities that occur before the competition starts
  // Example: clearing encoders, setting servo positions, ...
  resetAllSensors();
  Inertial.calibrate();

  RFM.setBrake(coast);
  LFM.setBrake(coast);
  RBM.setBrake(coast);
  LBM.setBrake(coast);


  //start of preauton gui
  autonGUI();
  Brain.Screen.pressed(brainAutonButtons);
  
  autonSwitch.pressed(switchAut);
  
}

/*---------------------------------------------------------------------------*/
/*                                                                           */
/*                              Autonomous Task                              */
/*                                                                           */
/*  This task is used to control your robot during the autonomous phase of   */
/*  a VEX Competition.                                                       */
/*                                                                           */
/*  You must modify the code to add your own robot specific commands here.   */
/*---------------------------------------------------------------------------*/

void autonomous(void) {
  clearBrain();

  Brain.Screen.print("Auton started");
  switch(currentAut) {
    case 0:
      skillsAut();
      Brain.Screen.printAt(20, 40, "Selected Auton:", currentAut);
      break;

    case 1:
      nothingAut();
      Brain.Screen.printAt(20, 40, "Selected Auton:", currentAut);
      break;

    case 2:
      leftRoller();
      Brain.Screen.printAt(20, 40, "Selected Auton:", currentAut);
      break;
    
    case 3:
      rightAWP();
      Brain.Screen.printAt(20, 40, "Selected Auton:", currentAut);
      break;
    
    case 4:
      rightRoller();
      Brain.Screen.printAt(20, 40, "Selected Auton:", currentAut);
      break;

  }
  

}

/*---------------------------------------------------------------------------*/
/*                                                                           */
/*                              User Control Task                            */
/*                                                                           */
/*  This task is used to control your robot during the user control phase of */
/*  a VEX Competition.                                                       */
/*                                                                           */
/*  You must modify the code to add your own robot specific commands here.   */
/*---------------------------------------------------------------------------*/

void usercontrol(void) {
  
  //init stuff
  resetAllSensors();
  displayPatriotism();


  //debugging
  Controller1.ButtonA.pressed(clearTrackingWheels);

  //flywheel settings
  Controller1.ButtonUp.pressed(flyPowIncrease);
  Controller1.ButtonDown.pressed(flyPowDecrease);

  //endgame
  Controller1.ButtonY.pressed(endgameTrigger);

  while (1) {
    //DEBUGGING-----------------------------------
    if(Controller1.ButtonRight.pressing()){
      Controller1.Screen.setCursor(1, 1);
      Controller1.Screen.print("flypow = %f", flyPow);

      Brain.Screen.printAt(20, 40, "%f" , straightTrack.position(degrees));
    } else {
      //Controller1.Screen.clearScreen();
    }

    
    //driver control ============================================
    if(driverMode == 0){
      rPow = RFM.velocity(percent) + (Controller1.Axis2.position() - RFM.velocity(percent))*0.5;
      lPow = LFM.velocity(percent) + (Controller1.Axis3.position() - LFM.velocity(percent))*0.5;

      if(fabs(rPow) < 5){rPow = 0;}
      if(fabs(lPow) < 5){lPow = 0;}

    } else {
      rPow = RFM.velocity(percent) + (Controller1.Axis3.position() - Controller1.Axis1.position() - RFM.velocity(percent))*0.5;
      lPow = LFM.velocity(percent) + (Controller1.Axis3.position() + Controller1.Axis1.position() - LFM.velocity(percent))*0.5;

      if(fabs(rPow) < 5){rPow = 0;}
      if(fabs(lPow) < 5){lPow = 0;}
    }    
    


    if(Controller1.ButtonL2.pressing()){
      rPow /= 2;
      lPow /= 2;
    }


    RFM.spin(vex::forward, rPow, vex::percent);
    RBM.spin(vex::forward, rPow, vex::percent);
    LFM.spin(vex::forward, lPow, vex::percent);
    LBM.spin(vex::forward, lPow, vex::percent);


    //buttons---------------------------------------------------------------------------------------------
    //intake, roller, indexer
    buttonHold(intake, Controller1.ButtonR1.pressing(), Controller1.ButtonL1.pressing(), 100, coast);
    buttonHold(indexer, Controller1.ButtonR1.pressing(), Controller1.ButtonL1.pressing(), 100, coast);

    //flywheel
    if(flyOn){
      fly1.spin(forward, flyPow, volt);
    } else {
      fly1.stop(coast);
    }

    //endgame
    buttonHold(endgame, Controller1.ButtonY.pressing(), Controller1.ButtonA.pressing(), 100, currEndgameBrake());

    if(Controller1.ButtonY.pressing()) {
      endgameOn = true;
    }


    wait(20, msec); 
  }
}

//
// Main will set up the competition functions and callbacks.
//
int main() {
  // Set up callbacks for autonomous and driver control periods.
  Competition.autonomous(autonomous);
  Competition.drivercontrol(usercontrol);

  // Run the pre-autonomous function.
  pre_auton();

  // Prevent main from exiting with an infinite loop.
  while (true) {
    wait(100, msec);
  }
}
