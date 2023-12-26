#ifndef HELPERS_H
#define HELPERS_h

#include "vex.h"
#include "robot-config.h"

void buttonHold(motor m, bool fwd, bool rev, int pow, vex::brakeType b);
void buttonHold(motor m, bool fwd, int pow, vex::brakeType b);
void buttonHoldVolt(motor m, bool fwd, int pow);

#endif