const baseUrl = "http://localhost:8080/api/reservation";    // change to AWS link from .env file later once AWS is set up

export async function findAll() {
    const response = await fetch(baseUrl);
    if(response.status === 200){
        console.log("Reservation's findAll response is 200 OK");
        return response.json();
    }
    console.log("Reservation's findAll response is NOT 200 OK");
    return Promise.reject("Reservation's findAll response is NOT 200 OK");
}

export async function findByCampsiteId(campsiteId){
    const response = await fetch(`${baseUrl}/reservations-by-campsite/${campsiteId}`);
    if (response.status === 200){
        console.log("Reservation's findByCampsiteId response is 200 OK");
        return response.json();
    }
    console.log("Reservation's findByCampsiteId is NOT 200 OK");
    return Promise.reject("Reservation's findByCampsiteId is NOT 200 OK");
}

export async function findById(reservationId){
    const response = await fetch(`${baseUrl}/${reservationId}`);
    if(response.status === 200){
        console.log("Reservation's findById response is 200 OK");
        return response.json();
    }
    console.log("Reservation's findById is NOT 200 OK");
    return Promise.reject("Reservation's findById is NOT 200 OK");
}

export async function add(reservation){
    console.log('reservations add fxn called!');
    const init = {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(reservation)
    };

    const response = await fetch(baseUrl, init);

    if(response.status !== 201){
        console.log("reservation's add response is NOT 201 CREATED");
        return Promise.reject("reservation's add response is NOT 201 CREATED");
    }
    console.log("reservation's add response is 201 created");
}

export async function update(reservation){
    console.log('reservations update fxn called!');
    const init = {
        method: "PUT",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(reservation)
    };

    const response = await fetch(`${baseUrl}/${reservation.reservationId}`, init);

    if(response.status !== 204) {
        console.log("reservation's update response is NOT 204 NO CONTENT");
        return Promise.reject("reservation's update response is NOT 204 NO CONTENT");
    }
    console.log("reservation's update response is 204 NO CONTENT");
}

export async function save(reservation) {
    console.log("reservations save fxn called!");
    if(reservation.reservationId > 0) {
        await update(reservation);
    } else {
        await add(reservation);
    }
    return findAll();
}

export async function deleteById(reservationId){
    const init = {
        method: "DELETE"
    };

    const response = await fetch(`${baseUrl}/${reservationId}`, init);

    if(response.status !== 204) {
        console.log("reservation's deleteById response is NOT 204 NO CONTENT");
        return Promise.reject("reservation's deleteById response is NOT 204 NO CONTENT");
    }
    console.log("reservation's deleteById response is 204 NO CONTENT");
    return findAll();
}