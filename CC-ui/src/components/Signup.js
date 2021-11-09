import './Home';
import { useState, useEffect } from 'react';
import { BrowserRouter as Router, Switch, useHistory, Link, useParams } from 'react-router-dom';
import { findById, save } from '../api/camperApi';


const blankCamper = {

    username: "",
    password: "",
    role: "",
    firstName: "",
    lastName: "",
    address: "",
    city: "",
    state: "",
    zip: 0,
    email: "",
    phone: ""
}

function Signup() {
    const[camper, setCamper] = useState(blankCamper);
    const { camperId } = useParams();
    const history = useHistory();

    useEffect(() => {
        if (camperId) {
            findById(camperId)
                .then(camper => setCamper(camper))
                .catch((err) => history.push("/error", err.toString()));
        }
    }, [camperId, history]);

    const onSubmit = evt => {
        evt.preventDefault();
        save(camper);
    };

    return <form onSubmit={onSubmit}>
    <div>
        <div className="w-screen h-screen flex justify-center items-center container">
            <form className="p-10 bg-green-100 bg-opacity-50 rounded flex justify-center items-center flex-col shadow-md z-10">
                <p className="mb-5 text-3xl uppercase font-bold text-green-900 animate-pulse">Create an Account</p>
                <div className="grid-cols-2">
                    <input type="text" name="firstName" className="mb-5 p-3 w-80 focus:border-green-700 rounded border-2 outline-none mr-4" autocomplete="off" placeholder="First Name" required 
                        value={camper.firstName} />
                    <input type="text" name="lastName" className="mb-5 p-3 w-80 focus:border-green-700 rounded border-2 outline-none" autocomplete="off" placeholder="Last Name" required 
                        value={camper.lastName} />
                </div>
                <div className="grid-cols-3">
                    <input type="text" name="street" className="mb-5 p-3 w-70 focus:border-green-700 rounded border-2 outline-none mr-2" autocomplete="off" placeholder="Street Name" required 
                        value={camper.address} />
                    <input type="text" name="city" className="mb-5 p-3 w-70 focus:border-green-700 rounded border-2 outline-none mr-2" autocomplete="off" placeholder="City" required 
                        value={camper.city} />
                    <input type="text" name="state" className="mb-5 p-3 w-20 focus:border-green-700 rounded border-2 outline-none mr-2" autocomplete="off" placeholder="State" required 
                        value={camper.state} />
                    <input type="text" name="zip" className="mb-5 p-3 w-20 focus:border-green-700 rounded border-2 outline-none" autocomplete="off" placeholder="Zip" required 
                        value={camper.zip} />
                </div>
                <div className="grid-cols-2">
                    <input type="email" name="email" className="mb-5 p-3 w-80 focus:border-green-700 rounded border-2 outline-none mr-4" autocomplete="off" placeholder="Email" required 
                        value={camper.email} />
                    <input type="number" name="phone" className="mb-5 p-3 w-80 focus:border-green-700 rounded border-2 outline-none" autocomplete="off" placeholder="Phone#" required 
                        value={camper.phone} />
                </div>
                <div className="grid-cols-2">
                    <input type="text" name="username" className="mb-5 p-3 w-80 focus:border-green-700 rounded border-2 outline-none mr-4" autocomplete="off" placeholder="Username" required 
                        value={camper.username} />
                    <input type="password" name="password" id="password" className="mb-5 p-3 w-80 focus:border-green-700 rounded border-2 outline-none" autocomplete="off" placeholder="Password" required 
                        value={camper.password} />
                </div>
                <div>
                    <button className="bg-green-600 hover:bg-green-900 text-white font-bold p-2 rounded w-30 mr-3" id="login" type="submit"><span>Sign up</span></button>
                    <Link to="/" className="bg-gray-600 hover:bg-gray-900 text-white font-bold p-2 rounded w-30" id="login" type="submit"><span>Cancel</span></Link>
                </div>

            </form>
            <img className="fixed object-cover w-full h-full y-0 x-0" src="https://coresites-cdn-adm.imgix.net/mpora_new/wp-content/uploads/2017/01/Cycle-Touring-Essentials-Touring-Bike-at-Camp.jpg?fit=crop"></img>
        </div>
    </div>
    </form>
}

export default Signup;