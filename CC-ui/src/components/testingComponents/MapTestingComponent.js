// //import React, { useState } from "react";
// import React, { useRef, useEffect } from 'react';
// import ReactMapboxFactory from 'react-mapbox-gl/lib/map';
// import { Marker } from 'react-mapbox-gl';
// import mapboxgl from 'mapbox-gl';

// // temp address
// // look here for proper formatting... 'https://docs.mapbox.com/help/troubleshooting/address-geocoding-format-guide/'
// mapboxgl.accessToken = 'pk.eyJ1IjoiY2MtdGVzdGVyIiwiYSI6ImNrdnI0emNycDJydHUyd3Fndnd4NjJ6eTEifQ.KDlyZRLITFmkrgIqDdzqwQ';

// function Map() {

//     const mapContainerRef = useRef(null);

//   // initialize map when component mounts
//   useEffect(() => {
//     const map = new mapboxgl.Map({
//       container: mapContainerRef.current,
//       // See style options here: https://docs.mapbox.com/api/maps/#styles
//       style: 'mapbox://styles/mapbox/streets-v11',
//       center: [45, -90],
//       zoom: 12.5,
//     });

//     // add navigation control (the +/- zoom buttons)
//     map.addControl(new mapboxgl.NavigationControl(), 'bottom-right');

//     mapboxgl.Marker(<div className="marker" />).setLngLat({
//       longitude: 90,
//       latitude: 90
//     }).addTo(map); 

//     // clean up on unmount
//     return () => map.remove();
//   }, []); // eslint-disable-line react-hooks/exhaustive-deps

//   return <div className="map-container m-10 " ref={mapContainerRef} >
    
//     </div>;

// }

// export default Map;