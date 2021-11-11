import { useState, useEffect, useContext } from "react";
import { Link, useParams, useHistory } from "react-router-dom";
import { findById, deleteById } from "../api/camperApi";
import User from "./UserContext";

function ConfirmDelete() {

    const [camper, setCamper] = useState([]);
    const { camperId } = useParams();
    const user = useContext(User);

    const history = useHistory();

    useEffect(() => {
        findById(user.credentials.camperId)
            .then(camper => setCamper(camper))
            .catch((err) => history.push("/error", err.toString()));
    }, history);

    const onDelete = () => {
        deleteById(camper.camperId)
            .then(user.logout)
            .then(() => history.push("/"))
            .catch((err) => history.push("/error", err.toString()));
    }

    return (
        <div>
            <h1>Does this show up?</h1>
            {camper ? <><h2>Delete {camper.username}?</h2>
            <div className="alert alert-danger">
                This will completely delete {camper.firstName + " " + camper.lastName}'s profile.<br />
                Are you sure?
            </div>
            <div className="mt-2">
                <button className="btn btn-danger me-1" onClick={onDelete}>Yes, Delete It!</button>
                <Link to="/" className="btn btn-secondary">No, Cancel</Link>
            </div></> : <img src="https://c.tenor.com/5o2p0tH5LFQAAAAi/hug.gif" alt="" />
            }
        </div>
    );
}

export default ConfirmDelete;