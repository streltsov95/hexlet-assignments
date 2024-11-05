@import gg.jte.Content
@param Content content

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Hexlet Javalin Example</title>
</head>
<body>
<div>
    <header>
        <p>
            <a href="/">Главная страница</a>
            <a href="/users">Список пользователей</a>
        </p>
    </header>
</div>
${content}
<div>
    <footer>
        <a href="https://github.com/streltsov95">GitHub</a>
    </footer>
</div>
</body>
</html>