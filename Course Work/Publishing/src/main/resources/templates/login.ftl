<#import "parts/common.ftl" as c>
<@c.page>
    <form action="/login" method="post">
        <div class="form-group row">
            <label class="col-sm-1 col-form-label"> Логин:</label>
            <div class="col-sm-6">
                <input type="text" name="username" placeholder="Введи свой логин" required/>
            </div>
        </div>
<#--        <div><label> User Name : <input type="text" name="username"/> </label></div>-->
        <div class="form-group row">
            <label class="col-sm-1 col-form-label"> Пароль: </label>
            <div class="col-sm-6">
                <input type="password" name="password" placeholder="Введи свой пароль" required/>
            </div>
        </div>
        <input type = "hidden" name = "_csrf" value="${_csrf.token}"/>
        <button class="btn btn-primary mb-2" type="submit">Sign in</button>
<#--        <div><input type="submit" value="Sign In"/></div>-->
    </form>
    <#if loginError??>
        <h4 class="text-danger">Вы ввели не тот логин/пароль</h4>
    </#if>
</@c.page>