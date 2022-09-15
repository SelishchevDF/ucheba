/*Задача 52. Задайте двумерный массив из целых чисел. Найдите среднее арифметическое элементов в каждом столбце.

Например, задан массив:
1 4 7 2
5 9 2 3
8 4 2 4
Среднее арифметическое каждого столбца: 4,6; 5,6; 3,6; 3.
*/
namespace GeekBrains
{
    public class Task3
    {
        public static void Task3Main()
        {               
            ArithmeticMeanInColumsWithPrint(MyArrays.SetupArrayAndPrint());
        }

        // тут методы
        static void ArithmeticMeanInColumsWithPrint(double[,] array)
        {
            List<double> arithmeticMeanInColums = new List<double>();
            for (int j = 0; j < array.GetLength(1) ; j++)
            {
                arithmeticMeanInColums.Add(0);
                int count = 0;
                for (int i = 0; i < array.GetLength(0); i++)
                {
                    arithmeticMeanInColums[j] = arithmeticMeanInColums[j] + array[i,j];
                    count++;
                }
                arithmeticMeanInColums[j] = arithmeticMeanInColums[j] / count;
            }
            Console.WriteLine("Че вышло");
            foreach (double val in arithmeticMeanInColums)
            {
                Console.Write(Math.Round(val,2)+" ");
            }
        }                
    }
}