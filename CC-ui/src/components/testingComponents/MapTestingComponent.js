import React, {useState} from "react";
//import ReactMapGL from "react-map-gl"; -> will need to run 'npm install react-map-gl'

function Map() {

    const [viewport, setViewPort] = useState(
        //temp address
        //look here for proper formatting... 'https://docs.mapbox.com/help/troubleshooting/address-geocoding-format-guide/'
        {
            street: "6959 Peller Ave S", 
            city: "Hastings",
            state: "MN",
            zip: 55033
        }
    );

    return <div />
/*
<ReactMapGL {...viewport}>
            markers here
            </ReactMapGL>
*/

    }

    export default Map;