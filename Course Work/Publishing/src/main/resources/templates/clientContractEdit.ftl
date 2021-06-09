<#import "parts/common.ftl" as c>
<@c.page>
    <#if contract??>
        <h1 class="text-primary">Редактирование заказа</h1>
        <form action="/clientUser/contracts" method="post">
            <table>
                <thead>
                <tr>
                    <th>Ваши реквизиты</th>
                    <th>Срок выполнения заказа</th>
                    <th>Цена</th>
                    <th>Количество</th>
                    <th>Статус</th>
                    <th>Заказанный товар</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>${contract.client_requisites!}</td>
<#--                    <td><input type="text" name="client_requisites" value="${contract.client_requisites!}"></td>-->
                    <td>${contract.date_of_agreement!}</td>
<#--                    <td><input type="date" name="date" value="${contract.date_of_agreement!}"></td>-->
                    <td>${contract.price!}</td>
                    <td><input type="number" name="value" value="${contract.value?c!}" required></td>
                    <td>${contract.status!}</td>
                    <#if contract.production??>
                        <td>${contract.production.name!}</td>
                    <#else>
                        <td></td>
                    </#if>
                </tr>
                </tbody>
            </table>
            <input type="hidden" name="contractID" value="${contract.id}">
            <input type="hidden" value="${_csrf.token}" name="_csrf">
            <button class="btn btn-primary mb-2" type="submit">Сохранить</button>
            <#--            <button type="submit">Сохранить</button>-->
        </form>
        <#else>
            <h1 class="text-danger">Нет такого заказа</h1>
            <a href="/clientUser/contracts" class="badge badge-info">Список ваших заказов</a>
    </#if>
</@c.page>