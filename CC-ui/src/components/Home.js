function Home() {
    return (
        <div className="font-mono bg-gray-400 ">
            <div className="flex flex-col items-center py-8">
                <div className="flex flex-col w-full mb-12 text-left">
                    <div className="w-full mx-auto lg:w-1/2">
                        <img className="object-scale-down h-full w-full" src="/images/campingIllustration.jpg" alt="campingIllustration" />
                        <h2 className="mx-auto mt-4 mb-4 text-xl font-semibold text-black">Are you ready for a new experience and challenge?</h2>
                        <p className="mx-auto text-base font-medium leading-relaxed text-gray-800">This is where we could put some info about the campsite or what our website is about</p>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Home;