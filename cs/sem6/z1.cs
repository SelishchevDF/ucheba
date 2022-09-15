/*Задача 41: Пользователь вводит с клавиатуры M чисел. Посчитайте, сколько чисел больше 0 ввёл пользователь.

0, 7, 8, -2, -2 -> 2

1, -7, 567, 89, 223-> 3
*/
namespace GeekBrains
{
    static class Z1
    {
        public static void Z1Main()
        {
            int [] A = MyArrays.GetArray();
            Console.Clear();
            Console.WriteLine("Введенный массив");
            MyArrays.PrintArray(A);
            SkolkoChisel(A);
        }
        static void SkolkoChisel(int[] array)
        {
            int count = 0;
            Console.WriteLine("Положительные числа");
            for (int i = 0; i < array.Length; i++)
            {
                if (array[i] > 0)
                {
                    Console.Write($"{array[i]} ");
                    count = count + 1;
                }                           
            }
            Console.WriteLine();
            Console.WriteLine($"Число положительных чисел -{count}");
        }
    }
}