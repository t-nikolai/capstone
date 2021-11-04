import './Home';

function Signup() {
    return <div>
        <div className="w-screen h-screen flex justify-center items-center container">
            <form className="p-10 bg-green-100 bg-opacity-50 rounded flex justify-center items-center flex-col shadow-md z-10">
                <p className="mb-5 text-3xl uppercase font-bold text-green-900">Create an Account</p>
                <input type="text" name="name" class="mb-5 p-3 w-80 focus:border-green-700 rounded border-2 outline-none" autocomplete="off" placeholder="Name" required />
                <input type="email" name="email" class="mb-5 p-3 w-80 focus:border-green-700 rounded border-2 outline-none" autocomplete="off" placeholder="Email" required />
                <input type="number" name="phone" class="mb-5 p-3 w-80 focus:border-green-700 rounded border-2 outline-none" autocomplete="off" placeholder="Phone#" required />
                <input type="text" name="username" class="mb-5 p-3 w-80 focus:border-green-700 rounded border-2 outline-none" autocomplete="off" placeholder="Username" required />
                <input type="password" name="password" id="password" class="mb-5 p-3 w-80 focus:border-green-700 rounded border-2 outline-none" autocomplete="off" placeholder="Password" required />
                <input type="password" name="password2" id="verifiedPassword" className="mb-5 p-3 w-80 focus:border-green-700 rounded border-2 outline-none" autocomplete="off" placeholder="Verify Password" required />

                <div>
                    <button className="bg-green-600 hover:bg-green-900 text-white font-bold p-2 rounded w-30 mr-3" id="login" type="submit"><span>Sign up</span></button>
                    <a href='./Home' className="bg-gray-600 hover:bg-gray-900 text-white font-bold p-2 rounded w-30" id="login" type="submit"><span>Cancel</span></a>
                </div>

            </form>
            <img className="fixed object-cover w-full h-full y-0 x-0" src="https://coresites-cdn-adm.imgix.net/mpora_new/wp-content/uploads/2017/01/Cycle-Touring-Essentials-Touring-Bike-at-Camp.jpg?fit=crop"></img>
        </div>
    </div>
}

export default Signup;