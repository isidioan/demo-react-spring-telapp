import React, { Component } from 'react';
import './App.css';
import NavBar from "./NavBar";
import CallerList from "./CallerList";

class App extends Component {



    render()
    {

        return (
            <div className="App">
                <NavBar/>
                <div className="col-md-3 listgroup">
                <CallerList/>
                </div>
                <div className="col-md-10">

                </div>
            </div>
        );
    }
}

export default App;
