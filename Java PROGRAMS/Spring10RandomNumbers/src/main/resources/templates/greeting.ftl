<form method="post">
    <div><label> First_chislo: <input type="number" name="chislo1" required/> </label></div>
    <div><label> Second_chislo: <input type="number" name="chislo2" required/> </label></div>
    <div><input type="submit" value="Отправить"/></div>
</form>
    <#if range??>
        <div>Ваши случайные числа: ${range}</div>
    </#if>

    <#if message??>
        <div>Ответ: ${message}</div>
    </#if>