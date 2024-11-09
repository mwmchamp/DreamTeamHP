# script.py
from flask import Flask, request, jsonify
from flask_cors import CORS  # Allows cross-origin requests

app = Flask(__name__)
CORS(app)  # Enable CORS to allow the React app to communicate with Flask

@app.route('/api/equation', methods=['POST'])
def process_equation():
    data = request.json
    equation = data.get("equation")
    # Process the equation here
    new_equation = f"Processed equation: {equation}"
    return jsonify({"new_equation": new_equation})

if __name__ == '__main__':
    app.run(debug=True)