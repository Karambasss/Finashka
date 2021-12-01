let array = [[1,2,3,4,5], [6,7,8,9,10], [11,12,13,14], [15,16,17,18], [19,20,21,22]]

console.log(array)

let reduced_array = array.reduce(function (prev,item){
    return prev.concat(item); // prev изначально является [0] элементом массива array, после выполнения первого return prev станет равен [1,2,3,4,5,6,7,8,9,10]
    // то есть, item - это [1],[2],[3],[4] элементы, а prev - как результат действия 0 строки с этими строками из prev
})

console.log(reduced_array)