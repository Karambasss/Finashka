function min(a, b) {
    if (a < b)
        return a;
    else
        return b;
}

console.log(min(Number(prompt("Введите первое число: ")), Number(prompt("Введите второе число: "))));