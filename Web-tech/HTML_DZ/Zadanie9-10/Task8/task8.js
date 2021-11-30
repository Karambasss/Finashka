function arrayToList(array) {

    let list = null;

    array.reverse().map(item => list = {value: item, rest: list});

    return list;

}

function listToArray(list, array = []) {

    array.push(list.value);

    if (list.rest !== null) {

        return listToArray(list.rest, array);

    }

    return array;

}

function prepend(value, list) {

    return {value: value, rest: list}

}


function nth(list, num) {

    if (num === 0) {

        return list.value;

    } else if (list.rest !== null) {

        return nth(list.rest, num - 1);

    }
    return undefined

}