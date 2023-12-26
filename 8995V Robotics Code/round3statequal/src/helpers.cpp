#include "helpers.h"
//#include "pid.h"

//GENERAL USE========================================================
void resetAllSensors(){
  straightTrack.setPosition(0, degrees);
  Inertial.setRotation(0, degrees);
}

void buttonHold(motor m, bool fwd, bool rev, int pow, vex::brakeType b){
  if(fwd){
      m.spin(forward, pow, percent);
  } else if (rev){
      m.spin(reverse, pow, percent);
  } else {
      m.stop(b);
  }
}

void buttonHold(motor m, bool fwd, int pow, vex::brakeType b){
  if(fwd){
      m.spin(forward, pow, percent);
  } else {
      m.stop(b);
  }
}

void buttonHoldVolt(motor m, bool fwd, int pow){
  if(fwd){
      m.spin(forward, pow, volt);
  } else {
      m.stop(coast);
  }
}

//DRIVE===============================================================
double rPow;
double lPow;


//FLYWHEEL============================================================
double flyPow = 9.3; //default flywheel power
void flyPowIncrease(){
  if(!(flyPow >= 12)){
    flyPow += .1;
  }
  Controller1.Screen.print("flypow = %f", flyPow);
}
void flyPowDecrease(){
  if(!(flyPow <= 0)){
    flyPow -= .1;
  } 
  Controller1.Screen.print("flypow = %f", flyPow);
}

bool flyOn = false;
void flyTogg(){
  flyOn = !flyOn;
}

//ENDGAME=============================================================
bool endgameOn = false;

void endgameTrigger(){
  Controller1.Screen.print("BRAZILA");
}

vex::brakeType currEndgameBrake(){
  if(endgameOn){
    return coast;
  } else {
    return hold;
  }
}
