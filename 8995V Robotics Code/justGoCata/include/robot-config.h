using namespace vex;

extern brain Brain;

// VEXcode devices
extern motor RFM;
extern motor RCM;
extern motor RBM;
extern motor LFM;
extern motor LCM;
extern motor LBM;
extern motor cata;
extern motor intake;
extern controller Controller1;
extern digital_out cataRight;
extern digital_out cataLeft;

/**
 * Used to initialize code/tasks/devices added using tools in VEXcode Pro.
 * 
 * This should be called at the start of your int main function.
 */
void  vexcodeInit( void );