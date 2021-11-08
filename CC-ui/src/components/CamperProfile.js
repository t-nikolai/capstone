import { useContext } from "react";
import { Link } from "react-router-dom";
import User from "./UserContext";
import Signup from "./Signup";

function Camper({ camper }) {
    const auth = useContext(User);

    return(
        <div>
            <h5>{camper.username}</h5>

        </div>
    );
}

export default Camper;