import { useContext } from 'react';
import { Link } from 'react-router-dom';
import UserContext from './UserContext';

function Reservation({ reservation }) {

    const user = useContext(UserContext);

    return (<div className="max-w-sm bg-white px-6 pt-6 pb-2 rounded-xl shadow-xlg transform hover:scale-105 transition duration-500">
            <h3 className="mb-3 text-xl font-bold text-green-600">ReservationId: {reservation.reservationId}</h3>
            <div className="relative">
                <img className="w-full rounded-xl" src="https://thumbs.dreamstime.com/b/camping-cute-bear-trailer-tree-cartoon-isolated-icon-design-camping-cute-bear-trailer-tree-cartoon-isolated-icon-design-vector-177530630.jpg" alt="Colors" />
                <p className="absolute top-0 bg-green-200 text-gray-800 font-semibold py-1 px-3 rounded-br-lg rounded-tl-lg">CampgroundId, CampsiteId</p>
            </div>
            <div className="my-4">
                <div className="flex space-x-1 items-center">
                    <p className="text-xl">{reservation.startDate} - {reservation.endDate}</p>
                </div>
                <div className="flex space-x-1 items-center">
                    <p className="text-lg">${reservation.total}</p>
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