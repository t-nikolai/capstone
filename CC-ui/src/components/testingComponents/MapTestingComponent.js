import React, { useState } from "react";
import ReactMapGL from "react-map-gl";

//temp address
//look here for proper formatting... 'https://docs.mapbox.com/help/troubleshooting/address-geocoding-format-guide/'


function Map() {

    const [address, setAddress] = useState({
        street: "6959 Peller Ave S",
        city: "Hastings",
        state: "MN",
        zip: 55033 
    });

    const [viewport, setViewport] = useState({
        width: 400,
        height: 400,
        address: address,
        zoom: 8
    });

    mapboxgl.accessToken = 'pk.eyJ1IjoiY2MtdGVzdGVyIiwiYSI6ImNrdnI0emNycDJydHUyd3Fndnd4NjJ6eTEifQ.KDlyZRLITFmkrgIqDdzqwQ';

    const mapboxClient = mapboxSdk({ accessToken: mapboxgl.accessToken });

    //might have to fo this for each campground
    mapboxClient.geocoding.forwardGeocode({
        query: address,
        autocomplete: false,
        limit: 1
    })
        .send()
        .then((response) => {
            if (
                !response ||
                !response.body ||
                !response.body.features ||
                !response.body.features.length
            ) {
                console.error('Invalid response:');
                console.error(response);
                return;
            }
            const feature = response.body.features[0];

            // Create a marker and add it to the map.
            new mapboxgl.Marker().setLngLat(feature.center).addTo(map);
        });



    return (
        <ReactMapGL
            {...viewport}
            onViewportChange={nextViewport => setViewport(nextViewport)}
        />
    );
}

export default Map;