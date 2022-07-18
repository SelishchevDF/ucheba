/*Задача 47. Задайте двумерный массив размером m×n, заполненный случайными вещественными числами.

m = 3, n = 4.

0,5 7 -2 -0,2

1 -3,3 8 -9,9

8 7,8 -7,1 9
*/

namespace GeekBrains
{
    public class Task1
    {
        public static void Task1Main()
        {
            int rows = 3;
            int columns = 4;
            int minElement = -30;
            int maxElement = 30;

            double[,] array = MyArrays.GetArrayDuoble(rows, columns, minElement, maxElement);
            MyArrays.PrintArray(array);           
        }        
    }
}
