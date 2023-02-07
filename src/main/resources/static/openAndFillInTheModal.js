async function openAndFillInTheModal(form, modal, id){
    modal.show();
    let user = await getUser(id);
    form.id.value = user.id;
    form.name.value = user.name;
    form.last_name.value = user.last_name;
    form.email.value = user.email;
    form.age.value = user.age;
    form.username.value = user.username;
    form.roles.value = user.roles[0].id;
}