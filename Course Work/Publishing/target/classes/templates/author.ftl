<#import "parts/common.ftl" as c>
<@c.page>
    <div><span> <a href="/author/add" class="badge badge-primary">Добавить автора</a></span></div>
    <#if size != 0>
    <h1 class="text-primary">Список авторов</h1>

        <form action="/author/sort" method="post">
            <select name="sort_type">
                <option value="name">Имя</option>
                <option value="surname">Фамилия</option>
                <option value="age">Возраст</option>
            </select>
            <input type="hidden" value="${_csrf.token}" name="_csrf">
            <button class="btn btn-primary mb-2" type="submit">Сортировать</button>
        </form>

        <table class="table table-bordered">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Имя</th>
                <th scope="col">Фамилия</th>
                <th scope="col">Возраст</th>
                <th scope="col">Адрес</th>
                <th scope="col">Мейл</th>
                <th scope="col">Телефонный номер</th>
                <th scope="col">Редактировать</th>
                <th scope="col">Удалить</th>
            </tr>
            </thead>
            <tbody>
            <#list authors as author>
                <tr>
                    <th class="" scope="row">${author?index + 1}</th>
                    <td class="text-primary">${author.name!}</td>
                    <td class="text-primary">${author.surname!}</td>
                    <td class="text-success">${author.age!}</td>
                    <td class="text-success">${author.adress!}</td>
                    <td class="text-info">${author.email!}</td>
                    <td class="text-info">${author.telephone_number!}</td>
                    <td><a href="/author/${author.id}" class="badge badge-info">Редактировать</a></td>
                    <td><a href="/author/del/${author.id}" class="badge badge-danger">Удалить</a></td>
                </tr>
            </#list>
            </tbody>
        </table>
    <#else>
        <div></div>
        <h1 class="text-danger">Нет авторов</h1>
    </#if>
</@c.page>