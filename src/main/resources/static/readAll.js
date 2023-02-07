const table = $('#usersTable');
readAll();

function readAll() {
    table.empty()
    fetch("http://localhost:8080/rest/admin")
        .then(res => res.json())
        .then(data => {
            data.forEach(user => {
                let usersTable = `$(
                        <tr>
                            <td>${user.id}</td>
                            <td>${user.name}</td>
                            <td>${user.last_name}</td>
                            <td>${user.email}</td>
                            <td>${user.age}</td>   
                            <td>${user.username}</td>
                            <td>${user.password}</td>
                            <td>${user.roles.map(role => " " + role.name.substring(5))}</td>
                            <td>
                                <button type="button" class="btn btn-warning"
                                data-bs-toogle="modal"
                                data-bs-target="#editModal"
                                onclick="editModalData(${user.id})">Edit</button>
                            </td>
                            <td>
                                <button type="button" class="btn btn-danger" 
                                data-toggle="modal"
                                data-bs-target="#deleteModal"
                                onclick="deleteModalData(${user.id})">Delete</button>
                            </td>
                        </tr>)`;
                table.append(usersTable);
            })
        })
}