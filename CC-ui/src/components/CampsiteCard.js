import { Link, useHistory } from 'react-router-dom';
import { useContext, useEffect, useState } from 'react';
import User from './UserContext';
import { findById } from '../api/campgroundApi';

function CampsiteCard({ campsite }) {

    const user = useContext(User);
    const classDiv = setClassName(user.credentials);
    const history = useHistory();
    
    function setImage() {
        if (campsite.campgroundId == 1){
            return <img alt="mountain" className="w-20 h-20 rounded-md border-2 border-gray-300" src="https://www.exploreminnesota.com/sites/default/files/styles/share_image/public/listing_images/2a0378479a87c9dc13387992c3b88977beb8f22a_38.jpg?itok=mKDt61Td" />;
        }
        else if (campsite.campgroundId == 2){
            return <img alt="mountain" className="w-20 h-20 rounded-md border-2 border-gray-300" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSFRlw1Lwv26btxvSF7kzzktfw8yxchlbhxpg&usqp=CAU" />;
        }
        else{
            return <img alt="mountain" className="w-20 h-20 rounded-md border-2 border-gray-300" src="https://www.lifeinminnesota.com/wp-content/uploads/2018/10/Minnesota-Camping.jpg" />;
        }
    }


    return (<div className="flex items-right p-4 bg-white border-2 border-gray-200 rounded-lg shadow-sm dark:bg-gray-800 grid-col-2">
        {setImage()}
                <div id="body" className="flex flex-col ml-5 grid-rows-2">
                    <h4 id="name" className="text-xl font-semibold mb-2">{campsite.name}</h4>
                    <p id="job" className="text-gray-800 mt-2">Campsite ID: {campsite.siteId}</p>
                    <div className={classDiv} >
                    <Link to={`/reservation/${campsite.siteId}`} className="bg-gray-600 hover:bg-gray-900 text-white font-bold p-1 px-2 mt-2 ml-52 rounded w-30" id="login" type="button"><span>make reservation</span></Link>
                            {/* ^^^ add in something for the campsite id to be passed here as well */}
                    </div>
                </div>
            </div>);

    function setClassName(credentials) {
        const string = "";

        if (credentials && credentials.role === "USER") 
            return "col-span-2"
        
        else 
            return "col-span-2 hidden"; //col-span-2 hidden
        
    }
}

export default CampsiteCard;