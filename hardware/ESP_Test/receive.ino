#include <Arduino.h>

const int ledPin = 0; // Pin D0
bool ledState = LOW;

void setup() {
  // Initialize the LED pin as an output
  pinMode(ledPin, OUTPUT);
  digitalWrite(ledPin, ledState);

  // Initialize Serial communication
  Serial.begin(9600);
}

void loop() {
  if (Serial.available() > 0) {
    // Read the incoming byte as a boolean
    char incomingByte = Serial.read();
    if (incomingByte == '1') {
      ledState = HIGH;
    } else if (incomingByte == '0') {
      ledState = LOW;
    }

    // Set the LED state
    digitalWrite(ledPin, ledState);
  }
}
