function reverseArray (array) {
    let new_array = []
    for (let i = array.length-1; i >= 0; i--){
        new_array.push(array[i])
    }
    return new_array;
}
function reverseArrayInPlace(array){
    let new_arr = []
    for (let i = array.length-1; i >= 0; i--){
        new_arr.push(array[i])
    }
    for (let i = array.length-1; i >= 0; i--){
        array[i] = new_arr[i]
    }
}

my_array = [1,2,3,4,5,6,7,8,9,10]

console.log("1 задание\n", reverseArray(my_array))

reverseArrayInPlace(my_array)

console.log("2 задание\n", my_array)