function some(array, predicate) {
    for (let index in array) {
        if (predicate(array[index])) {
            return true;
        }
    }
    return false;
}

function every(array, predicate) {
    for (let element of array) {
        if (!predicate(element)) {
            return false;
        }
    }
    return true;
}

console.log(every([NaN, NaN, NaN], isNaN))

console.log(every([NaN, NaN, 1], isNaN))

console.log(some([NaN, NaN, NaN], isNaN))

console.log(some([3, 2, 1], isNaN))