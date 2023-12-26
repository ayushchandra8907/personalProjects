using namespace vex;

extern brain Brain;

// VEXcode devices
extern controller Controller1;
extern motor RFM;
extern motor RBM;
extern motor LFM;
extern motor LBM;
extern encoder rightTrack;
extern encoder centTrack;
extern encoder leftTrack;
extern motor intake;
extern motor indexer;
extern motor fly1;
extern motor endgame;
extern inertial inert1;
extern distance distSense;

/**
 * Used to initialize code/tasks/devices added using tools in VEXcode Pro.
 * 
 * This should be called at the start of your int main function.
 */
void  vexcodeInit( void );