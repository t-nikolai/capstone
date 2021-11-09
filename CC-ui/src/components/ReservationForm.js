import './Home';
import { useState, useEffect, useContext } from 'react';
import { BrowserRouter as Router, Switch, useHistory, Link, useParams } from 'react-router-dom';
import { save, findById } from '../api/reservationsApi';
import UserContext from './UserContext';
import MakeCalender from './testingComponents/CalenderTestingComponent';

const emptyReservation = {
    startDate: "",
    endDate: "",
    campsiteId: 0,
    camperId: 0,
    total: 0.00
};

function Reservation() {

    const [reservation, setReservation] = useState(emptyReservation);       // empty reservation?
    const { reservationId } = useParams();
    const history = useHistory();

    const user = useContext(UserContext);

    useEffect( () => {
        if(reservationId) {
            findById(reservationId)
                .then(reservation => setReservation(reservation))
                .catch( (err) => history.push("/error", err.toString() ));
        }
    }, [reservationId, history]);

    const onChange = evt => {
        const next = { ...reservation };
        let value = evt.target.value;
        if(evt.target.type === "number") {
            value = parseInt(value, 10);
            if(isNaN(value)) {
                value = evt.target.value;
            }
        }
        next[evt.target.name] = value;
        setReservation(next);
    };

    const onSubmit = evt => {
        evt.preventDefault();
        save(reservation)
            .then( () => history.push("/")) // push to confirmation page instead of home page?
            .catch( (err) => history.push("/error", err.toString() ));
    };

    return <div>
        <div className="w-screen h-screen flex justify-center items-center container">
            <form onSubmit={onSubmit} className="p-10 bg-green-100 bg-opacity-50 rounded flex justify-center items-center flex-col shadow-md z-10">
                <p className="mb-5 text-3xl uppercase font-bold text-green-900 animate-pulse">Make a reservation</p>
                <div className="grid-cols-2">
                    <input type="text" name="campground" className="mb-5 p-3 w-80 focus:border-green-700 rounded border-2 outline-none mr-4" autocomplete="off" placeholder="campground (will autofill)" required />
                    <input type="text" name="campSite" className="mb-5 p-3 w-80 focus:border-green-700 rounded border-2 outline-none" autocomplete="off" placeholder="Camp site (will autofill)" required />
                </div>
                <div>
                    calender will go here? (note: change picture and layout to make more unique)
                    <MakeCalender />
                </div>
                <div>
                    ()
                    <button className="bg-green-600 hover:bg-green-900 text-white font-bold p-2 rounded w-30 mr-3" id="login" type="submit"><span>Make Reservation</span></button>
                    <Link to="/Campgrounds" className="bg-gray-600 hover:bg-gray-900 text-white font-bold p-2 rounded w-30" id="login" type="submit"><span>Cancel</span></Link>
                </div>

            </form>
            <img className="fixed object-cover w-full h-full y-0 x-0" src="https://coresites-cdn-adm.imgix.net/mpora_new/wp-content/uploads/2017/01/Cycle-Touring-Essentials-Touring-Bike-at-Camp.jpg?fit=crop"></img>
        </div>
    </div>
}

export default Reservation;