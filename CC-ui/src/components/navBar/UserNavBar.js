import { useState, useContext, useEffect } from "react";
import { Link, useHistory} from "react-router-dom";
import UserContext from "../UserContext";

function UserNavBar() {

    const [canidate, setCanidiate] = useState({
        username : "",
        password : ""
    });
    
    const auth = useContext(UserContext);
  
  useEffect (() => {
      document.body.className = "Login";
  }, [])
  
    const onSubmit = (evt) => {
      evt.preventDefault();
      auth.logout();

    }

    return (
        <div>
            <nav class="flex items-center justify-between flex-wrap bg-green-700 px-4 pt-3">
                <div class="flex items-center flex-shrink-0 text-green-100 mr-6">
                    <img class="fill-current h-12 w-12 mr-2" width="60" height="54" viewBox="0 0 54 54" src="/images/tentIcon-grey.png" alt="tentIcon-grey" />
                    <span class="font-semibold text-xl tracking-tight">Camping community.</span>
                </div>
                <div class="w-full block flex-grow lg:flex lg:items-center lg:w-auto">
                    <div class="text-sm lg:flex-grow visibility:hidden lg:visable">
                        <Link to='/' class="block mt-4 lg:inline-block lg:mt-0 text-green-300 hover:text-white mr-4 "> home </Link>
                        <Link to='/Campgrounds' class="block mt-4 lg:inline-block lg:mt-0 text-green-300 hover:text-white mr-4 "> view locations </Link>
                        <a href="#responsive-header" class="block mt-4 lg:inline-block lg:mt-0 text-green-300 hover:text-white mr-4 "> make a reservation </a>
                    </div>
                    <div>
                        <button type="submit" class="inline-block text-sm px-4 py-2 leading-none border rounded text-black border-green-300 bg-gray-400 hover:border-transparent hover:text-white hover:bg-green-300 mt-4 mr-4 lg:mt-0" onClick={onSubmit}>Log out</button>
                        <Link to='/SignUp' class="inline-block text-sm px-4 py-2 leading-none border rounded text-black border-green-300 bg-gray-400 hover:border-transparent hover:text-white hover:bg-green-300 mt-4 lg:mt-0">Sign up</Link>
                    </div>
                </div>
            </nav>

            <div class="flex items-center flex-wrap text-green-100 bg-green-700 p-1">
                <img class="fill-current mr-2 w-8 h-8 p-1" src="images/loginIcon.png" alt="loginO=Icon" />
                <span class="font-semibold text-xl tracking-tight">{auth.credentials.username}</span>
            </div>
        </div>
    );
}

export default UserNavBar;