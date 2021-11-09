import { Link } from "react-router-dom";
import Map from "./testingComponents/MapTestingComponent";

function Campgrounds(credentials) {

    const credential = {...credentials}
    const classDiv = setClassName(credential.role);
    
return <div>
    <div className="grid grid-cols-3 gap-2">
        <section className="container px-6 py-4 mx-auto bg-red-900">
            <div className="grid gap-6 grid-cols-1">

                <div className="flex items-right p-4 bg-white border-2 border-gray-200 rounded-lg shadow-sm dark:bg-gray-800 grid-col-2">
                    <img alt="mountain" className="w-10 h-10 rounded-md border-2 border-gray-300" src="https://picsum.photos/seed/picsum/200" />
                    <div id="body" className="flex flex-col ml-5 grid-rows-2">
                        <h4 id="name" className="text-xl font-semibold mb-2">Campsite 1</h4>
                        <p id="job" className="text-gray-800 mt-2">Brief description of campsite</p>
                        <div className={classDiv} >
                        <Link to='/reservation' className="bg-gray-600 hover:bg-gray-900 text-white font-bold p-1 px-2 mt-2 ml-52 rounded w-30" id="login" type="submit"><span>make reservation</span></Link>
                        </div>
                    </div>
                </div>

                <div className="flex items-right p-4 bg-white border-2 border-gray-200 rounded-lg shadow-sm dark:bg-gray-800 grid-col-2">
                    <img alt="mountain" className="w-10 h-10 rounded-md border-2 border-gray-300" src="https://picsum.photos/seed/picsum/200" />
                    <div id="body" className="flex flex-col ml-5 grid-rows-2">
                        <h4 id="name" className="text-xl font-semibold mb-2">Campsite 2</h4>
                        <p id="job" className="text-gray-800 mt-2">Brief description of campsite</p>
                        <div className={classDiv} >
                            reservation button
                        </div>
                    </div>
                </div>

                <div className="flex items-right p-4 bg-white border-2 border-gray-200 rounded-lg shadow-sm dark:bg-gray-800 grid-col-2">
                    <img alt="mountain" className="w-10 h-10 rounded-md border-2 border-gray-300" src="https://picsum.photos/seed/picsum/200" />
                    <div id="body" className="flex flex-col ml-5 grid-rows-2">
                        <h4 id="name" className="text-xl font-semibold mb-2">Campsite 3</h4>
                        <p id="job" className="text-gray-800 mt-2">Brief description of campsite</p>
                        <div className={classDiv} >
                            reservation button
                        </div>
                    </div>
                </div>

            </div>
        </section>
        <div className="col-span-2">
            <h2 className="text-center text-3xl"> Name of campground will appear here when clicked </h2>
            <Map />
        </div>
    </div>
</div>

function setClassName(r) {
    const string = "";
    console.log(r); 

    if (r === 'USER') 
        return "col-span-2"
    
    else 
        return "col-span-2"; //col-span-2 hidden
    
  }
}

export default Campgrounds;