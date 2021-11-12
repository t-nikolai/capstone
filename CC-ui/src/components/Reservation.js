import { useContext, useState, useEffect } from 'react';
import { Link, useHistory } from 'react-router-dom';
import UserContext from './UserContext';
import { findById as findBySiteId } from "../api/campgroundApi";

function Reservation({ reservation }) {

    const user = useContext(UserContext);

    const [camper, setCamper] = useState([]);
    const [campground, setCampground] = useState([]);
    const history = useHistory();

    useEffect(() => {
        console.log("--------show reservation-----------");
        console.log(reservation);
        findBySiteId(reservation.campgroundId)
            .then(campground => setCampground(campground))
            .catch(console.error);
    }, history);

    return (<div className="max-w-sm bg-white px-6 pt-6 pb-2 rounded-xl shadow-xlg transform hover:scale-105 transition duration-500 m-5">
            <h3 className="mb-3 text-xl font-bold text-green-600">Reservation Id: {reservation.reservationId}</h3>
            
                <p className="bg-green-200 text-gray-800 font-semibold py-1 px-3 rounded-br-lg rounded-tl-lg">Campground: {reservation.campsite.campgroundId}, Campsite: {reservation.campsite.siteId}</p>
            
            <div className="my-4">
                <div className="flex space-x-1 items-center">
                    <p className="text-xl"><strong>Start: </strong>{reservation.startDate}</p>
                </div>
                <div className="flex space-x-1 items-center">
                    <p className="text-xl"><strong>End: &nbsp; </strong>{reservation.endDate}</p>
                </div>
                <div className="flex space-x-1 items-center">
                    <p className="text-lg"><strong>Total: </strong> ${reservation.total}</p>
                </div>
                {/* or make these buttons below links to the delete/edit pages with the current id's? & also add roles here for button availability */}
                {(user.role === "USER" || user.role === "ADMIN") &&
                    <button value="button" className="mt-4 text-xl w-auto text-white bg-green-600 py-1.5 px-2 rounded-xl shadow-lg" id="updateButton" onClick="?">Update</button>}
                {(user.role === "ADMIN") &&
                    <button value="button" className="mt-4 text-xl w-auto text-white bg-green-600 py-1.5 px-2 rounded-xl shadow-lg" id="deleteButton" onClick="?">Delete</button>}
            </div>
        </div>
    );
}
    
export default Reservation;