<#macro login path isRegisterForm>
    <form action="${path}" method="post">
        <div class="form-group row">
            <label class="col-sm-1 col-form-label"> User Name :</label>
            <div class="col-sm-6">
                <input type="text" name="username" placeholder="User name"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-1 col-form-label"> Password: </label>
            <div class="col-sm-6">
            <input type="password" name="password" placeholder="Password"/>
            </div>
        </div>
        <input type = "hidden" name = "_csrf" value="${_csrf.token}"/>
        <#if !isRegisterForm><a href="/registration">Add new user </a></#if>
        <button class="btn btn-primary mb-2" type="submit">
        <#if isRegisterForm>Create
        <#else> Sign In
        </#if>
        </button>
    </form>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <input type = "hidden" name = "_csrf" value="${_csrf.token}"/>
        <button class="btn btn-primary mb-2" type="submit"> Sign Out</button>
    </form>
</#macro>
