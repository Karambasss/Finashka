<#import "parts/common.ftl" as c>
<@c.page>
    <#if employee??>
    <h1 class="text-primary">Редактирование сотрудника</h1>
    <form action="/employee" method="post">
    <table>
        <thead>
        <tr>
            <th>Имя</th>
            <th>Фамилия</th>
            <th>Возраст</th>
            <th>Адрес</th>
            <th>Мейл</th>
            <th>Телефонный номер</th>
            <th>Зарплата</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td><input type="text" name="name" value="${employee.name!}"> </td>
            <td><input type="text" name="surname" value="${employee.surname!}"> </td>
            <td><input type="text" name="age" value="${employee.age!}"> </td>
            <td><input type="text" name="adress" value="${employee.adress!}"> </td>
            <td><input type="text" name="email" value="${employee.email!}"> </td>
            <td><input type="text" name="telephone_number" value="${employee.telephone_number!}"></td>
            <td><input type="text" name="salary" value="${employee.salary?c!}" required></td>
        </tr>
        </tbody>
    </table>
        <#list roles as role>
            <#if role != "CLIENT">
            <div>
                <label><input type="checkbox" name="${role}" ${employee.user.role_of_user?seq_contains(role)?string("checked","")}>${role}</label>
            </div>
            </#if>
        </#list>
        <input type="hidden" value="${employee.id}" name="employeeID">
        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <button class="btn btn-primary mb-2" type="submit">Сохранить</button>
<#--        <button type="submit">Сохранить</button>-->
    </form>
        <#else>
        <h1 class="text-danger">Нет такого сотрудника!</h1>
            <div><a href="/employee" class="badge badge-info">Список сотрудников</a></div>
    </#if>
</@c.page>