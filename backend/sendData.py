import serial
import time

import sys
import select

def send_data_to_bluetooth(port, baudrate):
    

    # try:
    #     # Open the serial port
    #     with serial.Serial(port, baudrate, timeout=1) as ser:
    #         print(f"Connected to {port} at {baudrate} baudrate.")
    #         
    #         # Prompt user input once
    #         print("Enter data to send (or 'exit' to quit): ", end='', flush=True)
    #         
    #         while True:
    #             # Check for incoming data
    #             if ser.in_waiting > 0:
    #                 response = ser.readline().decode().strip()
    #                 print(f"Received: {response}")
    #             
    #             # Non-blocking user input
    #             ready, _, _ = select.select([sys.stdin], [], [], 0.1)
    #             if ready:
    #                 user_input = sys.stdin.readline().strip()
    #                 if user_input.lower() == 'exit':
    #                     print("Exiting...")
    #                     break
    #                 
    #                 # Send user input data
    #                 ser.write(user_input.encode())
    #                 print(f"Sent: {user_input}")
    #                 # Prompt again after sending
    #                 print("Enter data to send (or 'exit' to quit): ", end='', flush=True)
                
    except serial.SerialException as e:
        print(f"Error: {e}")


# Example usage
if __name__ == "__main__":
    import serial.tools.list_ports

    def find_bluetooth_port():
        port = None
        ports = serial.tools.list_ports.comports()
        for p in ports:
            print(p.device)
            if 'hc-05' in p.device.lower():
                port = p.device
                print("yay" + port)
                break

        if port is None:
            print("No Bluetooth device found.")
            raise Exception("No Bluetooth device found.")
        return port

    port = find_bluetooth_port()
    baudrate = 9600
    data = "Hello Bluetooth"
    send_data_to_bluetooth(port, baudrate)
