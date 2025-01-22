
@param String _csrf
@param String img64

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<b2>THIS IS CHALLENGE</b2>

<form action="/challenge" method="POST">
    <input type="hidden" name="_csrf" value="${_csrf}" />
    <input type="text" name="otp" required placeholder="xxx-xxx" />
    <button type="submut">Odoslať</button>
</form>

<img src="data:image/png;base64, ${img64}" alt="" />
<form action="/logout" method="POST">
    <input type="hidden" name="_csrf" value="${_csrf}" />
    <button type="submut">Odhlásiť</button>
</form>
</body>
</html>