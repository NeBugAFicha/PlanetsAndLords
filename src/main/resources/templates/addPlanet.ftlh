<!DOCTYPE HTML>
<html>
<head>
    <title>Planets and Lords</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
<form method="post" action="/addPlanet">
    <input type="text" name="name" placeholder="Введите название планеты"/>
    <#if nameError??>${nameError}</#if>
    <button type="submit">Добавить</button>
</form>
</body>
</html>