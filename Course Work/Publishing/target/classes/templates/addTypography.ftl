<#import "parts/common.ftl" as c>
<@c.page>
    <h1 class="text-primary">Добавление новой типографии</h1>
    ${message!}
    <form action="/typography/add" method="post">
        <div><label>Введите название типографии: <input type="text" name="name" required> </label></div>
        <div><label>Введите реквизиты типографии: <input type="text" name="requisites"> </label></div>
        <div><label>Введите телефонный номер типографии: <input type="text" name="telephone_number"></label></div>
        <div><label>Введите адрес типографии: <input type="text" name="typography_address"> </label></div>
        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <button class="btn btn-primary mb-2" type="submit">Добавить</button>
<#--        <div><input type="submit" value="Add"/></div>-->
    </form>
</@c.page>