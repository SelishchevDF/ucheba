// Задание 1
// Необходимо с помощью цикла for вывести следующие 11 строк в консоль:
// 0 – это ноль
// 1 – нечетное число
// 2 – четное число
// 3 – нечетное число
// …
// 10 – четное число

const NUM = 11;

for (let i = 0; i < NUM; i++) {
    if (i == 0) {
        console.log(i + " это ноль");
    } else {
        ((i % 2) == 0) ? console.log( i + " четное число"):console.log(i + " нечетное число");
    }
}