import React, { useState, useEffect, useContext } from 'react';
import { BrowserRouter as Router, Switch, useHistory, Link } from 'react-router-dom';
import UserContext from './components/UserContext.js';
import { Redirect, Route } from 'react-router';

//components
import BasicNavBar from './components/navBar/BasicNavBar';
import UserNavBar from './components/navBar/UserNavBar';
import AdminNavBar from './components/navBar/AdminNavBar';
import Home from './components/Home';
import Login from './components/Login';
import Signup from './components/Signup';
import Campgrounds from './components/Campgrounds';
import Reservation from './components/ReservationForm.js';
import UserContext from './components/UserContext';

function App() {

  //const values
  const [credentials, setCredentials] = useState();
  const history = useHistory();

  //hard coding credentials
  const login = (candidate) => {
    
    // const camper = findByUsername(candidate.username);
    // if (candidate.password === camper.password){     
        
    // }

    //user login
    // if (candidate.username === "user" && candidate.password === "user") {
    //   setCredentials({
    //     username: candidate.username,
    //     role: "USER"
    //   });
    //   //admin login
    // } else if (candidate.username === "admin" && candidate.password === "admin") {
    //   setCredentials({
    //     username: candidate.username,
    //     role: "ADMIN"
    //   });
      //empty login
    // } else {
    // }
  }

  const logout = () => {
    console.log("logout was called");
    setCredentials();
  }

  const auth = {
    credentials,
    login: setCredentials,
    logout: logout
  }

  function setAPIState(method, c) {
    return {
      method: method,
      headers: {
        "Content-Type": "application/json",
        "Accept": "application/json"
      },
      body: JSON.stringify(c)
    }
  }

  return (
    <UserContext.Provider value={auth}>
      <Router>
        <Switch>
          <Route path="/login">
            {/* login in page with required credentials */}
            <Login />
          </Route>

          <Route path="/signup">
            {/* sign up page with required credentials */}
            <Signup />
          </Route>
          
          <Route path="/campgrounds">
            {/* Campgrounds page with required credentials */}
            {credentials ?
              (credentials.role === 'ADMIN' ? <AdminNavBar /> : <UserNavBar />)
              : <BasicNavBar />}
            {credentials && credentials.role === 'ADMIN' ?
              <Home /> : <Campgrounds credentials={credentials}/>}
          </Route>

          <Route path="/reservation">
            {/* Campgrounds page with required credentials */}
            {credentials && credentials?
              (credentials.role === 'ADMIN' ? <AdminNavBar /> : <UserNavBar />)
              : <BasicNavBar />}
            {credentials ?
              (credentials.role === 'ADMIN' ? <Home /> : <Reservation />)
              : <Home />}
          </Route>

          <Route path="/" exact>
            {/* home page links with required credentials */}
            {/* need to add credentials for the navigation bar */}
            {credentials ?
              (credentials.role === 'ADMIN' ? <AdminNavBar /> : <UserNavBar />)
              : <BasicNavBar />}
            <Home />
          </Route>
        </Switch>
      </Router>
    </UserContext.Provider>
  );
}

export default App;
