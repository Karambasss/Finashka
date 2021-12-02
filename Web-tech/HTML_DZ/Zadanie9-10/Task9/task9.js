function deepEqual(a, b) {
    if (a === b){
        return true;
    }
    if (a == null || typeof a != "object" ||
        b == null || typeof b != "object") {
        return false;
    }

    let keysA = Object.keys(a), keysB = Object.keys(b);

    if (keysA.length !== keysB.length){
        return false;
    }

    for (let key of keysA) {
        if (!keysB.includes(key) || !deepEqual(a[key], b[key])){
            return false;
        }
    }
    return true;
}

let obj = {michael: {kuznetsov: "student"}, my_group: 4};
console.log(deepEqual(obj, obj));
console.log(deepEqual(obj, {michael: 4, my_group: 5}));
console.log(deepEqual(obj, {michael: {kuznetsov: "student"}, my_group: 4}));