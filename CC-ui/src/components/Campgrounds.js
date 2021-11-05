function Campgrounds() {
    return <div>
        <nav class="flex items-center justify-between flex-wrap bg-green-700 px-4 pt-3">
            <div class="flex items-center flex-shrink-0 text-green-100 mr-6">
                <img class="fill-current h-12 w-12 mr-2" width="60" height="54" viewBox="0 0 54 54" src="/images/tentIcon-grey.png" alt="tentIcon-grey" />
                <span class="font-semibold text-xl tracking-tight">Camping community.</span>
            </div>
            <div class="block lg:hidden">
                <button class="flex items-center px-3 py-2 border rounded text-gray-200 border-teal-400 hover:text-white hover:border-white" onClick='displayValues()'>
                    <svg class="fill-current h-3 w-3" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
                        <title>Menu</title>
                        <path d="M0 3h20v2H0V3zm0 6h20v2H0V9zm0 6h20v2H0v-2z" />
                    </svg>
                </button>
            </div>
            <div class="w-full block flex-grow lg:flex lg:items-center lg:w-auto">
                <div class="text-sm lg:flex-grow visibility:hidden lg:visable">
                    <a href="#responsive-header" class="block mt-4 lg:inline-block lg:mt-0 text-green-300 hover:text-white mr-4 "> view campsites </a>
                    <a href="#responsive-header" class="block mt-4 lg:inline-block lg:mt-0 text-green-300 hover:text-white mr-4 "> make a reservation </a>
                </div>
                <div>
                    <a href="#" class="inline-block text-sm px-4 py-2 leading-none border rounded text-white border-green-300 hover:border-transparent hover:text-white hover:bg-green-300 mt-4 lg:mt-0">Log out</a>
                    <a href="#" class="inline-block text-sm px-4 py-2 leading-none border rounded text-white border-green-300 hover:border-transparent hover:text-white hover:bg-green-300 mt-4 lg:mt-0">Sign in</a>
                </div>
            </div>
        </nav>

        <div class="flex items-center flex-wrap text-green-100 bg-green-700 p-1">
            <img class="fill-current mr-2 w-8 h-8 p-1" src="images/loginIcon.png" alt="loginO=Icon" />
            <span class="font-semibold text-xl tracking-tight">Admin profile name</span>
        </div>

        <div class="grid grid-cols-3 gap-2">
            <section class="container px-6 py-4 mx-auto bg-red-900">
                <div class="grid gap-6 grid-cols-1">

                    <div class="flex items-right p-4 bg-white border-2 border-gray-200 rounded-lg shadow-sm dark:bg-gray-800 grid-cols-2">
                        <img alt="mountain" class="w-10 h-10 rounded-md border-2 border-gray-300" src="https://picsum.photos/seed/picsum/200" />
                        <div id="body" class="flex flex-col ml-5">
                            <h4 id="name" class="text-xl font-semibold mb-2">Campground 1</h4>
                            <p id="job" class="text-gray-800 mt-2">Brief description of campground + buttons to view sites</p>
                        </div>
                        <div>
                            buttons here? -- need to find a way to plage this in a row
                            (simmilar layout will be applied with campsites except the side bar will only show a single camsite when it is 
                            clicked on the map and the component will have a camlender, the user will select an available date, only then 
                            will they be able to click the button 'make reservation')
                        </div>
                    </div>

                    <div class="flex items-right p-4 bg-white border-2 border-gray-200 rounded-lg shadow-sm dark:bg-gray-800 grid-cols-2">
                        <img alt="mountain" class="w-10 h-10 rounded-md border-2 border-gray-300" src="https://picsum.photos/seed/picsum/200" />
                        <div id="body" class="flex flex-col ml-5">
                            <h4 id="name" class="text-xl font-semibold mb-2">Campground 1</h4>
                            <p id="job" class="text-gray-800 mt-2">Brief description of campground + buttons to view sites</p>
                        </div>
                        <div>
                            buttons here?
                        </div>
                    </div>

                    <div class="flex items-right p-4 bg-white border-2 border-gray-200 rounded-lg shadow-sm dark:bg-gray-800 grid-cols-2">
                        <img alt="mountain" class="w-10 h-10 rounded-md border-2 border-gray-300" src="https://picsum.photos/seed/picsum/200" />
                        <div id="body" class="flex flex-col ml-5">
                            <h4 id="name" class="text-xl font-semibold mb-2">Campground 1</h4>
                            <p id="job" class="text-gray-800 mt-2">Brief description of campground + buttons to view sites?</p>
                        </div>
                        <div>
                            buttons here?
                        </div>
                    </div>

                </div>
            </section>
            <div className="col-span-2">
                map will go here................................................................
                ................................................................................
                ............................................(testing to see if col span worked)

            </div>
        </div>
    </div>
}

export default Campgrounds;