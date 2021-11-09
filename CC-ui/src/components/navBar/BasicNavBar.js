import { BrowserRouter as Router, Switch, useHistory, Link } from 'react-router-dom';

function BasicNavBar() {
    return <div>
        <nav className="flex items-center justify-between flex-wrap bg-green-700 px-4 pt-3">
            <div className="flex items-center flex-shrink-0 text-green-100 mr-6">
                <img className="fill-current h-12 w-12 mr-2" width="60" height="54" viewBox="0 0 54 54" src="/images/tentIcon-grey.png" alt="tentIcon-grey" />
                <span className="font-semibold text-xl tracking-tight">Camping community.</span>
            </div>
            <div className="w-full block flex-grow lg:flex items-center lg:w-auto">
            <div className="w-full block flex-grow lg:flex lg:items-center lg:w-auto">
                    <div className="text-sm lg:flex-grow visibility:hidden lg:visable">
                        <Link to='/' className="block mt-4 lg:inline-block lg:mt-0 text-green-300 hover:text-white mr-4 "> home </Link>
                        <Link to='/Campgrounds' className="block mt-4 lg:inline-block lg:mt-0 text-green-300 hover:text-white mr-4 "> view locations </Link>
                    </div>
                    </div>
                <div>
                    <Link to='/Login' className="inline-block text-sm px-4 py-2 leading-none border rounded text-black border-green-300 bg-gray-400 hover:border-transparent hover:text-white hover:bg-green-300 mt-4 mr-4 lg:mt-0">Log in</Link>
                    <Link to='/Signup' className="inline-block text-sm px-4 py-2 leading-none border rounded text-black border-green-300 bg-gray-400 hover:border-transparent hover:text-white hover:bg-green-300 mt-4 lg:mt-0">Sign up</Link>
                </div>
            </div>
        </nav>
    </div>
}

export default BasicNavBar;