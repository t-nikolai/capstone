function Home() {
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

        <div class="font-mono bg-gray-400 ">
            <div class="flex flex-col items-center py-8">
                <div class="flex flex-col w-full mb-12 text-left">
                    <div class="w-full mx-auto lg:w-1/2">
                        <img class="object-scale-down h-full w-full" src="/images/campingIllustration.jpg" alt="campingIllustration" />
                        <h2 class="mx-auto mt-4 mb-4 text-xl font-semibold text-black">Are you ready for a new experience and challenge?</h2>
                        <p class="mx-auto text-base font-medium leading-relaxed text-gray-800">This is where we could put some info about the campsite or what our website is about</p>
                    </div>
                </div>
            </div>
        </div>
    </div>

}

export default Home;