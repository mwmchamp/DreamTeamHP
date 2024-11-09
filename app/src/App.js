import React, { useState } from 'react';
import axios from 'axios';
import './App.css'; // Assuming you have some CSS for styling

function App() {
    const [equation, setEquation] = useState('');
    const [response, setResponse] = useState('');

    const handleSubmit = async () => {
        try {
            const res = await axios.post('/api/equation', { equation });
            setResponse(res.data.new_equation);
        } catch (error) {
            console.error(error);
        }
    };

    return (
        <div className="app-container" style={{ backgroundColor: '#f0f8ff', padding: '20px', borderRadius: '8px' }}>
            <h1 className="app-title" style={{ color: '#333', textAlign: 'center' }}>Equation Processor</h1>
            <div className="input-container" style={{ marginBottom: '20px', textAlign: 'center' }}>
                <input 
                    type="text" 
                    value={equation} 
                    onChange={(e) => setEquation(e.target.value)} 
                    placeholder="Enter equation"
                    className="equation-input"
                    style={{ padding: '10px', borderRadius: '4px', border: '1px solid #ccc', width: '80%' }}
                />
                <button 
                    onClick={handleSubmit} 
                    className="submit-button" 
                    style={{ marginLeft: '10px', padding: '10px 20px', backgroundColor: '#4CAF50', color: 'white', border: 'none', borderRadius: '4px', cursor: 'pointer' }}
                >
                    Submit
                </button>
            </div>
            <div className="response-container" style={{ textAlign: 'center', color: '#555' }}>
                <p className="response-text" style={{ fontSize: '18px' }}>Response: {response}</p>
            </div>
        </div>
    );
}

export default App;
