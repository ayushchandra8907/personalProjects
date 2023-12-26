#include "autonRoutines.h"


int currentAut = 0;
void switchAut(){
  currentAut++;
  if(currentAut == 2){
    currentAut = 0;
  }
}

//ROUTINES===========================================


//nothing auton (auton 0):
void autonRoute0(){

}


//left side auton (auton 1):
void autonRoute1(){
  autTranslate(-1, turns, 50);
  intake.spinFor(forward, 3, turns);
}

//right side auton (auton 2):
void autonRoute2(){
  autTranslate(2, turns, 50);

  RFM.spinFor(forward, 0.7, turns, false);
  RBM.spinFor(forward, 0.7, turns, false);
  LFM.spinFor(reverse, 0.7, turns, false);
  LBM.spinFor(reverse, 0.7, turns);

  autTranslate(-1.2, turns, 50);

  intake.spinFor(forward, 0.25, turns);

  RFM.spinFor(forward, 0.7, turns, false);
  RBM.spinFor(forward, 0.7, turns);
}

