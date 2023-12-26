#include "pid.h"


double kP = 0.25;
double kI = 0;
double kD = 0.1;


//helper
double getPIDpos(){
  double r = rightTrack.position(degrees);
  double l = leftTrack.position(degrees);

  return r/1.0;
}

void powerMotors(double p){
  RFM.spin(forward, p, volt);
  RBM.spin(forward, p, volt);
  LFM.spin(forward, p, volt);
  LBM.spin(forward, p, volt);
}

void turnMotors(double p){
  RFM.spin(reverse, p, volt);
  RBM.spin(reverse, p, volt);
  LFM.spin(forward, p, volt);
  LBM.spin(forward, p, volt);
}

void stopMotors(){
  RFM.stop();
  RBM.stop();
  LFM.stop();
  LBM.stop();
}


//methods========================================================================
void pidTranslate(double target){
  double error = target - getPIDpos();
  double integral = 0;
  double derivative = 0;
  double prevError = error;

  double motPow = 0;

  double timeElap = 0;

  while(timeElap < 2000){

    //p for porn
    error = target - getPIDpos();


    //i for intercourse
    if (error <= 0)
      integral = 0;
    integral += error;

    //d for dick
    derivative = error-prevError;
    prevError = error;


    motPow = error*kP + integral*kI + error*kD;
    Brain.Screen.printAt(20, 40, "Right Track %3f", rightTrack.position(degrees));
    
    powerMotors(motPow);

    timeElap += 20;

    wait(20, msec);
  } 
}

void pdTurn(double degrees) //PD loop turn code (better than the smartdrive and P loop methods once kP and kD are tuned properly)
{
  int dt = 20;  // Recommended wait time in milliseconds
  double target = degrees; // In revolutions
  double error = target - Inertial.rotation();
  double tP = .25;
  double tD = .1;
  double prevError = error;

  double timeElap = 0;

  while (timeElap < 2000) // 
  {
    error = target - Inertial.rotation();
    double derivative = (error - prevError)/dt;
    double percent = tP * error + tD * derivative;

    Brain.Screen.printAt(20, 40, "Inertial: %f", Inertial.rotation());

    turnMotors(percent);

    vex::task::sleep(dt);
    prevError = error;

    timeElap += dt;
  }
  
  stopMotors();

}