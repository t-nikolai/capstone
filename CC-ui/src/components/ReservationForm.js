import './Home';
import { useState, useEffect, useContext } from 'react';
import { BrowserRouter as Router, Switch, useHistory, Link, useParams } from 'react-router-dom';
import { save, findById } from '../api/reservationsApi';
import { findById as findByCamperId } from '../api/camperApi';
import { findByCampgroundId, findById as findByCampsiteId } from '../api/campsiteApi';
import UserContext from './UserContext';
import MakeCalender from './testingComponents/CalenderTestingComponent';

const emptyReservation = {
    startDate: "",
    endDate: "",
    campsite: 0,
    camper: 0,
    total: 0.00
};

const emptyCampground = {
    campgroundId: "",
    name: "name",
    address: "",
    city: "", 
    state: "",
    zip: "",
    phone: "",
    email: "",
    capacity: "",
    standardRate: "",
    weekendRate: ""
};

function Reservation() {

    const user = useContext(UserContext);

    const [error, setError] = useState();

    const [reservation, setReservation] = useState(emptyReservation);
    const [camper, setCamper] = useState();
    const [campsite, setCampsite] = useState();
    const [campground, setCampground] = useState(emptyCampground);
    const { reservationId, campsiteId } = useParams();
    const history = useHistory();

    useEffect(() => {
        if (reservationId) {
            findById(reservationId)
                .then(reservation => setReservation(reservation))
                .catch((err) => history.push("/error", err.toString()));
        }
        findByCamperId(user.credentials.camperId) 
            .then(camper => {
                setCamper(camper);
                console.log("findByCamperId successful");
            })
            .catch(console.error);
        findByCampsiteId(campsiteId)
            .then(campsite => {
                setCampsite(campsite);
                console.log("findByCampsiteId successful");
            })
            .catch(console.error);
            console.log("-------------Campsite Object: " + campsite);
    //     findByCampgroundId(campsite.campgroundId)
    //         .then(c => {
    //             setCampground(c);
    //         })
    //         .catch(console.error);
    //     console.log("-------------Campground Object: " + campground);
     }, [reservationId, history]);

    const onChange = evt => {
        const next = { ...reservation };
        let value = evt.target.value;
        if (evt.target.type === "number") {
            value = parseInt(value, 10);
            if (isNaN(value)) {
                value = evt.target.value;
            }
        }
        next[evt.target.name] = value;
        setReservation(next);
    };

    const onSubmit = evt => {
        evt.preventDefault();
        
        if (camper && campsite) {
            reservation.camper = camper;
            reservation.campsite = campsite;

            console.log(reservation);
            save(reservation)
                .then(reservation => {
                    console.log("reservation save was successful!");
                    console.log(reservation);
                    //history.push("/confirm-reservation");
                    alert("Your reservation has been placed successfully!");
                    history.push("/");
                })
                .catch((err) => {
                    console.log("reservations save was unsuccessful");
                    setError(err);
                });
        }
    };

    return <div>
        <div className="w-screen h-screen flex justify-center items-center container">
            <form onSubmit={onSubmit} className="p-10 bg-green-100 bg-opacity-50 rounded flex justify-center items-center flex-col shadow-md z-10">
                <p className="mb-5 text-3xl uppercase font-bold text-green-900 animate-pulse">Make a reservation</p>
                <div className="grid-rows-2">
                    {/* need to find a way to put these divs side by side */}
                    <div>
                        <label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" for="startDate">
                            Start date
                        </label>
                        <input type="date" name="startDate" className="mb-5 p-3 w-80 focus:border-green-700 rounded border-2 outline-none mr-4" autocomplete="off" required
                            value={reservation.startDate} onChange={onChange} />
                    </div>
                    <div>
                        <label className="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" for="endDate">
                            End date
                        </label>
                        <input type="date" name="endDate" className="mb-5 p-3 w-80 focus:border-green-700 rounded border-2 outline-none" autocomplete="off" required
                            value={reservation.endDate} onChange={onChange} />
                    </div>
                </div>

                {error && <div className="bg-red-100 border-l-4 border-red-500 text-red-700 p-4 mb-4" role="alert">
                    <p className="font-bold">Error</p>
                    <p>An error has occurred: </p>
                    <p>{error}</p>
                </div>  }

                <div>
                    
                    <button className="bg-green-600 hover:bg-green-900 text-white font-bold p-2 rounded w-30 mr-3" id="login" type="submit"><span>Make Reservation</span></button>
                    <Link to="/Campgrounds" className="bg-gray-600 hover:bg-gray-900 text-white font-bold p-2 rounded w-30" id="login" type="submit"><span>Cancel</span></Link>
                </div>

            </form>
            <img className="fixed object-cover w-full h-full y-0 x-0" src="https://coresites-cdn-adm.imgix.net/mpora_new/wp-content/uploads/2017/01/Cycle-Touring-Essentials-Touring-Bike-at-Camp.jpg?fit=crop"></img>
        </div>
    </div>
}

export default Reservation;