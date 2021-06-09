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
        <a href="/employee" class="badge badge-light" style="font-size: 15px">Ссылка на список сотрудников!</a>
    </div>
    <p>

    </p>
    <div>
        <a href="/typography" class="badge badge-light" style="font-size: 15px">Ссылка на список типографий!</a>
    </div>
    <p>

    </p>
    <div>
        <a href="/author" class="badge badge-light" style="font-size: 15px">Ссылка на список авторов!</a>
    </div>
    <p>

    </p>
    <div>
        <a href="/client" class="badge badge-light" style="font-size: 15px">Ссылка на список клиентов!</a>
    </div>
    <p>

    </p>
    <div>
        <a href="/contract" class="badge badge-light" style="font-size: 15px">Ссылка на список договоров!</a>
    </div>
    <p>

    </p>
    <div>
        <a href="/production" class="badge badge-light" style="font-size: 15px">Ссылка на список продукции!</a>
    </div>
</@c.page>