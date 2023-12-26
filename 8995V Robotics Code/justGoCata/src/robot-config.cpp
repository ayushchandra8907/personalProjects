#include "vex.h"

using namespace vex;
using signature = vision::signature;
using code = vision::code;

// A global instance of brain used for printing to the V5 Brain screen
brain  Brain;

// VEXcode device constructors
motor RFM = motor(PORT1, ratio6_1, false);
motor RCM = motor(PORT2, ratio6_1, false);
motor RBM = motor(PORT3, ratio6_1, false);
motor LFM = motor(PORT4, ratio6_1, true);
motor LCM = motor(PORT5, ratio6_1, true);
motor LBM = motor(PORT6, ratio6_1, true);
motor cata = motor(PORT7, ratio36_1, false);
motor intake = motor(PORT8, ratio6_1, false);
controller Controller1 = controller(primary);
digital_out cataRight = digital_out(Brain.ThreeWirePort.A);
digital_out cataLeft = digital_out(Brain.ThreeWirePort.B);

// VEXcode generated functions
// define variable for remote controller enable/disable
bool RemoteControlCodeEnabled = true;

/**
 * Used to initialize code/tasks/devices added using tools in VEXcode Pro.
 * 
 * This should be called at the start of your int main function.
 */
void vexcodeInit( void ) {
  // nothing to initialize
}