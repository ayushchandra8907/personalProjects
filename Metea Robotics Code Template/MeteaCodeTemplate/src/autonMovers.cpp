#include "autonMovers.h"


//helpers
void powerMotors(double right, double left){
  RFM.spin(forward, right, volt);
  RMM.spin(forward, right, volt);
  RBM.spin(forward, right, volt);

  LFM.spin(forward, left, volt);
  LMM.spin(forward, left, volt);
  LBM.spin(forward, left, volt);
}


//main movement functions
void pidTranslate(double d){
  double kP = 0.0;
  double kI = 0.0;
  double kD = 0.0;


}

void pidTurn(double turnVal){
  
}