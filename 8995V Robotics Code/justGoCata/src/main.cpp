/*----------------------------------------------------------------------------*/
/*                                                                            */
/*    Module:       main.cpp                                                  */
/*    Author:       VEX                                                       */
/*    Created:      Thu Sep 26 2019                                           */
/*    Description:  Competition Template                                      */
/*                                                                            */
/*----------------------------------------------------------------------------*/

// ---- START VEXCODE CONFIGURED DEVICES ----
// Robot Configuration:
// [Name]               [Type]        [Port(s)]
// RFM                  motor         1               
// RCM                  motor         2               
// RBM                  motor         3               
// LFM                  motor         4               
// LCM                  motor         5               
// LBM                  motor         6               
// cata                 motor         7               
// intake               motor         8               
// Controller1          controller                    
// cataRight            digital_out   A               
// cataLeft             digital_out   B               
// ---- END VEXCODE CONFIGURED DEVICES ----

#include "vex.h"

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
  vexcodeInit();


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

  while (1) {
    //tank control==========================================================
    RCM.spin(forward, Controller1.Axis2.position(), percent);
    RBM.spin(forward, Controller1.Axis2.position(), percent);
    RFM.spin(forward, Controller1.Axis2.position(), percent);
    LFM.spin(forward, Controller1.Axis3.position(), percent);
    LCM.spin(forward, Controller1.Axis3.position(), percent);
    LBM.spin(forward, Controller1.Axis3.position(), percent);


    //cata================================================================
    if(Controller1.ButtonR2.pressing()){
      cata.spin(forward, 100, percent);
    } else {
      cata.stop(hold);
    }

    //intake==============================================================
    if(Controller1.ButtonL1.pressing()){
      intake.spin(forward, 100, percent);
    } else if(Controller1.ButtonR1.pressing()){
      intake.spin(reverse, 100, percent);
    } else {
      intake.stop(coast);
    }
    

    wait(20, msec);
  }
}


int main() {
  Competition.autonomous(autonomous);
  Competition.drivercontrol(usercontrol);

  pre_auton();

  while (true) {
    wait(100, msec);
  }
}
