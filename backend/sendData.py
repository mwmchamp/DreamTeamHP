import serial
import time

def send_data_to_bluetooth(port, baudrate, data):
    try:
        # Open the serial port
        with serial.Serial(port, baudrate, timeout=1) as ser:
            print(f"Connected to {port} at {baudrate} baudrate.")
            
            # Send data
            ser.write(data.encode())
            print(f"Sent data: {data}")
            
            # Wait for a response (optional)
            time.sleep(1)
            if ser.in_waiting > 0:
                response = ser.readline().decode().strip()
                print(f"Received response: {response}")
            else:
                print("No response received.")
                
    except serial.SerialException as e:
        print(f"Error: {e}")

# Example usage
if __name__ == "__main__":
    port = "COM3"  # Replace with your Bluetooth serial port
    baudrate = 9600
    data = "Hello Bluetooth"
    send_data_to_bluetooth(port, baudrate, data)
