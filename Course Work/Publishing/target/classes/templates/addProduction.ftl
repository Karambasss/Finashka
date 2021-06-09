<#import "parts/common.ftl" as c>
<@c.page>
    <h1 class="text-primary">Добавление новой продукции</h1>
    <form action="/production/add" method="POST">
        <div><label>Введите название продукции: <input type="text" name="name" required> </label></div>
        <div><label>Введите описание продукции: <input type="text" name="description"> </label></div>
        <#list typographies as t>
            <div>
                <label><input type="checkbox" name="${t.id}">${t.name}</label>
            </div>
        </#list>
        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <button class="btn btn-primary mb-2" type="submit">Добавить</button>
<#--        <input type="submit" value="Add">-->
    </form>
</@c.page>