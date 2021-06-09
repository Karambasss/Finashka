<#import "parts/common.ftl" as c>
<@c.page>
    <#if production??>
        <h1 class="text-primary">Редактирование продукции</h1>
        <form action="/production" method="post">
            <table>
                <thead>
                <tr>
                    <th>Имя</th>
                    <th>Описание</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td><input type="text" name="name" value="${production.name!}"></td>
                    <td><input type="text" name="description" value="${production.description!}"></td>
                </tr>
                </tbody>
            </table>
            <#list typographies as t>
                <div>
                    <label><input type="checkbox" name="${t.id}" ${production.typographies?seq_contains(t)?string("checked","")}>${t.name}</label>
                </div>
            </#list>
            <input type="hidden" name="productionID" value="${production.id}">
            <input type="hidden" value="${_csrf.token}" name="_csrf">
            <button class="btn btn-primary mb-2" type="submit">Сохранить</button>
<#--            <button type="submit">Сохранить</button>-->
        </form>
    <#else>
        <h1 class="text-danger">Нет такой продукции</h1>
        <a href="/production" class="badge badge-info">Список продукций</a>
    </#if>
</@c.page>