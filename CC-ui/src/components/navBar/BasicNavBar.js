function BasicNavBar() {
    return <div>
        <nav class="flex items-center justify-between flex-wrap bg-green-700 px-4 pt-3">
            <div class="flex items-center flex-shrink-0 text-green-100 mr-6">
                <img class="fill-current h-12 w-12 mr-2" width="60" height="54" viewBox="0 0 54 54" src="/images/tentIcon-grey.png" alt="tentIcon-grey" />
                <span class="font-semibold text-xl tracking-tight">Camping community.</span>
            </div>
            <div class="w-full block flex-grow lg:flex items-center lg:w-auto">
                <div>
                    <a href="/Login" class="inline-block text-sm px-4 py-2 leading-none border rounded text-white border-green-300 hover:border-transparent hover:text-white hover:bg-green-300 mt-4 mr-4 lg:mt-0">Log in</a>
                    <a href="/Signup" class="inline-block text-sm px-4 py-2 leading-none border rounded text-white border-green-300 hover:border-transparent hover:text-white hover:bg-green-300 mt-4 lg:mt-0">Sign up</a>
                </div>
            </div>
        </nav>
    </div>
}

export default BasicNavBar;