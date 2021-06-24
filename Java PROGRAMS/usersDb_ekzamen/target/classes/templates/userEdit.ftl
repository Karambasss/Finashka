<#if user??>
    <h1>Редактирование юзера</h1>
    <form action="/user" method="post">
        <table>
            <thead>
            <tr>
                <th>Имя</th>
                <th>Фамилия</th>
                <th>Возраст</th>
                <th>Группа</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td><input type="text" name="name" value="${user.name!}"> </td>
                <td><input type="text" name="surname" value="${user.surname!}"> </td>
                <td><input type="text" name="age" value="${user.age!}"> </td>
                <td><input type="text" name="group_num" value="${user.groupNum!}"></td>
            </tr>
            </tbody>
        </table>
        <input type="hidden" value="${user.id}" name="userId">
        <button type="submit">Сохранить</button>
    </form>
<#else>
    <h1 class="text-danger">Нет такого юзера!</h1>
    <div><a href="/user">Список юзеров</a></div>
</#if>