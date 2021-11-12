import Camper from "./CamperProfile";
import { useState, useEffect, useContext } from "react";
import { useHistory } from "react-router";
import User from "./UserContext";
import { findById, save } from "../api/camperApi";
import Error from "./Error";
import { Link, useParams } from 'react-router-dom';

function CamperUpdate(){
    const [error, setError] = useState();

    const { camperId } = useParams();
    const [camper, setCamper] = useState([]);
    const history = useHistory();

    const user = useContext(User);

    useEffect(() => {
        findById(user.credentials.camperId)
            .then(camper => setCamper(camper))
            .catch((err) => history.push("/error", err.toString()));
    }, [camperId, history]);

    const onChange = (evt) => {
        const clone = { ...camper };
        clone[evt.target.name] = evt.target.value;
        setCamper(clone);
    }

    const onSubmit = evt => {
        evt.preventDefault();
        save(camper)
            .then(camper => {
                history.push("/camper-view");
            })
            .catch((err) => {
                setError("invalid phone number or zip code");
            });
    };

    return (
        <div>
            <form onSubmit={onSubmit} className="p-10 bg-opacity-50 rounded flex justify-center items-center flex-col z-10">
            <div className="bg-green-100 block py-10">
            <div className="max-w-2xl mx-auto">

                <div className="w-full">
                    <div className="w-full bg-green-600 h-48 rounded-t-lg"> {/* Dark green border */}
                    </div>
                    <div className="absolute -mt-20 ml-5">
                        <div className="bg-gray-300 border h-36 w-40 rounded-lg shadow-md border-b border-primary"> {/* contains photo */}
                            <img className="fill-current h-40 w-40 mr-2" width="60" height="54" viewBox="0 0 54 54" src="/images/tentIcon-grey.png" alt="tentIcon-grey" /> {/* temporary photo (will most likly change) */}
                        </div>
                    </div>
                </div>
                <div> {/* contains user info */}
                    <div className="bg-primary border rounded-b-lg p-5 pt-20 flex flex-col">
                        <h5 className="mb-1 bg-green-100 w-auto h-10 text-justify text-4xl">{camper.username}</h5>
                    </div>

                    <div className="my-3 h-8 w-auto text-xl mx-5 "> {/* row: name info */}
                        <input type="text" name="firstName" className="mb-5 p-3 w-72 h-10 focus:border-green-700 rounded border-2 outline-none mr-4" autocomplete="off" required value={camper.firstName} onChange={onChange} />
                        <input type="text" name="lastName" className="mb-5 p-3 w-72 h-10 focus:border-green-700 rounded border-2 outline-none mr-4" autocomplete="off" required value={camper.lastName} onChange={onChange} />
                    </div>

                    <div className="grid-cols-4">
                    <input type="text" name="address" className="mb-5 p-3 w-70 focus:border-green-700 rounded border-2 outline-none mr-2" autocomplete="off" placeholder="Street Name" required
                        value={camper.address} onChange={onChange} />
                    <input type="text" name="city" className="mb-5 p-3 w-70 focus:border-green-700 rounded border-2 outline-none mr-2" autocomplete="off" placeholder="City" required
                        value={camper.city} onChange={onChange} />
                    <select value={camper.state} onChange={onChange} className="py-2 mt-2 m-2 bg-gray-100 divide-y focus:boarder-green-700 rounded-md w-30 h-12" name="state" type="text" required> {/* format List? Also, `value={camper.state}` problemt */}
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

                    {error && <div className="bg-red-100 border-l-4 border-red-500 text-red-700 p-4 mb-4" role="alert">
                    <p className="font-bold">Error</p>
                    <p>An error has occurred: </p>
                    <p>{error}</p>
                </div>  }

                    <div className="float-right"> {/* button here will allow user to update their profile (figure out how later) */}
                        <button className="bg-green-600 hover:bg-green-900 text-white font-bold p-2 rounded w-30 mr-3" id="update" type="submit"><span>Save</span></button>
                        <Link to="/camper-view" type="button" className="inline-block text-md px-6 py-3 leading-none border rounded text-black bg-gray-400 hover:border-transparent hover:bg-red-600 mt-4 mr-5 lg:mt-0" >Cancel</Link>
                    </div>
                </div>
            </div>
            </div>
            </form>
        </div>
    );
}

export default CamperUpdate;
