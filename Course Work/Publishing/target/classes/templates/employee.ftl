<#import "parts/common.ftl" as c>
<@c.page>
    <div><span><a href="employee/add" class="badge badge-primary">Добавить сотрудника</a></span></div>
    <#if size != 0>
    <h1 class="text-primary">Список сотрудников</h1>

        <form action="/employee/sort" method="post">
            <select name="sort_type">
                <option value="name">Имя</option>
                <option value="surname">Фамилия</option>
                <option value="salary">Зарплата</option>
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
                <th scope="col">Зарплата</th>
                <th scope="col">Редактировать</th>
                <th scope="col">Удалить</th>
            </tr>
            </thead>
            <tbody>
            <#list employees as employee>
                <tr>
                    <th class="" scope="row">${employee?index + 1}</th>
                    <td class="text-primary">${employee.name!}</td>
                    <td class="text-primary">${employee.surname!}</td>
                    <td class="text-success">${employee.age!}</td>
                    <td class="text-success">${employee.adress!}</td>
                    <td class="text-danger">${employee.email!}</td>
                    <td class="text-danger">${employee.telephone_number!}</td>
                    <td class="text-info">${employee.salary!}</td>
                    <td><a href="/employee/${employee.id}" class="badge badge-info">Редактировать</a></td>
                    <td><a href="/employee/del/${employee.id}" class="badge badge-danger">Удалить</a></td>
                </tr>
            </#list>
            </tbody>
        </table>
    <#else>
        <div></div>
        <h1 class="text-danger">Нет сотрудников</h1>
    </#if>
</@c.page>