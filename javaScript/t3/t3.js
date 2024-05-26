// Задание 3
// Пользователь с клавиатуры вводит 3 числа, необходимо создать функцию, которая определяет максимальное значение среди этих чисел

function getMax(n1, n2, n3) {

    let array = [Number(n1), Number(n2), Number(n3)];
    array.sort((a, b) => a - b).reverse();
    return array[0];

}

let input1 = prompt('Please enter number1:');
let input2 = prompt('Please enter number2:');
let input3 = prompt('Please enter number3:');

console.log(getMax(input1, input2, input3));