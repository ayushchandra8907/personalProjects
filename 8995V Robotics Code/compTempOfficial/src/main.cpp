

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
// fly1                 motor         19              
// endgame              motor         9               
// inert1               inertial      11              
// distSense            distance      6               
// ---- END VEXCODE CONFIGURED DEVICES ----

#include "vex.h"
#include "helpers.h"
#include "autonHelpers.h"

using namespace vex;

// A global instance of competition
competition Competition;

// define your global instances of motors and other devices here

double rPow;
double lPow;
double fwdD = 1;

void switchDir(){
  fwdD *= -1;
}

double flyPow = 12;
void flySpeed1(){flyPow = 11;}
void flySpeed2(){flyPow = 10;}
void flySpeed3(){flyPow = 8;}
void flySpeed4(){flyPow = 7;}



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
  
  inert1.calibrate();

  rightTrack.setPosition(0, degrees);
  leftTrack.setPosition(0, degrees);
  centTrack.setPosition(0, degrees);
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
  // ..........................................................................
  // Insert autonomous user code here.
  // ..........................................................................

  autTranslate(-1, turns, 50);
  intake.spinFor(forward, 3, turns);
  



  

  // autTranslate(2, turns, 50);

  // RFM.spinFor(forward, 0.7, turns, false);
  // RBM.spinFor(forward, 0.7, turns, false);
  // LFM.spinFor(reverse, 0.7, turns, false);
  // LBM.spinFor(reverse, 0.7, turns);

  // autTranslate(-1.2, turns, 50);

  // intake.spinFor(forward, 0.25, turns);

  // RFM.spinFor(forward, 0.7, turns, false);
  // RBM.spinFor(forward, 0.7, turns);
  
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

  inert1.setHeading(0, degrees);

  Controller1.ButtonA.pressed(clearTrackingWheels);
  Controller1.ButtonLeft.pressed(switchDir);

  //flywheel settings
  Controller1.ButtonUp.pressed(flySpeed1);
  Controller1.ButtonRight.pressed(flySpeed2);
  Controller1.ButtonDown.pressed(flySpeed3);
  Controller1.ButtonLeft.pressed(flySpeed4);

  while (1) {
    //driver control - tank drive
    
    // rPow = fwdD*(RFM.velocity(percent) + (Controller1.Axis2.position() - RFM.velocity(percent))*0.3);
    // lPow = fwdD*(LFM.velocity(percent) + (Controller1.Axis3.position() - LFM.velocity(percent))*0.3);

    // if(fabs(rPow) <= 10){rPow = 0;}
    // if(fabs(lPow) <= 10){lPow = 0;}

    rPow = (pow(Controller1.Axis2.position(), 3))*(pow(0.01, 2));
    lPow = (pow(Controller1.Axis3.position(), 3))*(pow(0.01, 2));


    RFM.spin(vex::forward, rPow, vex::percent);
    RBM.spin(vex::forward, rPow, vex::percent);
    LFM.spin(vex::forward, lPow, vex::percent);
    LBM.spin(vex::forward, lPow, vex::percent);


    //encoders
    if(Controller1.ButtonX.pressing()){
      // Brain.Screen.printAt(20, 40, "Right Track %3f", rightTrack.position(degrees));
      // Brain.Screen.printAt(20, 60, "Cent Track %3f", centTrack.position(degrees));
      // Brain.Screen.printAt(20, 80, "Left Track %3f", leftTrack.position(degrees));

      Brain.Screen.printAt(20, 40, "Disance %3f", distSense.objectDistance(inches));
    } else {
      Brain.Screen.clearScreen();
    }

    //buttons--------------
    //indexer

    if(Controller1.ButtonR2.pressing()){
      indexer.spin(forward, 75, percent);
    } else {
      indexer.stop(hold);
    }

    //intake
    buttonHold(intake, Controller1.ButtonL1.pressing(), Controller1.ButtonR1.pressing(), 100, coast);

    //flywheel
    buttonHoldVolt(fly1, Controller1.ButtonL2.pressing(), flyPow);

    //endgame
    buttonHold(endgame, Controller1.ButtonY.pressing(), Controller1.ButtonB.pressing(), 20, hold);

    wait(20, msec); // Sleep the task for a short amount of time to
                    // prevent wasted resources.
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
