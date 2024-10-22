import React from 'react';
import logo from './logo.svg';
import './App.css';
import Algebrite from 'algebrite';

function App() {
    const expr = 'x^2 + 2*x + 1';
    const simplified = Algebrite.simplify(expr).toString();
    console.log(`Simplified Expression: ${simplified}`);

    const equation = 'x^2 - 4';
    const solution = Algebrite.roots(equation).toString();
    console.log(`Solutions for x: ${solution}`);

    const integral = Algebrite.integral('x^2', 'x').toString();
    console.log(`Integral: ${integral}`);

    const toFactor = 'x^2 - 4';
    const factored = Algebrite.factor(toFactor).toString();
    console.log(`Factored form: ${factored}`);

    return (
        <div className="App">
            <header className="App-header">
                <img src={logo} className="App-logo" alt="logo" />
                <p>
                    Edit <code>src/App.tsx</code> and save to reload.
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

export default App;
