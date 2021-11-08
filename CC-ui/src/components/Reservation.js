import './Home';
import { BrowserRouter as Router, Switch, useHistory, Link } from 'react-router-dom';

function Reservation() {
    return <div>
        <div className="w-screen h-screen flex justify-center items-center container">
            <form className="p-10 bg-green-100 bg-opacity-50 rounded flex justify-center items-center flex-col shadow-md z-10">
                <p className="mb-5 text-3xl uppercase font-bold text-green-900 animate-pulse">Make a reservation</p>
                <div className="grid-cols-2">
                    <input type="text" name="campground" class="mb-5 p-3 w-80 focus:border-green-700 rounded border-2 outline-none mr-4" autocomplete="off" placeholder="campground (will autofill)" required />
                    <input type="text" name="campSite" class="mb-5 p-3 w-80 focus:border-green-700 rounded border-2 outline-none" autocomplete="off" placeholder="Camp site (will autofill)" required />
                </div>
                <div>
                    calender will go here? (note: change picture and layout to make more unique)
                </div>
                <div>
                    <button className="bg-green-600 hover:bg-green-900 text-white font-bold p-2 rounded w-30 mr-3" id="login" type="submit"><span>make reservation</span></button>
                    <Link to="/Campgrounds" className="bg-gray-600 hover:bg-gray-900 text-white font-bold p-2 rounded w-30" id="login" type="submit"><span>Cancel</span></Link>
                </div>

            </form>
            <img className="fixed object-cover w-full h-full y-0 x-0" src="https://coresites-cdn-adm.imgix.net/mpora_new/wp-content/uploads/2017/01/Cycle-Touring-Essentials-Touring-Bike-at-Camp.jpg?fit=crop"></img>
        </div>
    </div>
}

export default Reservation;