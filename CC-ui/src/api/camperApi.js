const baseUrl = "http://localhost:8080/api/camper";

export async function findAll() {
    const response = await fetch(baseUrl);
    if(response.status === 200){
        console.log("Camper's findAll response is 200 OK");
        return response.json();
    }
    console.log("Camper's findAll response is NOT 200 OK");
    return Promise.reject("Camper's findAll response is NOT 200 OK");
}

export async function findById(camperId) {
    const response = await fetch(`${baseUrl}/${camperId}`);
    if(response.status === 200){
        console.log("Camper's findById response is 200 OK");
        return response.json();
    }
    console.log("Camper's findById response is NOT 200 OK");
    return Promise.reject("Camper's findById response is NOT 200 OK");
}

function makeFetchInit(method, camper) {
    return {
        method: method,
        headers: {
            "Content-Type": "application/json",
            "Accept": "application/json"
        },
        body: JSON.stringify(camper)
    };
}

export async function verifyCredentials(camper) {
    const init = makeFetchInit("POST", camper);
    const response = await fetch(`${baseUrl}/login`, init);
    if(response.status === 201){
        console.log("camper's verification response is 200 OK");
        return response.json();
    }
    console.log("camper's verification response is NOT 200 OK.");
    return Promise.reject("camper's verification response is NOT 200 OK");
}

export async function add(camper) {
    const init = makeFetchInit("POST", camper);
    const response = await fetch(baseUrl, init);
    if (response.status === 201) {
        return response.json();
    }
    console.log("Camper's add response is NOT 200 OK");
    return Promise.reject("Camper's add response is NOT 200 OK");
}

export async function update(camper) {
    const init = makeFetchInit("PUT", camper);
    const response = await fetch(`${baseUrl}/${camper.camperId}`, init);
    if (response.status !== 204) {
        console.log("Camper's update response is NOT 200 OK");
        return Promise.reject("Camper's update response is NOT 200 OK");
    }
}

export async function save(camper) {
    return camper.camperId > 0 ? update(camper) : add(camper);
}

export async function deleteById(camperId) {
    const response = await fetch(`${baseUrl}/${camperId}`, { method: "DELETE" });
    if (response.status !== 204) {
        throw new Error("Could not delete camper.");
    }
}
