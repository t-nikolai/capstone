import { useHistory } from "react-router";
import { useContext, useState, useEffect } from 'react';
import UserContext from './UserContext';
import { findAll } from "../api/camperApi";
import Reservation from './Reservation';


function ReservationsLists() {

    const [reservations, setReservations] = useState([]);
    const history = useHistory();

    const user = useContext(UserContext);

    // which reservation's find function? 
    useEffect( () => {
        findAll()       /* findAll for now but can always be findByCampsiteId or something if needed */
            .then(r => setReservations(r))
            .catch((err) => history.push("/error", err.toString() ));
    }, [history]);

    return (
        <div> {/* add user permissions & styling in here if necessary (row/column adjusting for cards on different screen sizes */}
            {reservations.map(reservation => <Reservation key={reservation.reservationId} reservation={reservation}></Reservation>)}
            {/* maybe add in alternative text if you're not logged in - like "can only view reservations if you're logged in" or something */}
        </div>
    );
}

export default ReservationsLists;