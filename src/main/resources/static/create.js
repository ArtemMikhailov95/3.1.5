let formNew = document.forms["formNewUser"];
addUser();

function addUser() {
    formNew.addEventListener("submit", ev => {
        ev.preventDefault();
        let newUserRoles = [];
        for (let i = 0; i < formNew.roles.options.length; i++) {
            if (formNew.roles.options[i].selected) newUserRoles.push({
                id: formNew.roles.value,
                name: "ROLE_" + formNew.roles.options[i].text
            });
        }
        fetch("http://localhost:8080/rest/admin/", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                id: formNew.id.value,
                name: formNew.name.value,
                last_name: formNew.last_name.value,
                email: formNew.email.value,
                age: formNew.age.value,
                username: formNew.username.value,
                password: formNew.password.value,
                roles: newUserRoles
            })
        }).then(() => {
            formNew.reset();
            readAll();
            $('#home-tab').click();
        });
    });
}