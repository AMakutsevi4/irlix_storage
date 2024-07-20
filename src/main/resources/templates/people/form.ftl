<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Форма посетителя</title>
</head>
<body>
<h1><#if person.id??>Редактировать посетителя<#else>Добавить нового посетителя</#if></h1>
<form action="<#if person.id??>/people/update/${person.id}<#else>/people</#if>" method="post">
    <label for="name">Имя:</label>
    <input type="text" id="name" name="name" value="${person.name!}">
    <#if person.name?has_content && (person.name?length < 2 || person.name?length > 50)>
        <span style="color:#e77f7f">Имя должно содержать от 2 до 50 символов</span>
    </#if>
    <br>
    <label for="age">Возраст:</label>
    <input type="number" id="age" name="age" value="${person.age!}">
    <br>
    <button type="submit">Сохранить</button>
</form>
<a href="/people">Назад к списку</a>
</body>
</html>