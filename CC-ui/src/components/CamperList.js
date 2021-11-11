import Camper from "./CamperProfile";
//import CamperView from './CamperView';
import { useState, useEffect } from 'react';
import { useHistory } from "react-router";
import { UserContext } from './UserContext';
import { findAll } from "../api/camperApi";

function CamperList() {

    const [campers, setCampers] = useState([]);
    const history = useHistory();

    //const user = useContext(UserContext);

    useEffect(() => {
        findAll()
            .then(campers => setCampers(campers))
            .catch((err) => history.push("/error", err.toString()));
    }, [history]);

    return (
        <div className="grid-cols-2">
            {campers.map(c => <Camper camper={c} key={c.camperId} />)}
        </div>
    );
}

export default CamperList;