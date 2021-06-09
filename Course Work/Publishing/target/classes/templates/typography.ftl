<#import "parts/common.ftl" as c>
<@c.page>
    <div><span> <a href="/typography/add" class="badge badge-primary">Добавить типографию</a></span></div>
    <#if size != 0>
        <h1 class="text-primary">Список типографий</h1>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Имя</th>
                <th scope="col">Реквизиты</th>
                <th scope="col">Телефонный номер</th>
                <th scope="col">Адрес</th>
                <th scope="col">Продукция</th>
                <th scope="col">Редактировать</th>
                <th scope="col">Удалить</th>
            </tr>
            </thead>
            <tbody>
            <#list typographies as typography>
                <tr>
                    <th class="" scope="row">${typography?index + 1}</th>
                    <td class="text-primary">${typography.name!}</td>
                    <td class="text-primary"> ${typography.requisites!}</td>
                    <td class="text-success"> ${typography.telephone_number!}</td>
                    <td class="text-success">${typography.typography_address!}</td>
                    <td class="text-danger"><#list typography.productionSet as ps> ${ps.name} </#list></td>
                    <td><a href="/typography/${typography.id}" class="badge badge-info">Редактировать</a></td>
                    <td><a href="/typography/del/${typography.id}" class="badge badge-danger">Удалить</a></td>
                </tr>
            </#list>
            </tbody>
        </table>
    <#else>
        <div></div>
        <h1 class="text-danger">Нет типографий</h1>
    </#if>
</@c.page>