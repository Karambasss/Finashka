<#import "parts/common.ftl" as c>
<@c.page>
    Список пользователей
    <table class="table table-bordered">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Username</th>
            <th scope="col">Role</th>
            <th scope="col">Edit</th>
        </tr>
        </thead>
        <tbody>
        <#list users as user>
        <tr>
            <th class="" scope="row">${user?index + 1}</th>
            <td >${user.username}</td>
            <td ><#list user.roles as role> ${role}<#sep>, </#list></td>
            <td><a href="/user/${user.id}" >edit</a></td>
        </tr>
        </#list>
        </tbody>
    </table>
<#--    <table xmlns="http://www.w3.org/1999/html">-->
<#--        <thead>-->
<#--        <tr>-->
<#--            <th>NAME</th>-->
<#--            <th>ROLE</th>-->
<#--            <th></th>-->
<#--        </tr>-->
<#--        </thead>-->
<#--        <tbody>-->
<#--    <#list users as user>-->
<#--        <tr>-->
<#--            <td>${user.username}</td>-->
<#--            <td><#list user.roles as role> ${role}<#sep>, </#list></td>-->
<#--            <td><a href="/user/${user.id}">edit</a></td>-->
<#--        </tr>-->
<#--    </#list>-->
<#--        </tbody>-->
<#--    </table>-->
</@c.page>