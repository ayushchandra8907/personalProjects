#ifndef HELPERS_H
#define HELPERS_h

#include "vex.h"
#include "robot-config.h"


//GENERAL USE========================================================================
void resetAllSensors();

void buttonHold(motor m, bool fwd, bool rev, int pow, vex::brakeType b);
void buttonHold(motor m, bool fwd, int pow, vex::brakeType b);
void buttonHoldVolt(motor m, bool fwd, int pow);


//DRIVE==============================================================================
extern double rPow;
extern double lPow;


//FLYWHEEL===========================================================================
extern double flyPow;

void flyPowIncrease();
void flyPowDecrease();

extern bool flyOn;
void flyTogg();

//ENDGAME============================================================================
extern bool endgameOn;
void endgameTrigger();
vex::brakeType currEndgameBrake();


#endif