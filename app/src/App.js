import React, { useState } from 'react';
import axios from 'axios';

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
        <div>
            <input 
                type="text" 
                value={equation} 
                onChange={(e) => setEquation(e.target.value)} 
                placeholder="Enter equation"
            />
            <button onClick={handleSubmit}>Submit</button>
            <p>Response: {response}</p>
        </div>
    );
}

export default App;


/*import logo from './logo.svg';
import './App.css';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
    </div>
  );
}

export default App;*/
