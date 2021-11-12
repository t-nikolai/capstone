import './Home';
import App from '../App';
import { useState, useContext, useEffect } from "react";
import { Link, useHistory } from "react-router-dom";
import UserContext from "./UserContext";
import { verifyCredentials } from "../api/camperApi";

function Login() {
    const [error, setError] = useState();

    const [candidate, setCanidiate] = useState({
        username: "",
        password: ""
    });
    
    const onChange = (evt) => {
        const clone = { ...candidate };
        clone[evt.target.name] = evt.target.value;
        setCanidiate(clone);
    }
    const auth = useContext(UserContext);
    const history = useHistory();

    useEffect(() => {
        document.body.className = "Login";
    }, [])
    const onSubmit = (evt) => {
        evt.preventDefault();
        verifyCredentials(candidate)
            .then(camper => {
                auth.login(camper);
                history.push("/");
            })
            .catch((err) => setError("invalid login credentials"));
    }

    return <div>
        <div className="w-screen h-screen flex justify-center items-center container">
            <form className="p-10 bg-green-100 bg-opacity-50 rounded flex justify-center items-center flex-col shadow-md z-10" onSubmit={onSubmit}>

            <img className="fill-current h-20 w-20 mr-2" width="60" height="54" viewBox="0 0 54 54" src="/images/tentIcon-grey.png" alt="tentIcon-grey" />

                <p className="mb-5 text-3xl uppercase font-bold text-green-900">Login</p>
                <input type="text" id="username" name="username" className="mb-5 p-3 w-80 focus:border-green-700 rounded border-2 outline-none" autocomplete="off" placeholder="Username" value={candidate.username} onChange={onChange} required />
                <input type="password" id="password" name="password" className="mb-5 p-3 w-80 focus:border-green-700 rounded border-2 outline-none" autocomplete="off" placeholder="Password" value={candidate.password} onChange={onChange} required />

                {error && <div className="bg-red-100 border-l-4 border-red-500 text-red-700 p-4 mb-4" role="alert">
                    <p class="font-bold">Error</p>
                    <p>{error}</p>
                </div>  }

                <div>
                    <button className="bg-green-600 hover:bg-green-900 text-white font-bold p-2 rounded w-30 mr-3" id="login" type="submit" onClick={onSubmit}><span>Login</span></button>
                    <Link to='/' className="bg-gray-600 hover:bg-gray-900 text-white font-bold p-2 rounded w-30" id="login" type="submit"><span>Cancel</span></Link>
                </div>

            </form>
            <img className="fixed object-cover w-full h-full y-0 x-0" src="https://coresites-cdn-adm.imgix.net/mpora_new/wp-content/uploads/2017/01/Cycle-Touring-Essentials-Touring-Bike-at-Camp.jpg?fit=crop"></img>
        </div>
    </div>
}

export default Login;