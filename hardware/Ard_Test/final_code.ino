#include <Wire.h>
#include "rgb_lcd.h"

#define button 4
#define hvil 3

rgb_lcd lcd; // Correctly instantiate the lcd object

unsigned long previousMillis = 0;
const long interval = 2000; // 2 seconds
int currentR = 0, currentG = 255, currentB = 0;
int targetR, targetG, targetB;

void setup() {
  // Initialize the LCD
  lcd.begin(16, 2); // Set up the LCD's number of columns and rows
  lcd.setRGB(currentR, currentG, currentB); // Set the initial RGB backlight color
  pinMode(hvil, INPUT_PULLUP);
  pinMode(button, INPUT_PULLUP);

  // Set pin D4 as input
  pinMode(4, INPUT);

  // Initialize Serial communication
  Serial.begin(9600);
}

int state = 0;
int nextTime;

void loop() {
  unsigned long currentMillis = millis();

  nextTime = 3 - state;

  lcd.clear();

  if (digitalRead(hvil) == LOW) {
    lcd.setRGB(255, 255, 0); // Yellow
    lcd.setCursor(0, 0);
    lcd.print("CASE OPEN");
  } else if (state == 3) {
    if ((currentMillis / 500) % 2 == 0) {
      lcd.setRGB(255, 0, 0); // Red
    } else {
      lcd.setRGB(255, 255, 0); // Yellow
    }
    lcd.setCursor(0, 0);
    lcd.print("PILL OVERDUE");
    lcd.setCursor(0, 1);
    lcd.print("By 1 Minute");
  } else {
    lcd.setRGB(state * 127, 255 - (64 * state), 0); // color
    lcd.setCursor(0, 0);
    lcd.print("Next Pill");
    lcd.setCursor(0, 1);
    lcd.print(nextTime);
    lcd.print(" Minutes");
  }

  bool pinStatus = digitalRead(button) == HIGH;
  Serial.println(pinStatus); // Send status as boolean over UART

  if (pinStatus) {
    state = (state + 1) % 4;
    while (digitalRead(button) == HIGH) {delay(10);}
  }

  delay(25); // Small delay to control the fade speed
}
