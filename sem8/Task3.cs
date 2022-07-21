/*
Задача 58: Задайте две матрицы. Напишите программу, 
которая выведет матрицу произведения элементов двух предыдущих матриц.
Например, заданы 2 массива:
1 4 7 2
5 9 2 3
8 4 2 4
5 2 6 7
и
1 5 8 5
4 9 4 2
7 2 2 6
2 3 4 7
Их произведение будет равно следующему массиву:
1 20 56 10
20 81 8 6
56 8 4 24
10 6 24 49
*/
namespace GeekBrains
{
    class Task3
    {
        public static void Task3Main()
        {
            int rows = 3;
            int columns = 3;
            int minElement = 0;
            int maxElement = 3;

            int [,] taskArray1 = MyArrays.GetInt2dArray(rows, columns, minElement, maxElement);
            MyArrays.PrintArray(taskArray1);
            Console.WriteLine();
            int [,] taskArray2 = MyArrays.GetInt2dArray(rows, columns, minElement, maxElement);
            MyArrays.PrintArray(taskArray2);
            Console.WriteLine();
            MyArrays.PrintArray(MultiplicationElementsArrays(taskArray1, taskArray2));
        }
        static int[,] MultiplicationElementsArrays(int[,] array1, int[,] array2)
        {
            int [,] multArrey = new int[array1.GetLength(0), array1.GetLength(1)];
            for (int i = 0; i < multArrey.GetLength(0); i++)
            {
                for (int j = 0; j < multArrey.GetLength(1); j++)
                {
                    multArrey[i, j] = array1[i, j] * array2[i, j];
                }
            }
            return multArrey;
        }
    }
}