// Задание 3
// В переменной day лежит какое-то число из интервала от 1 до 31. Определите в какую декаду месяца попадает это число (в первую, вторую или третью).

let DAYINMYMONTH = 30;
let day = Math.round(Math.random() * DAYINMYMONTH + 1);
console.log(day);
if(day <= 10) console.log('Это первая декада');
    else if(day <= 20) console.log('Это вторая декада');
        else if(day <  32) console.log('Это третья декада');
