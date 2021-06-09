<#import "parts/common.ftl" as c>
<@c.page>
    <#if size != 0>
        <h1 class="text-primary">Список договоров</h1>

        <form action="/contract/sort" method="post">
            <select name="sort_type">
                <option value="price">Цена</option>
                <option value="value">Количество товара</option>
                <#--                <option value="date_of_agreement">Дата</option>-->
            </select>
            <input type="hidden" value="${_csrf.token}" name="_csrf">
            <button class="btn btn-primary mb-2" type="submit">Сортировать</button>
        </form>

        <form action="/contract/analytics" method="post">
            <select name="analytics">
                <option value="max">Максимальная цена заказа</option>
                <option value="min">Минимальная цена заказа</option>
                <option value="srznach">Средняя цена заказа</option>
                <option value="summ">Общая выручка</option>
            </select>
            <input type="hidden" value="${_csrf.token}" name="_csrf">
            <button class="btn btn-primary mb-2" type="submit">Выбрать</button>
        </form>
        <#if message??>
            <div><h3 class="text-primary"> Ответ: ${message}</h3></div>
        </#if>

        <br>

        <table class="table table-bordered">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Реквизиты клиента</th>
                <th scope="col">Реквизиты издателя</th>
                <th scope="col">Дата заключения договора</th>
                <th scope="col">Цена</th>
                <th scope="col">Количество</th>
                <th scope="col">Название товара</th>
                <th scope="col">Статус</th>
                <th scope="col">Типография</th>
                <th scope="col">Автор</th>
                <th scope="col">Редактировать</th>
            </tr>
            </thead>
            <tbody>
            <h3 class="text-primary">Необработанные заказы</h3>
            <#list contracts as contract>
                <#if contract.status == "Не обработан">

                    <tr>
                        <th class="" scope="row">${contract?index + 1}</th>
                        <td class="text-primary">${contract.client_requisites!}</td>
                        <td class="text-primary">${contract.publisher_requisites!}</td>
                        <td class="text-success">${contract.date_of_agreement!}</td>
                        <td class="text-success">${contract.price!}</td>
                        <td class="text-info">${contract.value!}</td>
                        <#if contract.production??>
                            <td class="text-info">${contract.production.name!}</td>
                        <#else>
                            <td class="text-info"></td>
                        </#if>
                        <td class="text-info">${contract.status!}</td>
                        <#if contract.typography??>
                            <td class="text-danger">${contract.typography.name}</td>
                        <#else>
                            <td class="text-danger">Нет типографий</td>
                        </#if>
                        <#if contract.author??>
                            <td class="text-danger">${contract.author.name}</td>
                        <#else>
                            <td class="text-danger">Нет авторов</td>
                        </#if>
                        <td><a href="/contract/${contract.id}" class="badge badge-info">Редактировать</a></td>
                    </tr>
                </#if>
            </#list>


            </tbody>
        </table>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Реквизиты клиента</th>
                <th scope="col">Реквизиты издателя</th>
                <th scope="col">Дата заключения договора</th>
                <th scope="col">Цена</th>
                <th scope="col">Количество</th>
                <th scope="col">Название товара</th>
                <th scope="col">Статус</th>
                <th scope="col">Типография</th>
                <th scope="col">Автор</th>
                <th scope="col">Редактировать</th>
            </tr>
            </thead>
            <tbody>
            <h3 class="text-primary">Обработанные заказы</h3>
            <#list contracts as contract>
                <#if contract.status == "Заказ в работе">

                    <tr>
                        <th class="" scope="row">${contract?index + 1}</th>
                        <td class="text-primary">${contract.client_requisites!}</td>
                        <td class="text-primary">${contract.publisher_requisites!}</td>
                        <td class="text-success">${contract.date_of_agreement!}</td>
                        <td class="text-success">${contract.price!}</td>
                        <td class="text-info">${contract.value!}</td>
                        <#if contract.production??>
                            <td class="text-info">${contract.production.name!}</td>
                        <#else>
                            <td class="text-info"></td>
                        </#if>
                        <td class="text-info">${contract.status!}</td>
                        <#if contract.typography??>
                            <td class="text-danger">${contract.typography.name}</td>
                        <#else>
                            <td class="text-danger">Нет типографий</td>
                        </#if>
                        <#if contract.author??>
                            <td class="text-danger">${contract.author.name}</td>
                        <#else>
                            <td class="text-danger">Нет авторов</td>
                        </#if>
                        <td><a href="/contract/${contract.id}" class="badge badge-info">Редактировать</a></td>
                    </tr>
                </#if>
            </#list>


            </tbody>
        </table>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Реквизиты клиента</th>
                <th scope="col">Реквизиты издателя</th>
                <th scope="col">Дата заключения договора</th>
                <th scope="col">Цена</th>
                <th scope="col">Количество</th>
                <th scope="col">Название товара</th>
                <th scope="col">Статус</th>
                <th scope="col">Типография</th>
                <th scope="col">Автор</th>
                <th scope="col">Редактировать</th>
            </tr>
            </thead>
            <tbody>
            <h3 class="text-primary">Отмененные заказы</h3>
            <#list contracts as contract>
                <#if contract.status == "Заказ отклонен">

                    <tr>
                        <th class="" scope="row">${contract?index + 1}</th>
                        <td class="text-primary">${contract.client_requisites!}</td>
                        <td class="text-primary">${contract.publisher_requisites!}</td>
                        <td class="text-success">${contract.date_of_agreement!}</td>
                        <td class="text-success">${contract.price!}</td>
                        <td class="text-info">${contract.value!}</td>
                        <#if contract.production??>
                            <td class="text-info">${contract.production.name!}</td>
                        <#else>
                            <td class="text-info"></td>
                        </#if>
                        <td class="text-info">${contract.status!}</td>
                        <#if contract.typography??>
                            <td class="text-danger">${contract.typography.name}</td>
                        <#else>
                            <td class="text-danger">Нет типографий</td>
                        </#if>
                        <#if contract.author??>
                            <td class="text-danger">${contract.author.name}</td>
                        <#else>
                            <td class="text-danger">Нет авторов</td>
                        </#if>
                        <td class="text-danger">Редактирование недоступно</td>
                    </tr>
                </#if>
            </#list>
            </tbody>
        </table>
    <#else>
        <div></div>
        <h1 class="text-danger">Нет договоров</h1>
    </#if>
</@c.page>