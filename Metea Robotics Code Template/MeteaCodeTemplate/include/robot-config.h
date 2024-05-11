using namespace vex;

extern brain Brain;

// VEXcode devices
extern controller Controller1;
extern motor RFM;
extern motor RMM;
extern motor RBM;
extern motor LFM;
extern motor LMM;
extern motor LBM;
extern motor cata;
extern digital_out wings;
extern inertial inertial;

/**
 * Used to initialize code/tasks/devices added using tools in VEXcode Pro.
 * 
 * This should be called at the start of your int main function.
 */
void  vexcodeInit( void );