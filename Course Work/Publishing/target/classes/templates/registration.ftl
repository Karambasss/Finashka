<#import "parts/common.ftl" as c>
<@c.page>
    <h1 class="text-primary">Страница регистрации</h1>
    ${message!}
        <form action="/registration" method="post">
        <input type="text" name="name" placeholder="Введите ваше имя" required><br>
        <input type="text" name="surname" placeholder="Введите вашу фамилию" required><br>
        <input type="text" name="organization_name" placeholder="Введите название вашей организации" required size="35px"><br>
            <div><h3 class="text-primary"><label>Информация для входа</label></h3></div>
            <input type="text" name="username" placeholder="Введите ваш логин" required><br>
            <input type="text" name="password" placeholder="Введите ваш пароль" required><br>
            <input type="hidden" value="${_csrf.token}" name="_csrf">
            <button class="btn btn-primary mb-2" type="submit" style="margin-top: 5px">Добавить</button>
    </form>
</@c.page>