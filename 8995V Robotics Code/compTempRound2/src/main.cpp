
// ---- START VEXCODE CONFIGURED DEVICES ----
// Robot Configuration:
// [Name]               [Type]        [Port(s)]
// Controller1          controller                    
// RFM                  motor         16              
// RBM                  motor         13              
// LFM                  motor         3               
// LBM                  motor         10              
// rightTrack           encoder       E, F            
// centTrack            encoder       C, D            
// leftTrack            encoder       A, B            
// intake               motor         20              
// indexer              motor         14              
// fly1                 motor         8               
// fly2                 motor         9               
// Inertial             inertial      11              
// distSense            distance      6               
// autonSwitch          bumper        G               
// ---- END VEXCODE CONFIGURED DEVICES ----



#include "vex.h"
#include "helpers.h"
#include "autonHelpers.h"
#include "autonRoutines.h"
#include "pid.h"
#include "macros.h"

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
  
  Inertial.calibrate();

  rightTrack.setPosition(0, degrees);
  leftTrack.setPosition(0, degrees);
  centTrack.setPosition(0, degrees);

  //autonSwitch.pressed(switchAut);
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
  // switch(currentAut) {
  //   case 0:
  //     autonRoute0();
  //     Brain.Screen.printAt(20, 40, "Selected Auton:", currentAut);
  //     break;

  //   case 1:
  //     autonRoute1();
  //     Brain.Screen.printAt(20, 40, "Selected Auton:", currentAut);
  //     break;

  //   case 2:
  //     autonRoute2();
  //     Brain.Screen.printAt(20, 40, "Selected Auton:", currentAut);
  //     break;
  // }
  
  
  intake.setVelocity(75, percent);

  autTranslate(100, degrees, 20);
  intake.spinFor(50, degrees);

  // autTranslate(100, degrees, 50);
  // pdTurn(-90);
  // autTranslate(-30, degrees, 20);
  // intake.spinFor(50, degrees);


  
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
  // User control code here, inside the loop
  rightTrack.setPosition(0, degrees);
  centTrack.setPosition(0, degrees);
  leftTrack.setPosition(0, degrees);


  Controller1.ButtonA.pressed(clearTrackingWheels);

  //flywheel settings
  Controller1.ButtonUp.pressed(flyPowIncrease);
  Controller1.ButtonDown.pressed(flyPowDecrease);

  //drive
  Controller1.ButtonLeft.pressed(switchDir);
  //Controller1.ButtonY.pressed(endgame);


  while (1) {
    //driver control - tank drive============================================
    
    rPow = Controller1.Axis2.position();
    lPow = Controller1.Axis3.position();

    


    RFM.spin(vex::forward, fwdD*rPow, vex::percent);
    RBM.spin(vex::forward, fwdD*rPow, vex::percent);
    LFM.spin(vex::forward, fwdD*lPow, vex::percent);
    LBM.spin(vex::forward, fwdD*lPow, vex::percent);


    //DEBUGGING-----------------------------------
      if(Controller1.ButtonX.pressing()){
        // Brain.Screen.printAt(20, 40, "Right Track %3f", rightTrack.position(degrees));
        // Brain.Screen.printAt(20, 60, "Cent Track %3f", centTrack.position(degrees));
        // Brain.Screen.printAt(20, 80, "Left Track %3f", leftTrack.position(degrees));

        Brain.Screen.printAt(20, 40, "Inertial %3f", Inertial.rotation());
      } else {
        Brain.Screen.clearScreen();
      }

      // Controller1.Screen.setCursor(1, 1);
      // Controller1.Screen.print("flypow = %f", flyPow);

    //buttons-----------------------------------
    //indexer

    if(Controller1.ButtonR2.pressing()){
      indexer.spin(forward, 75, percent);
    } else {
      indexer.stop(hold);
    }

    if(Controller1.ButtonRight.PRESSED == true)
      autoAim();

    //intake
    buttonHold(intake, Controller1.ButtonL1.pressing(), Controller1.ButtonR1.pressing(), 100, coast);

    //flywheel
    buttonHoldVolt(fly1, Controller1.ButtonL2.pressing(), flyPow);
    buttonHoldVolt(fly2, Controller1.ButtonL2.pressing(), flyPow);

    //endgame
    piston1.set(Controller1.ButtonY.pressing());


    wait(20, msec); 
  }
}

//
// Main will set up the competition functions and callbacks.
//
int main() {
  // Set up callbacks for autonomous and driver control periods.
  Competition.autonomous(autonomous);
  // Competition.drivercontrol(usercontrol);

  // Run the pre-autonomous function.
  pre_auton();

  // Prevent main from exiting with an infinite loop.
  while (true) {
    wait(100, msec);
  }
}
