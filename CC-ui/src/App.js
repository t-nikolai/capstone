import React, { useState, useEffect, useContext } from 'react';
import { BrowserRouter as Router, Switch, useHistory, Link } from 'react-router-dom';
import UserContext from './components/UserContext';
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
import ConfirmReservation from './components/ConfirmReservation';
import CamperList from './components/CamperList';
import CamperProfile from './components/CamperProfile';
import ConfirmDelete from './components/ConfirmDelete';
import Error from './components/Error';
import ReservationForm from './components/ReservationForm';
import ReservationsList from './components/ReservationsList.js';
import CamperView from './components/CamperView';
import CamperUpdate from './components/CamperUpdate';


function App() {

  //const values
  const [credentials, setCredentials] = useState();
  // const[camper, setCamper] = useState();
  const history = useHistory();

  const logout = () => {
    console.log("logout was called");
    setCredentials();
  }

  const login = (creds) => {
    console.log("logged in", creds);
    setCredentials({
      camperId: creds.camperId,
      username: creds.username,
      role: creds.role
    });
    console.log(creds);
  }

  const auth = {
    credentials,
    login: login,
    logout: logout
  }

  return (
    <UserContext.Provider value={auth}>
      <Router>
        <Switch>
          <Route path="/login">
            <Login />
          </Route>

          <Route path="/signup">
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

          {/* <Route path="/camper-profile">
            <CamperProfile />
          </Route> */}

          <Route path="/camper-view">
            {credentials ?
              (credentials.role === 'ADMIN' ? <AdminNavBar /> : <UserNavBar />)
              : <BasicNavBar />}
            <CamperView />
          </Route>

          <Route path="/campers">
            {/* Campers list needs admin credential check (should only appear for admin logins) */}
            {credentials ?
              (credentials.role === 'ADMIN' ? <AdminNavBar /> : <UserNavBar />)
              : <BasicNavBar />}
            {credentials && credentials.role === 'ADMIN' ? <CamperList /> : <Home />}
          </Route>

          <Route path="/reservations-list">
            <ReservationsList />
          </Route>

          <Route path="/reservation-form">
            <ReservationForm />
          </Route>

          <Route path="/camper-update">
            <CamperUpdate />
          </Route>

          <Route path="/reservation/:campsiteId">
            {/* Campgrounds page with required credentials */}
            {credentials && credentials?
              (credentials.role === 'ADMIN' ? <AdminNavBar /> : <UserNavBar />)
              : <BasicNavBar />}
            {credentials ?
              (credentials.role === 'ADMIN' ? <Home /> : <Reservation />)
              : <Signup />}
          </Route>

          <Route path="/confirm-delete">
            <ConfirmDelete />
          </Route>

          <Route path="/confirm-reservation">
            <ConfirmReservation />
          </Route>

          <Route path="/delete/:camperId">
            <ConfirmDelete />
          </Route>

          <Route path="/error">
            <Error />
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