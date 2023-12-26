#include "gui.h"
#include "autonRoutines.h"
//dimensions: 480x272

int driverMode = 1;
int currColor = 0;

//AUTON
void autonGUI(){
  Brain.Screen.setFont(vex::fontType::mono30);
  Brain.Screen.setFillColor(black);
  Brain.Screen.drawLine(240, 0, 240, 272);

  //right side - driver selection----------------------------------------------
  Brain.Screen.printAt(270, 40, "Driver mode:");
  
  if(driverMode == 0){
    Brain.Screen.printAt(305, 80, "      ");
    Brain.Screen.printAt(320, 80, "Tank");
  } else {
    Brain.Screen.printAt(305, 80, "Arcade");
  }

  Brain.Screen.setFillColor("#808080");
  Brain.Screen.drawRectangle(310, 120, 100, 100);

  //left side - auton selection + color----------------------------------------
  Brain.Screen.setFont(vex::fontType::mono30);
  Brain.Screen.setFillColor(black);
  Brain.Screen.printAt(35, 40, "Autonomous:");

  //color
  if(currColor == 0){
    Brain.Screen.setFillColor(blue);
  } else {
    Brain.Screen.setFillColor(red);
  }
  Brain.Screen.drawRectangle(50, 60, 130, 20);

  //auton routine
  Brain.Screen.setFillColor(black);
  Brain.Screen.printAt(60, 120, "Routine:");

  Brain.Screen.setFont(vex::fontType::mono60);
  Brain.Screen.printAt(105, 200, "%u", currentAut);



}

void switchDriverMode(){
  driverMode++;
  if(driverMode == 2){
    driverMode = 0;
  }
  updateGUI();
}

void switchTeamColor(){
  currColor++;
  if(currColor == 2){
    currColor = 0;
  }
  updateGUI();
}

void updateGUI(){
  autonGUI();
}

void brainAutonButtons(){
  int x = Brain.Screen.xPosition();
  int y = Brain.Screen.yPosition();
  
  if(x >= 310 && x <= 410 && y >= 120 && y <= 220){
    switchDriverMode();
  }

  if(x >= 0 && x <= 180 && y >= 0 && y <= 100){
    switchTeamColor();
  }

  if(x >= 105-50 && x <= 105+50 && y >=200 - 60 && y <= 200 +20){
    switchAut();
  }

}

//DRIVER CONTROL
void displayPatriotism(){
  clearBrain();

  //blue box
  Brain.Screen.setFillColor(blue);
  Brain.Screen.setPenColor(blue);
  Brain.Screen.drawRectangle(0, 0, 240, 120);

  //stripes
  double rect = 0; 
  int start = 240;
  int len = 240;

  for(int i = 0; i<13; i++){
    if(i%2 == 0){
      Brain.Screen.setFillColor(red);
      Brain.Screen.setPenColor(red);
      Brain.Screen.drawRectangle(start, rect, len, 20);
      rect += 20;
    } else {
      Brain.Screen.setFillColor(white);
      Brain.Screen.setPenColor(white);
      Brain.Screen.drawRectangle(start, rect, len, 20);
      rect += 20;
    }
    if(i == 5){
      start = 0;
      len = 480;
    }
  }
}

void displayBrazilia(){
  //green background
  clearBrain();

  Brain.Screen.setFillColor(green);
  Brain.Screen.setPenColor(green);
  Brain.Screen.drawRectangle(0, 0, 480, 272);

  //diamond
  //right triangle
  Brain.Screen.setPenColor(yellow);

  int size = 140;
  int index = 240;
  int y = 50;
  while(size > 0){
    Brain.Screen.drawLine(index, y, index, y+size);
    index++;
    y +=0.5;
    size -= 2;
  }
}

void displayIndia(){
  clearBrain();
  
  //orange
  Brain.Screen.setFillColor(orange);
  Brain.Screen.setPenColor(orange);
  Brain.Screen.drawRectangle(0, 0, 480, 80);
  //white
  Brain.Screen.setFillColor(white);
  Brain.Screen.setPenColor(white);
  Brain.Screen.drawRectangle(0, 80, 480, 80);
  //green
  Brain.Screen.setFillColor(green);
  Brain.Screen.setPenColor(green);
  Brain.Screen.drawRectangle(0, 160, 480, 80);
  //blue center circle
  Brain.Screen.setFillColor(blue);
  Brain.Screen.setPenColor(blue);
  Brain.Screen.drawCircle(240, 120, 40);
}


void displayVelocityLogo(){
  clearBrain();

  Brain.Screen.setPenWidth(20);

  Brain.Screen.drawLine(50, 50, 200, 200);
}


void clearBrain(){
  Brain.Screen.clearScreen();
}