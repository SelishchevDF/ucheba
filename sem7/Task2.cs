/*Задача 50. Напишите программу, которая на вход принимает позиции элемента в двумерном массиве, и возвращает значение этого элемента или же указание, что такого элемента нет.

Например, задан массив:

1 4 7 2

5 9 2 3

8 4 2 4

17 -> такого числа в массиве нет
*/

namespace GeekBrains
{
    public class Task2
    {
        public static void Task2Main()
        {
            Console.Write("Строка (нумерация с 1) - ");
            int row = Values.GetValForIJ() - 1;
            Console.WriteLine();
            Console.Write("Столбец (нумерация с 1) - ");
            int column = Values.GetValForIJ() - 1;
            Checking(MyArrays.SetupArrayAndPrint(), row, column);          
        }

        // тут методы

        static void Checking(double[,] array, int row, int column)
        {
            int i = array.GetLength(0);
            int j = array.GetLength(1);
            if (row < i && column < j)
            {                
                Console.WriteLine("Элемент входит в массив и равен - " + array[row, column]);
            }
            else
            {
                Console.WriteLine("Элемент не входит");
            } 
        }
    }
}