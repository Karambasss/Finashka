
<div><a href="user/add">Добавить юзера</a></div>
    <#if size != 0>
    <h1>Список юзеров</h1>
        <table>
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Name</th>
            <th scope="col">Surname</th>
            <th scope="col">Age</th>
            <th scope="col">Group</th>
            <th scope="col">Редактировать</th>
            <th scope="col">Удалить</th>
        </tr>
        </thead>
<tbody>
        <#list users as u>
            <tr>
                <th>${u?index + 1}</th>
                <td >${u.name!}</td>
                <td>${u.surname!}</td>
                <td>${u.age!}</td>
                <td>${u.groupNum!}</td>
                <td><a href="/user/${u.id}">Редактировать</a></td>
                <td><a href="/user/del/${u.id}">Удалить</a></td>
            </tr>
        </#list>
</tbody>
        </table>
    <#else>
        <div></div>
        <h1>Нет юзеров</h1>
    </#if>
