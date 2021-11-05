function Campgrounds() {
    return <div>
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