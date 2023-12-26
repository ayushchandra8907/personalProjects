#ifndef AUTONROUTINES_H
#define AUTONROUTINES_H

#include "vex.h"
#include "robot-config.h"
#include "autonHelpers.h"

//selector===========================================
extern int currentAut;
void switchAut();


//ROUTINES===========================================


//nothing auton (auton 0):-------------------------------------------

/*

Does absolutely nothing.

*/
void autonRoute0();


//left side auton (auton 1):-------------------------------------------

/*

Auton for the left side of the field. Goes back and activates rollers, and then stops.

*/

void autonRoute1();


//right side auton (auton 2):-------------------------------------------

/*

Auton for the right side of the field. Goes forward and turns to go back and activate the rollers

*/

void autonRoute2();





#endif