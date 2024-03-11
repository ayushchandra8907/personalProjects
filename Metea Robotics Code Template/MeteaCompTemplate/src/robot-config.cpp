#include "vex.h"

using namespace vex;
using signature = vision::signature;
using code = vision::code;

// A global instance of brain used for printing to the V5 Brain screen
brain  Brain;

// VEXcode device constructors
motor RFM = motor(PORT1, ratio18_1, false);
motor RMM = motor(PORT2, ratio18_1, false);
motor RBM = motor(PORT3, ratio18_1, false);
motor LFM = motor(PORT4, ratio18_1, false);
motor LMM = motor(PORT5, ratio18_1, true);
motor LBM = motor(PORT6, ratio18_1, true);
motor cata = motor(PORT7, ratio18_1, false);

// VEXcode generated functions



/**
 * Used to initialize code/tasks/devices added using tools in VEXcode Pro.
 * 
 * This should be called at the start of your int main function.
 */
void vexcodeInit( void ) {
  // nothing to initialize
}