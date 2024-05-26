// Задание 1
// Создайте функцию которая возводит переданное число в куб, необходимо вывести в консоль результат 2^3 степени + 3 ^ 3 степени

function myExponentiation(params) {

    return params * params * params;
    
}

console.log(myExponentiation(2) + myExponentiation(3));