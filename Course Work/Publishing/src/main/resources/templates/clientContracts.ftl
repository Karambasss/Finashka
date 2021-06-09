<#import "parts/common.ftl" as c>
<@c.page>
    <#if size != 0>
        <h1 class="text-primary">Ваши заказы</h1>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Ваши реквизиты</th>
                <th scope="col">Срок выполнения заказа</th>
                <th scope="col">Цена</th>
                <th scope="col">Количество</th>
                <th scope="col">Статус</th>
                <th scope="col">Заказанный товар</th>
                <th scope="col">Редактировать</th>
            </tr>
            </thead>
            <tbody>
            <#list contracts as contract>
                <tr>
                    <th class="" scope="row">${contract?index + 1}</th>
                    <td class="text-primary">${contract.client_requisites!}</td>
                    <td class="text-success">${contract.date_of_agreement!}</td>
                    <td class="text-success">${contract.price!}</td>
                    <td class="text-info">${contract.value!}</td>
                    <td class="text-info">${contract.status!}</td>
                    <#if contract.production??>
                        <td class="text-danger">${contract.production.name!}</td>
                    <#else>
                        <td class="text-danger">Товара нет в наличии</td>
                    </#if>
                    <#if contract.status == "Не обработан">
                    <td><a href="/clientUser/contracts/${contract.id}" class="badge badge-info">Редактировать</a></td>
                        <#else>
                        <td class="text-danger">Редактирование недоступно</td>
                    </#if>
                </tr>
            </#list>
            </tbody>
        </table>
        <#else>
            <div></div>
            <h1 class="text-danger">Нет заказов</h1>
    </#if>
</@c.page>