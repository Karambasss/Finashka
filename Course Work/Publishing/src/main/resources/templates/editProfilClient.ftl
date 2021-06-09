<#import "parts/common.ftl" as c>
<@c.page>
    <#if client??>
        <h1 class="text-primary">Редактирование своего профиля</h1>
        <form action="/clientUser/profil" method="post">
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
                    <td><input type="text" name="nameClient" value="${client.name!}"></td>
                    <td><input type="text" name="surnameClient" value="${client.surname!}"></td>
                    <td><input type="text" name="ageClient" value="${client.age!}"></td>
                    <td><textarea name="adressClient">${client.adress!}</textarea></td>
                    <td><input type="text" name="emailClient" value="${client.email!}"></td>
                    <td><input type="text" name="telephone_numberClient" value="${client.telephone_number!}"></td>
                    <td><input type="text" name="organization_nameClient"  value="${client.organization_name!}"></td>
                    <td><input type="text" name="requisitesClient" value="${client.requisites!}"></td>
                </tr>
                </tbody>
            </table>
            <input type="hidden" name="clientUserID" value="${client.id}">
            <input type="hidden" value="${_csrf.token}" name="_csrf">
            <button class="btn btn-primary mb-2" type="submit">Сохранить</button>
            <#--            <button type="submit">Сохранить</button>-->
        </form>
    <#else>
        <h1 class="text-danger">Нет такого профиля</h1>
        <a href="/clientUser/profil" class="badge badge-info">Вернуться на профиль</a>
    </#if>
</@c.page>