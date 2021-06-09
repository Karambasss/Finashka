<#import "parts/common.ftl" as c>
<@c.page>
    <form action="/clientUser/createContract" method="post">

        <input type="number" name="value" placeholder="Введите количество товара" required style="width: 15em">
        <input type="hidden" value="${_csrf.token}" name="_csrf"> <br>
        <input type="date" name="date" required><br>
        <label class="text-primary"> Выберите продукт, который вы хотите заказать
            <select name="product_selected_id" required>
                <#list production?if_exists as pr>
                    <option value="${pr.id}">${pr.name}</option>
                </#list>
            </select></label>
        <button class="btn btn-primary mb-2" type="submit">Создать заказ</button>
    </form>

</@c.page>