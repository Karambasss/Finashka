<#import "parts/common.ftl" as c>
<@c.page>
    <#if size != 0>
    <h1 class="text-primary">Список наших клиентов</h1>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Имя</th>
                <th scope="col">Фамилия</th>
                <th scope="col">Возраст</th>
                <th scope="col">Адрес</th>
                <th scope="col">Мейл</th>
                <th scope="col">Телефонный номер</th>
                <th scope="col">Имя организации</th>
                <th scope="col">Реквизиты</th>
<#--                <th scope="col">Редактировать</th>-->
            </tr>
            </thead>
            <tbody>
            <#list clients as client>
                <tr>
                    <th class="" scope="row">${client?index + 1}</th>
                    <td class="text-primary">${client.name!}</td>
                    <td class="text-primary">${client.surname!}</td>
                    <td class="text-success">${client.age!}</td>
                    <td class="text-success">${client.adress!}</td>
                    <td class="text-danger">${client.email!}</td>
                    <td class="text-danger">${client.telephone_number!}</td>
                    <td class="text-info">${client.organization_name!}</td>
                    <td class="text-info">${client.requisites!}</td>
<#--                    <td><a href="/client/${client.id}" class="badge badge-info">Редактировать</a></td>-->
                </tr>
            </#list>
            </tbody>
        </table>
    <#else>
        <div></div>
        <h1 class="text-danger">Нет клиентов</h1>
    </#if>
</@c.page>