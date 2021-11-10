const baseUrl = "http://localhost:8080/api/campground";

export async function findAll() {
    const response = await fetch(baseUrl);
    if(response.status === 200){
        console.log("Campgrounds's findAll response is 200 OK");
        return response.json();
    }
    console.log("Campground's findAll response is NOT 200 OK");
    return Promise.reject("Campground's findAll response is NOT 200 OK");
}

export async function findById(campgroundId) {
    const response = await fetch(`${baseUrl}/${campgroundId}`);
    if(response.status === 200){
        console.log("Campground's findById response is 200 OK");
        return response.json();
    }
    console.log("Campground's findById response is NOT 200 OK");
    return Promise.reject("Campground's findById response is NOT 200 OK");
}