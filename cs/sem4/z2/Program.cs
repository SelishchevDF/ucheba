/*
Задача 27: Напишите программу, которая принимает на вход число и выдаёт сумму цифр в числе.

452 -> 11

82 -> 10

9012 -> 12
*/
namespace GeekBrains
{
    class Program
    {
        static void Main(string[] args)
        {
            // Тут писать главное
        summ();
            
        }
        // тут методы
        public static void summ()
        {
        //ввод числа
        Console.WriteLine("Введите число");
        string str = Console.ReadLine();
        //обьявление массива для хранения и преобразования числа
        char [] a = str.ToCharArray(); 
        //переменная для подсчета суммы
        int summa = 0;
        //если число отрицетельное, вместо минуса ткнется 0
        if (a[0] == '-')
            a[0] = '0';
        //проверка на число и нахождеение суммы чисел массива
        for (int i = 0; i <str.Length; i ++)
        {
            if (a[i] == '1' | a[i] == '2' | a[i] == '3' | a[i] == '4' | a[i] == '5' | a[i] == '6' | a[i] == '7' | a[i] == '8' | a[i] == '9' | a[i] == '0')
            {

                summa = summa + Convert.ToInt32(a[i].ToString());
            }
            else
            {
                Console.WriteLine("это число с буквами");
                return;
            }
        }
        Console.WriteLine($"сумма чисел в числе {str} = {summa}");
        }
    }
}
