#include "autonHelpers.h"

//setter
// void setDrive(double left, double right){
//   RFM.spin(forward, right, percent);
//   RBM.spin(forward, right, percent);
//   LFM.spin(forward, left, percent);
//   LBM.spin(forward, left, percent);
// }

//tracking wheels
void clearTrackingWheels(){
  rightTrack.setPosition(0, degrees);
  centTrack.setPosition(0, degrees);
  leftTrack.setPosition(0, degrees);
}

double getTrackPos(vex::rotationUnits u){
  double r = rightTrack.position(u);
  double l = leftTrack.position(u);

  return (r+l)/2.0;
}


//move forward and backwards
void translate(double d, vex::rotationUnits units, double speed){
    //get direction
    int dir = fabs(d)/d;

    //reset encoders
    clearTrackingWheels();

    //go forward
    while(fabs(rightTrack.position(units)) < fabs(d)){
        RFM.spin(forward, dir*speed, volt);
        LFM.spin(forward, dir*speed, volt);
        RBM.spin(forward, dir*speed, volt);
        LBM.spin(forward, dir*speed, volt);
        
        wait(20, msec);
    }

    //end
    //setDrive(dir * -10, dir * -10);
    wait(20, msec);

    //setDrive(0, 0);
}

//autonomous translate

void autTranslate(double d, vex::rotationUnits units, double speed){
  int dir = fabs(d)/d;

  RFM.setVelocity(speed, percent);
  RBM.setVelocity(speed, percent);
  LFM.setVelocity(speed, percent);
  LBM.setVelocity(speed, percent);

  RFM.spinFor(forward, d, units, false);
  RBM.spinFor(forward, d, units, false);
  LFM.spinFor(forward, d, units, false);
  LBM.spinFor(forward, d, units);

  RFM.setVelocity(100, percent);
  RBM.setVelocity(100, percent);
  LFM.setVelocity(100, percent);
  LBM.setVelocity(100, percent);
}

//turn left or right
void rotate(double deg, double speed){
    //get direction
    int dir = fabs(deg)/deg;

    //reset encoders
    inert1.setHeading(0, degrees);

    //go forward
    while(fabs(inert1.heading(degrees)) < fabs(deg)){
        RFM.spin(forward, dir*speed, volt);
        LFM.spin(reverse, dir*speed, volt);
        RBM.spin(forward, dir*speed, volt);
        LBM.spin(reverse, dir*speed, volt);
    }

    //end
   // setDrive(dir * 10, dir * -10);
    wait(20, msec);    
}


