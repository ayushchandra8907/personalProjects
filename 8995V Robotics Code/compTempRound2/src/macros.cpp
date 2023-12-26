#include "macros.h"




//edit voltage method
double flyPow = 10; //default flywheel power
void flyPowIncrease(){
  if(!(flyPow >= 12)){
    flyPow += .1;
  } 
}
void flyPowDecrease(){
  if(!(flyPow <= 0)){
    flyPow -= .1;
  } 
}