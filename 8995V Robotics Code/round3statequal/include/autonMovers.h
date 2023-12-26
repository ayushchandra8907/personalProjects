#ifndef AUTONMOVERS_H
#define AUTONMOVERS_H

#include "vex.h"
#include "robot-config.h"


//HELPERS==================================================================
//tracking wheels
void clearTrackingWheels();
double getPIDpos();

//motors
void powerMotors(double p);
void turnMotors(double p);
void setMotors(double p);
void stopMotors(vex::brakeType b);

//REGULAR MOVEMENT========================================================
void autTranslate(double tim, double pow, bool rev, vex::brakeType b);

//PID MOVEMENT============================================================
void pidTranslate(double target);
void pidTurn(double deg);


#endif