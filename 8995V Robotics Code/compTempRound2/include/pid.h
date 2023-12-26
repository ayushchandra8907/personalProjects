#ifndef PID_H
#define PID_H



#include "vex.h"
#include "robot-config.h"


//helper
double getPIDpos();
void powerMotors(double p);
void turnMotors(double p);
void stopMotors();

//methods
void pidTranslate(double target);
void pdTurn(double deg);

#endif