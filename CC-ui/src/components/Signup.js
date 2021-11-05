import './Home';
import { BrowserRouter as Router, Switch, useHistory, Link } from 'react-router-dom';

function Signup() {
    return <div>
        <div className="w-screen h-screen flex justify-center items-center container">
            <form className="p-10 bg-green-100 bg-opacity-50 rounded flex justify-center items-center flex-col shadow-md z-10">
                <p className="mb-5 text-3xl uppercase font-bold text-green-900 animate-pulse">Create an Account</p>
                <div className="grid-cols-2">
                    <input type="text" name="firstName" class="mb-5 p-3 w-80 focus:border-green-700 rounded border-2 outline-none mr-4" autocomplete="off" placeholder="First Name" required />
                    <input type="text" name="lastName" class="mb-5 p-3 w-80 focus:border-green-700 rounded border-2 outline-none" autocomplete="off" placeholder="Last Name" required />
                </div>
                <div className="grid-cols-3">
                    <input type="text" name="street" class="mb-5 p-3 w-70 focus:border-green-700 rounded border-2 outline-none mr-2" autocomplete="off" placeholder="Street Name" required />
                    <input type="text" name="city" class="mb-5 p-3 w-70 focus:border-green-700 rounded border-2 outline-none mr-2" autocomplete="off" placeholder="City" required />
                    <input type="text" name="state" class="mb-5 p-3 w-20 focus:border-green-700 rounded border-2 outline-none mr-2" autocomplete="off" placeholder="State" required />
                    <input type="text" name="zip" class="mb-5 p-3 w-20 focus:border-green-700 rounded border-2 outline-none" autocomplete="off" placeholder="Zip" required />
                </div>
                <div className="grid-cols-2">
                    <input type="email" name="email" class="mb-5 p-3 w-80 focus:border-green-700 rounded border-2 outline-none mr-4" autocomplete="off" placeholder="Email" required />
                    <input type="number" name="phone" class="mb-5 p-3 w-80 focus:border-green-700 rounded border-2 outline-none" autocomplete="off" placeholder="Phone#" required />
                </div>
                <div className="grid-cols-2">
                    <input type="text" name="username" class="mb-5 p-3 w-80 focus:border-green-700 rounded border-2 outline-none mr-4" autocomplete="off" placeholder="Username" required />
                    <input type="password" name="password" id="password" class="mb-5 p-3 w-80 focus:border-green-700 rounded border-2 outline-none" autocomplete="off" placeholder="Password" required />
                </div>
                <div>
                    <button className="bg-green-600 hover:bg-green-900 text-white font-bold p-2 rounded w-30 mr-3" id="login" type="submit"><span>Sign up</span></button>
                    <Link to="/" className="bg-gray-600 hover:bg-gray-900 text-white font-bold p-2 rounded w-30" id="login" type="submit"><span>Cancel</span></Link>
                </div>

            </form>
            <img className="fixed object-cover w-full h-full y-0 x-0" src="https://coresites-cdn-adm.imgix.net/mpora_new/wp-content/uploads/2017/01/Cycle-Touring-Essentials-Touring-Bike-at-Camp.jpg?fit=crop"></img>
        </div>
    </div>
}

export default Signup;