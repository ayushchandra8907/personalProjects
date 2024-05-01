#include "helpers.h"

//pneumatics
bool wingsOn = false;
void frontWings() {
  wingsOn = !wingsOn;

  wings.set(wingsOn);
}