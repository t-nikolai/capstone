import { useContext } from "react";
import { Link } from "react-router-dom";
import User from "./UserContext";
import Signup from "./Signup";

function Camper() {
    const camper = useContext(User);

    return(
        <div>
            <h5>{camper.username}</h5> {/* some kind of styling for a banner ?*/}
            <div > {/* row: name info */}
                <div><strong>Name:</strong> {" " + camper.firstName + " " + camper.lastName}</div>
            </div>
            <div > {/* row: address info */}
                <div><strong>Address:</strong> {" " + camper.address + " " + camper.city + 
                    "\n" + camper.state + " " + camper.address}</div>
            </div>
            <div > {/* row: email  */}
                <div><strong>Email:</strong> {" " + camper.email}</div>
            </div>
            <div > {/* row: phone */}
            <div><strong>Phone:</strong> {" " + camper.phone}</div>
            </div>
        </div>
    );
}

export default Camper;