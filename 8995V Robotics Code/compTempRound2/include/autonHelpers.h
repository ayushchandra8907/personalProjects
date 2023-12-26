#ifndef AUTONHELPERS_H
#define AUTONHELPERS_H

#include "vex.h"
#include "robot-config.h"

//setter
//void setDrive(double left, double right);

//tracking wheels
void clearTrackingWheels();
double getTrackPos(vex::rotationUnits u);

//move forward and backwards
void translate(double d, vex::rotationUnits units, double voltage);
void autTranslate(double d, vex::rotationUnits units, double voltage);

//turn left or right
void rotate(double deg, double speed);
void autRotate(double deg, double speed);


#endif