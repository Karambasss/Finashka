<#import "parts/common.ftl" as c>
<@c.page>
    <#if author??>
    <h1 class="text-primary">Редактирование автора</h1>
    <form action="/author" method="post">
        <table>
            <thead>
            <tr>
                <th>Имя</th>
                <th>Фамилия</th>
                <th>Возраст</th>
                <th>Адрес</th>
                <th>Мейл</th>
                <th>Телефонный номер</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td><input type="text" name="name" value="${author.name!}"></td>
                <td><input type="text" name="surname" value="${author.surname!}"></td>
                <td><input type="text" name="age" value="${author.age!}"></td>
                <td><textarea name="adress">${author.adress!}</textarea> </td>
                <td><input type="text" name="email" value="${author.email!}"> </td>
                <td><input type="text" name="telephone_number" value="${author.telephone_number!}"></td>
            </tr>
            </tbody>
        </table>
        <input type="hidden" name="authorID" value="${author.id}">
        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <button class="btn btn-primary mb-2" type="submit">Сохранить</button>
<#--        <button type="submit">Сохранить</button>-->
    </form>
        <#else>
            <h1 class="text-danger">Нет такого автора</h1>
            <a href="/author" class="badge badge-info">Список авторов</a>
    </#if>
</@c.page>