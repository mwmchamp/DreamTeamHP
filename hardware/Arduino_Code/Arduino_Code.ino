#include <SoftwareSerial.h>

SoftwareSerial BTSerial(10, 11); // RX | TX

void setup() {
  Serial.begin(9600);     // Monitor Serial
  BTSerial.begin(9600);  // HC-05 AT Mode baud rate
  Serial.println("Enter AT commands:");
}

char next;

void loop() {
  if (BTSerial.available()) {
    Serial.write(BTSerial.read());
  }
  if (Serial.available()) {
    next = Serial.read(); 
    if (next == '\n') {
      BTSerial.write("\r\n");
    } else {
    BTSerial.write(next);
   }
    }
    
  }
