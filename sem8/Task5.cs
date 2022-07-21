/*
Дополнительная задача
Задача 62. Заполните спирально массив 4 на 4.
Например, на выходе получается вот такой массив:
1 2 3 4
12 13 14 5
11 16 15 6
10 9 8 7
*/
namespace GeekBrains
{
    class Task5
    {
        public static void Task5Main()
        {
            int rows = 4;
            int columns = 4;
            int startNum = 1;

            MyArrays.PrintArray(GetArray(rows, columns, startNum));
        }
        static int[,] GetArray(int rows, int columns, int startNum)
        {
            int[,] array = new int[rows, columns];

            int m = 0;
            int n = 0;
            int i = 0;
            int j = 0;

            //для второго и прочих кругов проходов
            int count = 0;

            while (startNum < rows * columns)
            {
                //заполняем столбцы направо, переходим на строку ниже
                for (j = n; j < array.GetUpperBound(1) + 1 - count; j++)
                {
                    array[m, j] = startNum;
                    startNum++;
                    n++;
                }
                m = m + 1;
                n = n - 1;

                //заполняем вниз, переходим на столбец влево
                for (i = m; i < array.GetUpperBound(0) + 1 - count; i++)
                {
                    array[i, n] = startNum;
                    startNum++;
                    m++;
                }
                n = n - 1;
                m = m - 1;

                // заполняем налево, переходим на строку выше
                for (j = n; j >= array.GetLowerBound(1) + count; j--)
                {
                    array[m, j] = startNum;
                    startNum++;
                    n--;
                }
                n = n + 1;
                m = m - 1;

                //заполняем вверх до строки с 1 индексом, переходим на стобец правее
                for (i = m; i > array.GetLowerBound(0) + count; i--)
                {
                    array[i, n] = startNum;
                    startNum++;
                    m--;
                }
                n = n + 1;
                m = m + 1;
                //плюсуем повторятор для сужения заполнения
                count++;
            }
            return array;
        }
    }
}