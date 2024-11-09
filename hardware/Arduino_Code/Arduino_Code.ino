#include <Wire.h>
#include "rgb_lcd.h"

rgb_lcd lcd; // Correctly instantiate the lcd object

unsigned long previousMillis = 0;
const long interval = 2000; // 2 seconds
int currentR = 0, currentG = 255, currentB = 0;
int targetR, targetG, targetB;

bool taken;

void setup() {
  // Initialize the LCD
  lcd.begin(16, 2); // Set up the LCD's number of columns and rows
  lcd.setRGB(currentR, currentG, currentB); // Set the initial RGB backlight color

  // Set pin D4 as input
  pinMode(4, INPUT);
}

int mins_till(next_hrs, next_mins, cur_hrs, cur_mins) {
  int hrs_diff = (next_hrs - cur_hrs + 24) % 24;
  int mins_diff = next_mins - cur_mins;
  if(hrs_diff == 0 && mins_dif < 0){
    hrs_diff = 24;
  }
  return hrs_diff * 60 + mins_diff;
}

void set_color(int time_left, int cur_secs){
  int R = 256 * (600 - 60 * time_left - cur_secs) / 600;
  int G = 256 * (60 * time_left + cur_secs) / 60;
  lcd.setRGB(R, G, 0);
}

void flash() {

}

void loop() {
  
  string next_pill;
  int next_hrs;
  int next_mins;
  int cur_hrs;
  int cur_mins;
  int cur_secs;
  // get these values + taken from bluetooth
  
  lcd.clear();
  lcd.setCursor(0, 0);
  lcd.print(next_pill);
  lcd.setCursor(0, 1);
  lcd.print(next_hrs + ": " + next_mins);

  int time_left = mins_till(next_hrs, next_mins, cur_hrs, cur_mins);

  if(time_left <= 10 && !taken) {
    set_color(time_left, cur_secs);
    flash();
  } else {
    lcd.setRGB(0, 255, 0);
  }
  
  if (digitalRead(4) == LOW) {
    // Send that the pill has been taken
    flash();
  }

  delay(25); // Small delay to control the fade speed
}
