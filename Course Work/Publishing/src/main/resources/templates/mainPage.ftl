<#import "parts/common.ftl" as c>
<@c.page>

    <h1 class="text-primary">Приветствую вас на главной странице нашего сайта</h1>
    <p>
    </p>
    <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
        Полезная информация
    </a>
    <div class="collapse" id="collapseExample">
        <div class="card card-body" style="background-color: #C1FFC1">
            Здравствуйте, я ваш помощник!<br>
            Если вы нажмете на кнопку "Домой", тогда вы попадете на текущую страницу.<br>
            Если вы нажмете на кнопку "Обо мне", тогда вы попадете на страницу, рассказывающую обо мне и моем проекте.<br>
            Если вы нажмете на кнопку "Меню", тогда вы попадете на страницу входа для сотрудников издательства и для клиентов, а дальше, при успешном вводе логина и пароля, вы попадете, в зависимости, кто вы, на меню для сотрудников, или на меню для клиентов.<br>
            Если вы нажмете на кнопку "Регистрация", тогда вы попадете на регистрацию для клиентов.<br>
            После того как вы зарегистрируетесь, вы можете нажать на кнопку меню и зайти, используя логин и пароль, в ваш личный профиль.
        </div>
    </div>

    <br>
    <br>

    <#if size != 0>
        <h3 class="text-primary"> Список товаров, которые вы можете у нас заказать </h3>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Название товара</th>
                <th scope="col">Описание</th>
            </tr>
            </thead>
            <tbody>
            <#list productions as production>
                <tr>
                    <th class="" scope="row">${production?index + 1}</th>
                    <td class="text-primary">${production.name!}</td>
                    <td class="text-info">${production.description!}</td>
                </tr>
            </#list>
            </tbody>
        </table>
    <#else>
        <div></div>
        <h1 class="text-danger"></h1>
    </#if>
</@c.page>