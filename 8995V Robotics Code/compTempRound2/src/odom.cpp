#include "odom.h"
#include "autonHelpers.h"
#include "robot-config.h"

#include <vector>

double lDis = 0.1;
double rDis = 0.1;
double cDis = 0.1;


//converts encoder degrees into length in cm
double degToCm(double deg){
  //diameter of wheel - 2.75 inch (6.985 cm)

  return (deg/360.0) * 6.985;
}


//get angle of robot from tracking wheels
double getAngle(){
  double theta;

  if(leftTrack.position(degrees) > rightTrack.position(degrees)){
    theta = (leftTrack.position(degrees) - rightTrack.position(degrees))/(lDis + rDis);
  } else if(leftTrack.position(degrees) < rightTrack.position(degrees)) {
    theta = (rightTrack.position(degrees) - leftTrack.position(degrees))/(lDis + rDis);
  } else {
    theta = 0;
  }

  return theta;
}
