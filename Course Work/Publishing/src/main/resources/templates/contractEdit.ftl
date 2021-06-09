<#import "parts/common.ftl" as c>
<@c.page>
    <#if contract??>
        <h1 class="text-primary">Редактирование договора</h1>
        <form action="/contract" method="post">
            <table>
                <thead>
                <tr>
                    <th>Реквизиты клиента</th>
                    <th>Срок выполнения заказа</th>
                    <th>Цена</th>
                    <th>Количество</th>
                    <th>Автор</th>
                    <th>Типография</th>
                    <th>Название товара</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>${contract.client_requisites!}</td>
                    <td>${contract.date_of_agreement!}</td>
                    <#if contract.price??>
                        <td><input type="number" name="price" value="${contract.price!?c}" required></td>
                    <#else>
                        <td><input type="number" name="price" required></td>
                    </#if>
                    <td>${contract.value!}</td>
                    <td>
                        <label class="text-primary">
                            <select name="author_selected_id" required>
                                <#list authors?if_exists as au>
                                    <option value="${au.id}">${au.name}</option>
                                </#list>
                            </select></label>
                    </td>
                    <td>
                        <label class="text-primary">
                            <select name="typography_selected_id" required>
                                <#list typographies?if_exists as tr>
                                    <option value="${tr.id}">${tr.name}</option>
                                </#list>
                            </select></label>
                    </td>
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
        <h1 class="text-danger">Нет такого договора</h1>
        <a href="/contract" class="badge badge-info">Список договоров</a>
    </#if>
</@c.page>