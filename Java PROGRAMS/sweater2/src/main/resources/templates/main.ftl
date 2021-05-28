<#import "parts/common.ftl" as c>

<@c.page>
    <div class="form-row">
        <div class="form-group col-md-6">
            <form method="get" action="/main" class="form-inline">
                <input type="text" name="my_tag" class="form-control" value="${input_tag!}" placeholder="Search by tag">
                <button type="submit" class="btn btn-primary ml-2">Search</button>
            </form>
        </div>
    </div>
    <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
        Add new message
    </a>
<div class="collapse" id="collapseExample">
    <div class="form-group mt-3">
    <form method="post" >
        <div>
        <input type="text" name="text" class="form-control" placeholder="Введите сообщение" /> <br>
        </div>
        <div>
        <input type="text" name="tag" class="form-control"  placeholder="Тэг"> <br>
        </div>
        <input type = "hidden" name = "_csrf" value="${_csrf.token}"/>
        <div>
        <button type="submit" class="btn btn-primary">Добавить</button>
        </div>
    </form>
    </div>
</div>

    <div class="card-columns">
        <#list messages as message>
            <div class="card my-3">
                <div class="m-2">
                    <span>${message.text}</span>
                    <i>${message.tag}</i>
                </div>
                <div class="card-footer text-muted">
                    ${message.authorName}
                </div>
            </div>
        <#else>
            No message
        </#list>
    </div>
<!-- action = это переход на новый url -->
</@c.page>