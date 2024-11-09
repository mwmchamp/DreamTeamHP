#include <Arduino.h>

const int ledPin = 2; // Pin D2 on ESP8266
bool ledState = LOW;
unsigned long previousMillis = 0;
const long interval = 100; // 100 milliseconds for fast blink

void setup() {
  // Initialize the LED pin as an output
  pinMode(ledPin, OUTPUT);
  digitalWrite(ledPin, ledState);

  // Initialize Serial communication
  Serial.begin(9600);
}

void loop() {
  unsigned long currentMillis = millis();

  if (currentMillis - previousMillis >= interval) {
    previousMillis = currentMillis;

    // Toggle the LED state
    ledState = !ledState;
    digitalWrite(ledPin, ledState);

    // Send the LED state over UART
    if (ledState) {
      Serial.println('1');
    } else {
      Serial.println('0');
    }
  }
}
