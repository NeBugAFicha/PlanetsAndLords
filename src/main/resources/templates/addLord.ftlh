<!DOCTYPE HTML>
<html>
<head>
    <title>Planets and Lords</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
<form method="post" action="/addLord">
    <input type="text" name="name" placeholder="Введите имя Повелителя" />
    <#if nameError??>${nameError}</#if>
    <input type="text" name="age" placeholder="Введите возраст Повелителя"/>
    <#if ageError??>${ageError}</#if>
    <button type="submit">Добавить</button>
</form>
</body>
</html>