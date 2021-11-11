import { Link } from 'react-router-dom';
import { useContext } from 'react';
import User from './UserContext';

function CampsiteCard({ campsite }) {

    const user = useContext(User);
    const classDiv = setClassName(user.credentials);


    return (<div className="flex items-right p-4 bg-white border-2 border-gray-200 rounded-lg shadow-sm dark:bg-gray-800 grid-col-2">
                <img alt="mountain" className="w-10 h-10 rounded-md border-2 border-gray-300" src="https://picsum.photos/seed/picsum/200" />
                <div id="body" className="flex flex-col ml-5 grid-rows-2">
                    <h4 id="name" className="text-xl font-semibold mb-2">Campsite {campsite.siteId}</h4>
                    <p id="job" className="text-gray-800 mt-2">{campsite.name}</p>
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