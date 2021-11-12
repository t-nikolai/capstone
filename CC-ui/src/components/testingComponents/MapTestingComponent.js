import React, { useRef, useEffect, useState } from 'react';
// import ReactMapboxFactory from 'react-mapbox-gl/lib/map';
// import { Marker } from 'react-map-gl';
import mapboxgl from 'mapbox-gl';

// temp address
// look here for proper formatting... 'https://docs.mapbox.com/help/troubleshooting/address-geocoding-format-guide/'
mapboxgl.accessToken = 'pk.eyJ1IjoiY2MtdGVzdGVyIiwiYSI6ImNrdnI0emNycDJydHUyd3Fndnd4NjJ6eTEifQ.KDlyZRLITFmkrgIqDdzqwQ';

function Map({ sendCampgroundId }) {

  const mapContainerRef = useRef(null);

  // initialize map when component mounts
  useEffect(() => {
    const map = new mapboxgl.Map({
      container: mapContainerRef.current,
      // See style options here: https://docs.mapbox.com/api/maps/#styles
      style: 'mapbox://styles/mapbox/streets-v11',
      center: [-93, 44.8],
      zoom: 9.5
    });


    // add navigation control (the +/- zoom buttons)
    map.addControl(new mapboxgl.NavigationControl(), 'bottom-right');

    mapboxgl.accessToken = 'pk.eyJ1IjoiY2MtdGVzdGVyIiwiYSI6ImNrdnF5dmZjYmV4b2IycXE2aTIyNnBwc3AifQ.woCJ5YPsuTMZpiOciM54qw';

    map.on('load', () => {
      // Add an image to use as a custom marker
      map.loadImage(
        // 'green_pin.png',
        'https://docs.mapbox.com/mapbox-gl-js/assets/custom_marker.png',
        (error, image) => {
          if (error) throw error;
          map.addImage('custom-marker', image);
          // Add a GeoJSON source with 2 points
          map.addSource('points', {
            'type': 'geojson',
            'data': {
              'type': 'FeatureCollection',
              'features': [
                {
                  // (1) Afton Campgrounds
                  'type': 'Feature',
                  'geometry': {
                    'type': 'Point',
                    'coordinates': [
                      -92.790990, 44.848400
                    ]
                  },
                  'properties': {
                    'title': 'Afton Campgrounds',
                    'description': 1
                  }
                },
                {
                  // (2) Town and Contry Campgroud
                  'type': 'Feature',
                  'geometry': {
                    'type': 'Point',
                    'coordinates': [
                      -93.389520, 44.774860
                    ]
                  },
                  'properties': {
                    'title': 'Town and Country Campgroud',
                    'description': 2
                  }
                },
                {
                  // (3) Lebabon Hills Regional Park Campground
                  'type': 'Feature',
                  'geometry': {
                    'type': 'Point',
                    'coordinates': [
                      -93.1865763, 44.7744335
                    ]
                  },
                  'properties': {
                    'title': 'Lebanon Hills Regional Park Campground',
                    'description': 3
                  }
                }
              ]
            }
          });

          // Add a symbol layer
          map.addLayer({
            'id': 'points',
            'interactive': true,
            'type': 'symbol',
            'source': 'points',
            'layout': {
              'icon-image': 'custom-marker',
              // get the title name from the source's "title" property
              'text-field': ['get', 'title'],
              'text-font': [
                'Open Sans Semibold',
                'Arial Unicode MS Bold'
              ],
              'text-offset': [0, 1.25],
              'text-anchor': 'top'
            }
          });
        }
      );
    });

    // When a click event occurs on a feature in the places layer, get campground id, find all campsites in campground then list to side and change title?
    map.on('click', 'points', (e) => {
      const campgroundId = e.features[0].properties.description;
      //pass through to campgrounds component so that 
      console.log("Mapping's campgroundId: " + campgroundId);
      sendCampgroundId(campgroundId);
    });

    // clean up on unmount
    return () => map.remove();
  }, []); // eslint-disable-line react-hooks/exhaustive-deps

  return <div className="map-container m-10 " ref={mapContainerRef} ></div>;
}

export default Map;