import './Home';
import { useState, useEffect } from 'react';
import { useHistory, Link, useParams } from 'react-router-dom';
import { findById, save } from '../api/camperApi';


const blankCamper = {

    username: "",
    password: "",
    role: "USER",
    firstName: "",
    lastName: "",
    campingMethod: "",
    address: "",
    city: "",
    state: "",
    zip: "",
    email: "",
    phone: ""
}

function Signup() {
    const [error, setError] = useState();

    const [camper, setCamper] = useState(blankCamper);
    const { camperId } = useParams();
    const history = useHistory();

    useEffect(() => {
        if (camperId) {
            findById(camperId)
                .then(camper => setCamper(camper))
                .catch((err) => history.push("/error", err.toString()));
        }
    }, [camperId, history]);

    const onChange = (evt) => {
        const clone = { ...camper };
        clone[evt.target.name] = evt.target.value;
        setCamper(clone);
        console.log(camper);
    }

    const onSubmit = evt => {
        evt.preventDefault();
        save(camper)
            .then(camper => {
                console.log("save was successful");
                console.log(camper);
                history.push("/");
            })
            .catch((err) => {
                setError(err);
                console.log("save was not successful");
            });
    };

    return <div>
        <div className="w-screen h-screen flex justify-center items-center container">
            <form onSubmit={onSubmit} className="p-10 bg-green-100 bg-opacity-50 rounded flex justify-center items-center flex-col shadow-md z-10">
                <p className="mb-5 text-3xl uppercase font-bold text-green-900 animate-pulse">Create an Account</p>
                <div className="grid-cols-2">
                    {/* username and password at top? */}

                    <input type="text" name="firstName" className="mb-5 p-3 w-80 focus:border-green-700 rounded border-2 outline-none mr-4" autocomplete="off" placeholder="First Name" required
                        value={camper.firstName} onChange={onChange} />
                    <input type="text" name="lastName" className="mb-5 p-3 w-80 focus:border-green-700 rounded border-2 outline-none" autocomplete="off" placeholder="Last Name" required
                        value={camper.lastName} onChange={onChange} />
                </div>
                <div className="grid-cols-4">
                    <input type="text" name="address" className="mb-5 p-3 w-70 focus:border-green-700 rounded border-2 outline-none mr-2" autocomplete="off" placeholder="Street Name" required
                        value={camper.address} onChange={onChange} />
                    <input type="text" name="city" className="mb-5 p-3 w-70 focus:border-green-700 rounded border-2 outline-none mr-2" autocomplete="off" placeholder="City" required
                        value={camper.city} onChange={onChange} />
                    <select value={camper.state} onChange={onChange} className="py-2 mt-2 m-2 bg-gray-100 divide-y  rounded-md w-30 h-12" name="state" type="text" required> {/* format List? Also, `value={camper.state}` problemt */}
                        <option value="" selected="selected"></option>
                        <option value="AL" >Alabama</option>
                        <option value="AK">Alaska</option>
                        <option value="AZ">Arizona</option>
                        <option value="AL">Arkansas</option>
                        <option value="CA">California</option>
                        <option value="CO">Colorado</option>
                        <option value="CT">Connecticut</option>
                        <option value="DE">Delaware</option>
                        <option value="FL">Flordia</option>
                        <option value="GA">Georgia</option>
                        <option value="HI">Hawaii</option>
                        <option value="ID">Idaho</option>
                        <option value="IL">Illinois</option>
                        <option value="IN">Indiana</option>
                        <option value="IA">Iowa</option>
                        <option value="KS">Kansas</option>
                        <option value="KY">Kentucky</option>
                        <option value="LA">Louisiana</option>
                        <option value="ME">Maine</option>
                        <option value="MD">Maryland</option>
                        <option value="MA">Massachusetts</option>
                        <option value="MI">Michigan</option>
                        <option value="MN">Minnesota</option>
                        <option value="MS">Mississippi</option>
                        <option value="MO">Missouri</option>
                        <option value="MT">Montana</option>
                        <option value="NE">Nebraska</option>
                        <option value="NV">Nevada</option>
                        <option value="NH">New Hampshire</option>
                        <option value="NJ">New Jersey</option>
                        <option value="NM">New Mexico</option>
                        <option value="NY">New York</option>
                        <option value="NC">North Carolina</option>
                        <option value="ND">North Dakota</option>
                        <option value="OH">Ohio</option>
                        <option value="OK">Oklahoma</option>
                        <option value="AL">Oregon</option>
                        <option value="PA">Pennsylvania</option>
                        <option value="RI">Rhode Island</option>
                        <option value="SC">South Carolina</option>
                        <option value="SD">South Dakota</option>
                        <option value="TN">Tennessee</option>
                        <option value="TX">Texas</option>
                        <option value="UT">Utah</option>
                        <option value="VT">Vermont</option>
                        <option value="VA">Virginia</option>
                        <option value="WA">Washington</option>
                        <option value="WV">West Virginia</option>
                        <option value="WI">Wisconsin</option>
                        <option value="WY">Wyoming</option>
                    </select>
                    <input type="text" name="zip" className="mb-5 p-3 w-20 focus:border-green-700 rounded border-2 outline-none" autocomplete="off" placeholder="Zip" required
                        value={camper.zip} onChange={onChange} />
                </div>
                <div className="grid-cols-2">
                    <input type="email" name="email" className="mb-5 p-3 w-80 focus:border-green-700 rounded border-2 outline-none mr-4" autocomplete="off" placeholder="Email" required
                        value={camper.email} onChange={onChange} />
                    <input type="text" name="phone" className="mb-5 p-3 w-80 focus:border-green-700 rounded border-2 outline-none" autocomplete="off" placeholder="(xxx)xxx-xxxx" required
                        value={camper.phone} onChange={onChange} />
                </div>
                <div className="grid-cols-2">
                    <input type="text" name="username" className="mb-5 p-3 w-80 focus:border-green-700 rounded border-2 outline-none mr-4" autocomplete="off" placeholder="Username" required
                        value={camper.username} onChange={onChange} />
                    <input type="password" name="password" id="password" className="mb-5 p-3 w-80 focus:border-green-700 rounded border-2 outline-none" autocomplete="off" placeholder="Password" required
                        value={camper.password} onChange={onChange} />
                </div>
                <div>
                    <button className="bg-green-600 hover:bg-green-900 text-white font-bold p-2 rounded w-30 mr-3" id="login" type="submit"><span>Sign up</span></button>
                    <Link to="/" className="bg-gray-600 hover:bg-gray-900 text-white font-bold p-2 rounded w-30" id="login" type="button"><span>Cancel</span></Link>
                </div>

                {error && <div class="bg-red-100 border-l-4 border-red-500 text-red-700 p-4" role="alert">
                    <p class="font-bold">Error</p>
                    <p>An error has occurred: </p>
                    <p>{error}</p>
                </div>}

            </form>
            <img className="fixed object-cover w-full h-full y-0 x-0" src="https://coresites-cdn-adm.imgix.net/mpora_new/wp-content/uploads/2017/01/Cycle-Touring-Essentials-Touring-Bike-at-Camp.jpg?fit=crop"></img>
        </div>
    </div>
    //</form>
}

export default Signup;