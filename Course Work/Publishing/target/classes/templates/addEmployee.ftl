<#import "parts/common.ftl" as c>
<@c.page>
    <h1 class="text-primary">Добавление нового сотрудника</h1>
    ${message!}
    <form action="/employee/add" method="post">
       <div><label>Введите возраст сотрудника: <input type="text" name="age" required> </label></div>
       <div><label>Введите имя сотрудника: <input type="text" name="name" required> </label></div>
        <div><label>Введите фамилию сотрудника: <input type="text" name="surname" required></label></div>
        <div><label>Введите адрес сотрудника: <input type="text" name="adress"> </label></div>
        <div><label>Введите почту сотрудника: <input type="text" name="email"></label></div>
        <div><label>Введите телефон сотрудника: <input type="text" name="telephone_number"></label></div>
        <div><label>Введите зарплату сотрудника: <input type="text" name="salary" required></label></div>
        <div><h3 class="text-primary"><label>Информация для входа</label></h3></div>
        <div><label>Задайте логин для входа: <input type="text" name="login" required></label></div>
        <div><label>Задайте пароль для входа: <input type="password" name="password" required></label></div>
        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <button class="btn btn-primary mb-2" type="submit">Добавить</button>
<#--        <div><input type="submit" value="Add"/></div>-->
    </form>
</@c.page>