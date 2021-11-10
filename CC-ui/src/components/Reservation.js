import { useContext } from 'react';
import { Link } from 'react-router-dom';
import UserContext from './UserContext';

function Reservation({ reservation }) {

    const user = useContext(UserContext);

    return <div id="outerDiv" class="w-full md:w-64 justify-center items-center bg-white shadow-lg rounded-lg flex flex-col">
        <div id="innerDiv" class="w-full p-4 justify-start flex flex-col">
            <h4 class="border-b-2 text-3xl" id="cardHeaderResId">Reservation Id: {reservation.reservationId} </h4>
            <p class="my-4" id="startDate">Start Date: {reservation.startDate}</p>
            <p class="my-4" id="endDate">End Date: {reservation.endDate}</p>
            <p class="my-4" id="total">Total: ${reservation.total}</p>
            <p class="my-4" id="campsite">Campsite Id: {reservation.siteId} *insert current site name*</p>
            <p class="my-4" id="campground">Campground: *insert current campground*</p>
            {/* or make these buttons below links to the delete/edit pages with the current id's? & also add roles here for button availability */}
            {(user.role === "USER" || user.role === "ADMIN") &&
            <button value="button" class="my-4 px-4 py-2 text-white hover:bg-blue-700 bg-blue-500" id="updateButton" onClick="?">Update</button>}
            {(user.role === "ADMIN") &&
            <button value="button" class="my-4 px-4 py-2 text-white hover:bg-blue-700 bg-blue-500" id="deleteButton" onClick="?">Delete</button>}
        </div>
</div>
}

export default Reservation;