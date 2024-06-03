// Задание 3
// Используя Math.random() вам необходимо генерировать цифры от 0 до 9, и создать массив состоящий из 5 таких элементов
// 1. Рассчитать сумму элементов этого массива
// 2. Найти минимальное число
// 3. Найти есть ли в этом массиве число 3



const MAX = 9;
const ARRAYLENGTH = 5;
const FINDNUM = 3;

let array = [];
let findFlag = false;
let sum = 0;
let min;

for (let i = 0; i < ARRAYLENGTH; i++){
    let tmp = Math.round(Math.random() * MAX);
    sum = sum + tmp;
    if (tmp == 3) {
        findFlag = true;
    }
    array.push(tmp)
}

array.sort((a, b) => a - b);
min = array[0];

alert(array);
console.log(sum + " " + findFlag + " " + min);