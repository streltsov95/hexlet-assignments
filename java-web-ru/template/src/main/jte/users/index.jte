@import exercise.dto.users.UsersPage
@param UsersPage page

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
                rel="stylesheet"
                integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
                crossorigin="anonymous">
    <title>Список пользователей</title>
</head>
<body>
    <h3>Список пользователей</h3>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Имя</th>
                <th>Фамилия</th>
            </tr>
        </thead>
        <tbody>
            @for(var user : page.getUsers())
                <tr>
                    <td><a href="/users/${user.getId()}">${user.getId()}</a></td>
                    <td>${user.getFirstName()}</td>
                    <td>${user.getLastName()}</td>
                </tr>
            @endfor
        </tbody>
    </table>
</body>
</html>
