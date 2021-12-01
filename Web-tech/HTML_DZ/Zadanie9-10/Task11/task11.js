function sr_razn(m,c){
    if (m.length == c.length){
        let rez = 0;
        for (let i = 0; i < m.length; i++){
            rez += (m[i] - c[i])
        }
        return rez/m.length;
    }
    else{
        return null;
    }
}
let mother = [44,73,62,55,50]
let child = [10,46,42,33,25]

result = sr_razn(mother,child);
console.log("Средняя разница в возрасте =", result)