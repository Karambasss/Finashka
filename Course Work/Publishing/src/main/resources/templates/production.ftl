<#import "parts/common.ftl" as c>
<@c.page>
    <div><span> <a href="production/add" class="badge badge-primary">Добавить продукцию</a></span></div>
    <#if size != 0>
    <h1 class="text-primary">Список продукции</h1>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Имя</th>
                <th scope="col">Описание</th>
                <th scope="col">Список типографий</th>
                <th scope="col">Редактировать</th>
                <th scope="col">Удалить</th>
            </tr>
            </thead>
            <tbody>
            <#list productions as production>
                <tr>
                    <th class="" scope="row">${production?index + 1}</th>
                    <td class="text-primary">${production.name!}</td>
                    <td class="text-info">${production.description!}</td>
                    <td class="text-danger"><#list production.typographies as t>
                            ${t.getName()}
                        </#list>
                    </td>
                    <td><a href="/production/${production.id}" class="badge badge-info">Редактировать</a></td>
                    <td><a href="/production/del/${production.id}" class="badge badge-danger">Удалить</a></td>
                </tr>
            </#list>
            </tbody>
        </table>
    <#else>
        <div></div>
        <h1 class="text-danger">Нет продукции</h1>
    </#if>
</@c.page>