#include "helpers.h"


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
