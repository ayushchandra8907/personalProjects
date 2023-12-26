#include "helpers.h"
#include "pid.h"

//drive
double rPow;
double lPow;
int fwdD= 1;

void switchDir(){
  fwdD *= -1;
}

void autoAim(){
  pdTurn(45);
}

void endgame(){
  piston1.set(true);
}

//helper functions
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
