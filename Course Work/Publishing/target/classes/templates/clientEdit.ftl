<#import "parts/common.ftl" as c>
<@c.page>
    <#if client??>
        <h1 class="text-primary">Редактирование клиента</h1>
        <form action="/client" method="post">
            <table>
                <thead>
                <tr>
                    <th>Имя</th>
                    <th>Фамилия</th>
                    <th>Возраст</th>
                    <th>Адрес</th>
                    <th>Мейл</th>
                    <th>Телефонный номер</th>
                    <th>Имя организации</th>
                    <th>Реквизиты</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td><input type="text" name="name" value="${client.name!}"></td>
                    <td><input type="text" name="surname" value="${client.surname!}"></td>
                    <td><input type="text" name="age" value="${client.age!}"></td>
                    <td><textarea name="adress">${client.adress!}</textarea></td>
                    <td><input type="text" name="email" value="${client.email!}"></td>
                    <td><input type="text" name="telephone_number" value="${client.telephone_number!}"></td>
                    <td><input type="text" name="organization_name" value="${client.organization_name!}"></td>
                    <td><input type="text" name="requisites" value="${client.requisites!}"></td>
                </tr>
                </tbody>
            </table>
            <input type="hidden" name="clientID" value="${client.id}">
            <input type="hidden" value="${_csrf.token}" name="_csrf">
            <button class="btn btn-primary mb-2" type="submit">Сохранить</button>
<#--            <button type="submit">Сохранить</button>-->
        </form>
    <#else>
        <h1 class="text-danger">Нет такого клиента</h1>
        <a href="/client" class="badge badge-info">Список клиентов</a>
    </#if>
</@c.page>