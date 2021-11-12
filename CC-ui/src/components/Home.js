function Home() {
    return (<div>
        <div className="font-mono ">
            <div className="flex flex-col items-center py-8">
                <div className="flex flex-col w-full mb-12 text-left">
                    <div className="w-full mx-auto lg:w-1/2">
                        <img className="object-scale-down h-full w-full" src="/images/campingIllustration.jpg" alt="campingIllustration" />
                        <h2 className="mx-auto mt-4 mb-4 text-xl font-semibold text-black text-center">
                            Are you ready for a new experience and challenge?
                        </h2>
                        <p className="mx-auto text-base font-medium leading-relaxed text-gray-800">
                            Our mission is to promote active participation in a safe and inclusive outdoor environment. We strive to
                            encourage positive attitudes through a quality camping experience. Helping people reach their dreams and
                            overcoming unusual obstacles and challenges are central to our mission.
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    );
}

export default Home;