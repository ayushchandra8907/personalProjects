#ifndef GUI_H
#define GUI_H

#include "vex.h"
#include "robot-config.h"

extern int driverMode;
extern int currColor;


void clearBrain();


void autonGUI();
void switchDriverMode();
void switchTeamColor();
void updateGUI();
void brainAutonButtons();

void displayPatriotism();
void displayBrazilia();
void displayIndia();

void displayVelocityLogo();

#endif