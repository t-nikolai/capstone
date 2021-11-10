// find functions only
const baseUrl = "http://localhost:8080/api/campsite";

// findAll
export async function findAll() {
    const response = await fetch(baseUrl);
    if(response.status === 200){
        console.log("Campsite's findAll response is 200 OK");
        return response.json();
    }
    console.log("Campsite's findAll response is NOT 200 OK");
    return Promise.reject("Campsite's findAll response is NOT 200 OK");
}

// findById
export async function findById(campsiteId){
    const response = await fetch(`${baseUrl}/${campsiteId}`);
    if(response.status === 200){
        console.log("Campsite's findById response is 200 OK");
        return response.json();
    }
    console.log("Campsite's findById is NOT 200 OK");
    return Promise.reject("Campsite's findById is NOT 200 OK");
}

// findByCampgroundId
export async function findByCampgroundId(campgroundId){
    const response = await fetch(`${baseUrl}/find-by-campground/${campgroundId}`);
    if(response.status === 200){
        console.log("Campsite's findByCampgroundId response is 200 OK");
        return response.json();
    }
    console.log("Campsite's findByCampgroundId is NOT 200 OK");
    return Promise.reject("Campsite's findByCampgroundId is NOT 200 OK");
}