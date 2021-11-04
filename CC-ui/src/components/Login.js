import './Home';

function Login() {
    return <div>
        <div className="w-screen h-screen flex justify-center items-center container">
            <form className="p-10 bg-green-100 bg-opacity-50 rounded flex justify-center items-center flex-col shadow-md z-10">

                <svg xmlns="http://www.w3.org/2000/svg" className=" w-20 h-20 text-gray-600 mb-2" viewbox="20 20 20 20" fill="currentColor">
                    <path fill-rule="evenodd" d="M18 10a8 8 0 11-16 0 8 8 0 0116 0zm-6-3a2 2 0 11-4 0 2 2 0 014 0zm-2 4a5 5 0 00-4.546 2.916A5.986 5.986 0 0010 16a5.986 5.986 0 004.546-2.084A5 5 0 0010 11z" clip-rule="evenodd" />
                </svg>

                <p className="mb-5 text-3xl uppercase font-bold text-green-900">Login</p>
                <input type="text" name="username" className="mb-5 p-3 w-80 focus:border-green-700 rounded border-2 outline-none" autocomplete="off" placeholder="Username" required />
                <input type="password" name="password" className="mb-5 p-3 w-80 focus:border-green-700 rounded border-2 outline-none" autocomplete="off" placeholder="Password" required />

                <div>
                    <button className="bg-green-600 hover:bg-green-900 text-white font-bold p-2 rounded w-30 mr-3" id="login" type="submit"><span>Login</span></button>
                    <a href='./Home' className="bg-gray-600 hover:bg-gray-900 text-white font-bold p-2 rounded w-30" id="login" type="submit"><span>Cancel</span></a>
                </div>

            </form>
            <img className="fixed object-cover w-full h-full y-0 x-0" src="https://coresites-cdn-adm.imgix.net/mpora_new/wp-content/uploads/2017/01/Cycle-Touring-Essentials-Touring-Bike-at-Camp.jpg?fit=crop"></img>
        </div>
    </div>
}

export default Login;