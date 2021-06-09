<#import "parts/common.ftl" as c>
<@c.page>
    <#if typography??>
    <h1 class="text-primary">Редактирование типографии</h1>
    <form action="/typography" method="post">
        <table>
            <thead>
            <tr>
                <th>Имя</th>
                <th>Реквизиты</th>
                <th>Телефонный номер</th>
                <th>Адрес</th>
            </tr>
            </thead>
            <tbody>
                <tr>
                    <td><input type="text" name="name" value="${typography.name!}"></td>
                    <td><input type="text" name="requisites" value="${typography.requisites!}"></td>
                    <td><input type="text" name="telephone_number" value="${typography.telephone_number!}"> </td>
                    <td><textarea name="typography_address">${typography.typography_address!}</textarea> </td>
                </tr>
            </tbody>
        </table>
        <input type="hidden" name="typographyID" value="${typography.id}">
        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <button class="btn btn-primary mb-2" type="submit">Сохранить</button>
<#--        <button type="submit">Сохранить</button>-->
    </form>
        <#else>
            <h1 class="text-danger">Нет такой типографии</h1>
            <a href="/typography" class="badge badge-info">Список типографий</a>
    </#if>
</@c.page>