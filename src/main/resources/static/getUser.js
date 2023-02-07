async function getUser(id) {
    let url = "http://localhost:8080/rest/admin/" + id;
    let response = await fetch(url);
    return await response.json();
}