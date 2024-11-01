@import exercise.dto.users.UserPage
@param UserPage page

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
                rel="stylesheet"
                integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
                crossorigin="anonymous">
    <title></title>
</head>
<body>
    <h3>Данные пользователя</h3>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Имя</th>
                <th>Фамилия</th>
                <th>Email</th>
            </tr>
        </thead>
        <tbody>
                <tr>
                    <td>${page.getUser().getId()}</td>
                    <td>${page.getUser().getFirstName()}</td>
                    <td>${page.getUser().getLastName()}</td>
                    <td>${page.getUser().getEmail()}</td>
                </tr>
        </tbody>
    </table>
</body>
</html>
