function countBs(word) {
    let counter = 0;
    for (let i = 0; i < word.length;  i++){
        if (word.charAt(i) == "B"){
            counter++
        }
    }
    return counter;
}
function countChar(word, lettr) {
    let counter = 0;

    for (let i = 0; i<word.length; i++){
        if (word.charAt(i) == lettr){
            counter++
        }
    }
    return counter;
}


console.log(countBs(prompt("Ввод строки! ")))
console.log(countChar(prompt("Ввод строки! "), prompt("Ввод буквы по которой хотите вести поиск! ")))