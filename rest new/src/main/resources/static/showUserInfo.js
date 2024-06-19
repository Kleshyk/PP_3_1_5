showUserInfo();

function showUserInfo(user) {
    fetch('http://localhost:8080/getAuthorizedUser')
        .then(response => response.json())
        .then(user => {
            let tBody = document.getElementById("user_info");
            tBody.innerHTML = "";

            var row = tBody.insertRow();
            row.setAttribute("id", user.id);
            var cell0 = row.insertCell();
            cell0.innerHTML = user.id;
            var cell1 = row.insertCell();
            cell1.innerHTML = user.firstName;
            var cell2 = row.insertCell();
            cell2.innerHTML = user.lastName;
            var cell3 = row.insertCell();
            cell3.innerHTML = user.age;
            var cell5 = row.insertCell();
            cell5.innerHTML = user.userName;
            var cell6 = row.insertCell();
            cell6.innerHTML = listRoles(user).textContent;
        });
}