import { Link } from "react-router-dom";
import Map from "./testingComponents/MapTestingComponent";
import { useState } from 'react';
import { useHistory } from 'react-router-dom';
import CampsiteCard from './CampsiteCard';
import { findByCampgroundId } from '../api/campsiteApi';
import Camper from "./CamperProfile";

function Campgrounds(credentials) {

    const credential = {...credentials}
    const [campsites, setCampsites] = useState([]);
    const history = useHistory();

    // write fxn that uses campgroundId to return campsites - how to we get campgroundId from Map?

    const sendCampgroundId = (campgroundId) => {
        console.log("Campgrounds campgroundId: " + campgroundId);
        findByCampgroundId(campgroundId)
            .then(sites => setCampsites(sites))
           // .catch((err) => history.push("/error", err.toString()));
           .catch(console.error);
    } 

    return <div >
        <div className="grid grid-cols-3 gap-2 ">
            <div className="container px-6 py-4 mx-auto h-auto bg-yellow-900" >
                <div className="grid gap-6 grid-cols-1">
                    {campsites.map(campsite => <CampsiteCard key={campsite.siteId} campsite={campsite}></CampsiteCard>)}
                </div>
            </div>
            <div className="col-span-2 bg-gradient-to-r from-yelow-900 to-white">
            <h2 className="text-center text-3xl"> Name of campground will appear here when clicked </h2>
                <Map className="mapboxgl-canvas-container" sendCampgroundId={sendCampgroundId} />
            </div>
        </div>
    </div>
}

export default Campgrounds;