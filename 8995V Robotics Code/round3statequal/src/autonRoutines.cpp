#include "autonRoutines.h"
#include "gui.h"

int currentAut = 1;

void switchAut(){
  currentAut++;
  
  if(currentAut == 5){
    currentAut = 0;
  }

  autonGUI();
}

//ROUTINES===========================================

//skills auton (0)
void skillsAut(){
  leftRoller();
  
  RFM.spin(forward);
  LFM.spin(forward);
  RBM.spin(forward);
  LBM.spin(forward);
  wait(3000, msec);
  RFM.stop(coast);
  LFM.stop(coast);
  RBM.stop(coast);
  LBM.stop(coast);

  pidTurn(90);

  RFM.spin(reverse);
  LFM.spin(reverse);
  RBM.spin(reverse);
  LBM.spin(reverse);
  wait(3500, msec);
  RFM.stop(coast);
  LFM.stop(coast);
  RBM.stop(coast);
  LBM.stop(coast);

  indexer.spinFor(reverse, 135, degrees);

  RFM.spin(forward);
  LFM.spin(forward);
  RBM.spin(forward);
  LBM.spin(forward);
  wait(3500, msec);
  RFM.stop(coast);
  LFM.stop(coast);
  RBM.stop(coast);
  LBM.stop(coast);

  pidTurn(45);


  RFM.spin(reverse);
  LFM.spin(reverse);
  RBM.spin(reverse);
  LBM.spin(reverse);
  wait(2000, msec);
  RFM.stop(coast);
  LFM.stop(coast);
  RBM.stop(coast);
  LBM.stop(coast);

  wait(2500, msec);

  pidTurn(45);

  endgame.spinFor(forward, 90, degrees);

 
  
}

//nothing auton (auton 1):
void nothingAut(){
  autTranslate(3500, 80, false, coast);
}


//left side auton (auton 2):
void leftRoller(){


  RFM.setVelocity(20, percent);
  LFM.setVelocity(20, percent);
  RBM.setVelocity(20, percent);
  LBM.setVelocity(20, percent);

  RFM.spin(reverse);
  LFM.spin(reverse);
  RBM.spin(reverse);
  LBM.spin(reverse);

  wait(500, msec);

  RFM.stop(coast);
  LFM.stop(coast);
  RBM.stop(coast);
  LBM.stop(coast);

  indexer.spinFor(reverse, 60, degrees);

}

//right side auton (auton 3):
void rightAWP(){
  RFM.setVelocity(100, percent);
  LFM.setVelocity(100, percent);
  RBM.setVelocity(100, percent);
  LBM.setVelocity(100, percent);

  intake.setVelocity(100, percent);
  indexer.setVelocity(100, percent);

  intake.spin(forward);
  indexer.spin(forward);

  RFM.spin(forward);
  LFM.spin(forward);
  RBM.spin(forward);
  LBM.spin(forward);
  wait(900, msec);
  RFM.stop(hold);
  LFM.stop(hold);
  RBM.stop(hold);
  LBM.stop(hold);

  pidTurn(19);

  intake.spin(reverse);
  indexer.stop(coast);

  fly1.spin(forward, 12, volt);

  wait(800, msec);
  intake.stop(coast);
  wait(1500, msec);

  indexer.spinFor(reverse, 220, degrees);

  wait(700, msec);

  indexer.spinFor(reverse, 220, degrees);

  wait(800, msec);

  indexer.spinFor(reverse, 220, degrees);

  fly1.stop(coast);

  //roller
  pidTurn(-35);

  RFM.spin(reverse);
  LFM.spin(reverse);
  RBM.spin(reverse);
  LBM.spin(reverse);
  wait(2000, msec);
  RFM.stop(coast);
  LFM.stop(coast);
  RBM.stop(coast);
  LBM.stop(coast);

  indexer.spinFor(reverse, 50, degrees);



}


//RIGHT SIDE===================================================================
void rightRoller(){
  RFM.setVelocity(20, percent);
  LFM.setVelocity(20, percent);
  RBM.setVelocity(20, percent);
  LBM.setVelocity(20, percent);

  RFM.spin(forward);
  LFM.spin(forward);
  RBM.spin(forward);
  LBM.spin(forward);

  wait(3000, msec);

  pidTurn(-90);


  //going back
  RFM.spin(reverse);
  LFM.spin(reverse);
  RBM.spin(reverse);
  LBM.spin(reverse);

  wait(1500, msec);

  RFM.stop(coast);
  LFM.stop(coast);
  RBM.stop(coast);
  LBM.stop(coast);

  indexer.spinFor(reverse, 60, degrees);
}

