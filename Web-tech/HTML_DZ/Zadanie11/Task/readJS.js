async function finit() {

    let url = 'http://127.0.0.1/data.json';
    let AS = await (await fetch(url)).json();
    let k = AS.length
    let s = "<table border width=500> <tr><th>Автостанция<th>Телефон"
    for (i=0; i<k; i++){
        ns = AS[i].Name
        ts = AS[i].PublicPhone[0].Phone
        s += "<tr><td>"+ns+"<td>"+ ts
    }
    s += "</table>"
    document.getElementById("AS").innerHTML = s
}