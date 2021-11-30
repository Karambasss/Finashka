function range(start, end, step){
    let arr = []
    if (step >= 0) {
        for (let i = start; i <= end; i += step) {
            arr.push(i)
        }
    }
    else {
        for (let i = end; i >= start; i+=step) {
            arr.push(i)
        }
    }
    return arr;
}
function sum(arr){
    let forS = 0
    for (let i = 0; i< arr.length; i++){
        forS+=arr[i]
    }
    return forS;
}

my_array = range(Number(prompt("Начало")), Number(prompt("Конец")), Number(prompt("Введите шаг")) )
console.log(my_array)

my_summ = sum(my_array)
console.log(my_summ)

alert("Массив: " + my_array + "\n" + "Сумма чисел массива: " + my_summ)

