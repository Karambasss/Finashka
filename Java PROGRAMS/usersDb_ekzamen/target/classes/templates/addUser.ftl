<h1>Добавление нового юзера</h1>
<form action="/user/add" method="post">
    <div><label>Введите возраст юзера: <input type="text" name="age" required> </label></div>
    <div><label>Введите имя юзера: <input type="text" name="name" required> </label></div>
    <div><label>Введите фамилию юзера: <input type="text" name="surname" required></label></div>
    <div><label>Введите группу юзера: <input type="text" name="group_num" required> </label></div>
    <button type="submit">Добавить</button>
    <#--        <div><input type="submit" value="Add"/></div>-->
</form>