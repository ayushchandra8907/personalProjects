#ifndef HELPERS_H
#define HELPERS_H

#include "vex.h"
#include "robot-config.h"

//helpers
void powerMotors(double right, double left);



//main movement functions
void pidTranslate(double d);
void pidTurn(double turnVal);



#endif