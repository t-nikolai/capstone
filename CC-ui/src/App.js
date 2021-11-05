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

function App() {

  //const values
  const [credentials, setCredentials] = useState();
  const history = useHistory();

  //hard coding credentials
  const login = (canidate) => {
    //user login
    if (canidate.username === "user" && canidate.password === "user") {
      setCredentials({
        username: canidate.username,
        role: "USER"
      });
      //admin login
    } else if (canidate.username === "admin" && canidate.password === "admin") {
      setCredentials({
        username: canidate.username,
        role: "ADMIN"
      });
      //empty login
    } else {
    }
  }

  const logout = () => setCredentials();

  const auth = {
    credentials,
    login: login
  }

  function setAPIState(method, a) {
    return {
      method: method,
      headers: {
        "Content-Type": "application/json",
        "Accept": "application/json"
      },
      body: JSON.stringify(a)
    }
  }

  return (
    <UserContext.Provider value={auth}>
      <Router>
        <Switch>
          <Route path="/" exact>
            {/* home page links with required credentials */}
            {/* need to add credentials for the navigation bar */}
            { credentials ? 
            ( credentials.role === 'ADMIN' ? <AdminNavBar /> : <UserNavBar /> )
                            : <BasicNavBar /> } 
            <Home />
          </Route>
          <Route path="/login">
            {/* login in page with required credentials */}
            <Login />
          </Route>
          <Route path="/signup">
            {/* sign up page with required credentials */}
            <Signup />
          </Route>
        </Switch>
      </Router>
    </UserContext.Provider>

  );
}

export default App;
