#include <Wire.h>
#include "rgb_lcd.h"

rgb_lcd lcd; // Correctly instantiate the lcd object

unsigned long previousMillis = 0;
const long interval = 2000; // 2 seconds
int currentR = 0, currentG = 255, currentB = 0;
int targetR, targetG, targetB;

void setup() {
  // Initialize the LCD
  lcd.begin(16, 2); // Set up the LCD's number of columns and rows
  lcd.setRGB(currentR, currentG, currentB); // Set the initial RGB backlight color

  // Set pin D4 as input
  pinMode(4, INPUT);

  // Initialize Serial communication
  Serial.begin(9600);
}

void loop() {
  unsigned long currentMillis = millis();

  if (currentMillis - previousMillis >= interval) {
    previousMillis = currentMillis;

    // Set new random target color every 2 seconds
    targetR = random(256);
    targetG = random(256);
    targetB = random(256);
  }

  // Gradually fade to the target color
  if (currentR < targetR) currentR++;
  else if (currentR > targetR) currentR--;

  if (currentG < targetG) currentG++;
  else if (currentG > targetG) currentG--;

  if (currentB < targetB) currentB++;
  else if (currentB > targetB) currentB--;

  lcd.setRGB(currentR, currentG, currentB);

  // Read the status of pin D4 and print it to the LCD
  lcd.clear();
  bool pinStatus = digitalRead(4) == HIGH;
  if (pinStatus) {
    lcd.print("D4 is HIGH");
  } else {
    lcd.print("D4 is LOW");
  }
  Serial.println(pinStatus); // Send status as boolean over UART

  delay(25); // Small delay to control the fade speed
}
