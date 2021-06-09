<#import "parts/common.ftl" as c>
<@c.page>
    <form action="/logout" method="post">
        <input type = "hidden" name = "_csrf" value="${_csrf.token}"/>
        <button class="btn btn-primary mb-2" type="submit" style="float: right; margin-right: 5px;">Sign out</button>
        <#--        <input type="submit" value="Sign Out"/>-->
    </form>
    <h1 class="text-primary">Здравствуй, прекрасно выглядишь!</h1>
    <p>
    </p>
    <div>
        <a href="/clientUser/profil" class="badge badge-light" style="font-size: 15px">Профиль</a>
    </div>
    <p>

    </p>
    <div>
        <a href="/clientUser/createContract" class="badge badge-light" style="font-size: 15px">Создать заказ</a>
    </div>
    <p>
    </p>
    </p>
    <div>
        <a href="/clientUser/contracts" class="badge badge-light" style="font-size: 15px">Ваши заказы</a>
    </div>
    <p>
    </p>
<#--    <#if contract??>-->
<#--        <h1 class="text-primary"> Ваши заказы </h1>-->
<#--        <table class="table table-bordered">-->
<#--            <thead>-->
<#--            <tr>-->
<#--                <th scope="col">Реквизиты клиента</th>-->
<#--                <th scope="col">Реквизиты издателя</th>-->
<#--                <th scope="col">Дата заключения договора</th>-->
<#--                <th scope="col">Цена</th>-->
<#--                <th scope="col">Количество</th>-->
<#--                <th scope="col">Редактировать</th>-->
<#--            </tr>-->
<#--            </thead>-->
<#--            <tbody>-->
<#--                    <td class="text-primary">${contract.client_requisites!}</td>-->
<#--                    <td class="text-primary">${contract.publisher_requisites!}</td>-->
<#--                    <td class="text-success">${contract.date_of_agreement!}</td>-->
<#--                    <td class="text-success">${contract.price!}</td>-->
<#--                    <td class="text-info">${contract.value!}</td>-->
<#--                    <td><a href="/contract/${contract.id}" class="badge badge-info">Редактировать</a></td>-->
<#--            </tbody>-->
<#--        </table>-->
<#--    <#else>-->
<#--        <div></div>-->
<#--        <h1 class="text-danger">Нет заказов</h1>-->
<#--    </#if>-->
</@c.page>