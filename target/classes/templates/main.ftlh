<!DOCTYPE HTML>
<html>
<head>
    <title>Planets and Lords</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
<a href="/addLord">Добавить нового Повелителя</a>
<a href="/addPlanet">Добавить новую Планету</a></br>
Лорды: </br>
<#list lords as lord>
    <span>${lord.name}</span>
    <span>${lord.age}</span></br>
</#list>
---------------------------------------</br>
Планеты: </br>
    <#list planets as planet>
        ${planet.name}
        <#if planet.lordName??>
            <span>${planet.lordName}</span></br>
            <form method="get" action="/appointLord">
                <select name="newLordId">
                    <#list lords as lord>
                        <#if planet.lordName!=lord.name><option value=${lord.id}>${lord.name}</option></#if>
                    </#list>
                </select>
                <input type="hidden" name="lordName" value="${planet.lordName}"/>
                <input type="hidden" name="planetName" value="${planet.name}" />
                <button type="submit">Назначить Повелителя управлять Планетой</button>
            </form>
        <#else>
            <form method="get" action="/appointLord">
                <select name="newLordId">
                    <#list lords as lord>
                        <option value=${lord.id}>${lord.name}</option>
                    </#list>
                </select>
                <input type="hidden" name="lordName" value=""/>
                <input type="hidden" name="planetName" value="${planet.name}" />
                <button type="submit">Назначить Повелителя управлять Планетой</button>
            </form>
        </#if>
    </#list>
</body>
</html>