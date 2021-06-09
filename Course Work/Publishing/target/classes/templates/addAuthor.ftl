<#import "parts/common.ftl" as c>
<@c.page>
    <h1 class="text-primary">Добавление нового автора</h1>
    ${message!}
    <form action="/author/add" method="post">
        <div><label>Введите имя автора: <input type="text" name="name" required> </label></div>
        <div><label>Введите фамилию автора: <input type="text" name="surname" required> </label></div>
        <div><label>Введите возраст автора: <input type="text" name="age" required></label></div>
        <div><label>Введите адрес автора: <input type="text" name="adress"> </label></div>
        <div><label>Введите мейл автора: <input type="text" name="email"> </label></div>
        <div><label>Введите телефонный номер автора: <input type="text" name="telephone_number"> </label></div>
        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <button class="btn btn-primary mb-2" type="submit">Добавить</button>
<#--        <div><input type="submit" value="Add"/></div>-->
<#--        <button class="btn btn-primary mb-2" type="submit">Click me</button>-->
    </form>
</@c.page>