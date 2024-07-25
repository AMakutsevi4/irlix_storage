<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Список посетителей</title>
</head>
<body>
<h1>Список посетителей</h1>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Имя</th>
        <th>Возраст</th>
        <th>Действия</th>
    </tr>
    </thead>
    <tbody>
    <#list people as person>
        <tr>
            <td>${person.id}</td>
            <td>${person.name}</td>
            <td>${person.age}</td>
            <td>
                <a href="/people/edit/${person.id}">Редактировать</a>
                <a href="/people/delete/${person.id}">Удалить</a>
            </td>
        </tr>
    </#list>
    </tbody>
</table>
<a href="/people/new">Добавить нового посетителя</a>
</body>
</html>