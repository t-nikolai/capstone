import Camper from "./CamperProfile";
import { useState, useEffect, useContext } from "react";
import { useHistory } from "react-router";
import User from "./UserContext";
import { findById } from "../api/camperApi";
import { Link } from "react-router-dom";

function CamperView(){

    const [camper, setCamper] = useState([]);
    const history = useHistory();

    const user = useContext(User);

    useEffect(() => {
        console.log("--------show user-----------");
        console.log(user.credentials.camperId);
        findById(user.credentials.camperId)
            .then(camper => setCamper(camper))
            .catch(console.error);
        console.log("-----------show camper------------");
        console.log(camper);
    }, history);

    return (
        <div>
            {/* {campers.map(c => <Camper camper={c} key={c.camperId} />)} */}

            <div className="bg-white block py-10">
            <div className="max-w-2xl mx-auto">

                <div className="w-full">
                    <div className="w-full bg-green-600 h-48 rounded-t-lg"> {/* Dark green border */}
                    </div>
                    <div className="absolute -mt-20 ml-5">
                        <div className="bg-gray-300 border border-gray-300 h-36 w-40 rounded-lg shadow-md border-b border-primary"> {/* contains photo */}
                            <img className="fill-current h-40 w-40 mr-2" width="60" height="54" viewBox="0 0 54 54" src="/images/tentIcon-grey.png" alt="tentIcon-grey" /> {/* temporary photo (will most likly change) */}
                        </div>
                    </div>
                </div>
                <div> {/* contains user info */}
                    <div className="bg-primary border border-primary rounded-b-lg p-5 pt-20 flex flex-col">
                        <h5 className="mb-1 bg-green-100 w-auto h-10 text-justify text-4xl">{camper.username}</h5>
                    </div>
                    <div className="my-3 bg-green-100 h-8 w-auto text-xl mx-5 "> {/* row: name info */}
                        <strong>Name:</strong> {" " + camper.firstName + " " + camper.lastName}</div>
                    <div className="my-3 bg-green-100 h-8 w-auto text-xl mx-5 "> {/* row: address info */}
                        <strong>Address:</strong> {" " + camper.address + " " + camper.city +
                            "\n" + camper.state + " " + camper.zip}</div>
                    <div className="my-3 bg-green-100 h-8 w-auto text-xl mx-5 "> {/* row: email info */}
                        <strong>Email:</strong> {" " + camper.email}</div>
                    <div className="my-3 bg-green-100 h-8 w-auto text-xl mx-5 "> {/* row: phone info */}
                        <strong>Phone:</strong> {" " + camper.phone}</div>
                    <div className="float-right"> {/* button here will allow user to update their profile (figure out how later) */}
                    <Link to="/camper-update" type="button" className="inline-block text-md px-6 py-3 leading-none border rounded text-black bg-gray-400 hover:border-transparent hover:bg-green-600 mt-4 mr-5 lg:mt-0" >Update</Link>
                    <Link to={`/delete/${camper.camperId}`} type="button" className="inline-block text-md px-6 py-3 leading-none border rounded text-black bg-gray-400 hover:border-transparent hover:bg-red-600 mt-4 mr-5 lg:mt-0" >Delete</Link>
                    </div>
                    
                </div>
            </div>
        </div>

        </div>
    );
}

export default CamperView;
