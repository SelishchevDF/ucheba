/*
Задача 56: Задайте прямоугольный двумерный массив. Напишите программу,
которая будет находить строку с наименьшей суммой элементов.
Например, задан массив:
1 4 7 2
5 9 2 3
8 4 2 4
5 2 6 7
Программа считает сумму элементов в каждой строке и выдаёт номер строки с наименьшей суммой элементов: 1 строка
*/
namespace GeekBrains
{
    class Task2
    {
        public static void Task2Main()
        {
            int rows = 5;
            int columns = 5;
            int minElement = 0;
            int maxElement = 9;

            int [,] taskArray = MyArrays.GetInt2dArray(rows, columns, minElement, maxElement);
            MyArrays.PrintArray(taskArray);
            SortList(SummRows(taskArray));

        }
        static List <int> SummRows(int[,] array)
        {
            List <int> results = new List<int>();
            for (int i = 0; i < array.GetLength(0); i++)
            {
                int summ = 0;
                for (int j = 0; j < array.GetLength(1); j++)
                {
                    summ = summ + array[i, j];
                }
                Console.Write($"сумма {i} - строки = {summ} ");
                results.Add(summ);
                Console.WriteLine();
            }
            return results;    
        } 
        static void SortList(List<int> list)
        {
            int indexMin = 0;
            for (int i = 1; i < list.Count; i++)
            {
                if (list[i] < list[indexMin]) indexMin = i;
            }
            Console.WriteLine($"строка с минимальным значением {indexMin} - я, ее значение - {list[indexMin]} ");
        }
    }
}