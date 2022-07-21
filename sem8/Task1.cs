/*
Задача 54: Задайте двумерный массив. Напишите программу,
которая упорядочит по возрастанию элементы каждой строки двумерного массива.
Например, задан массив:
1 4 7 2
5 9 2 3
8 4 2 4
В итоге получается вот такой массив:
1 2 4 7
2 3 5 9
2 4 4 8
*/
namespace GeekBrains
{
    class Task1
    {
        public static void Task1Main()
        {
            int rows = 5;
            int columns = 5;
            int minElement = 0;
            int maxElement = 9;

            //MyArrays.PrintArray(Sorting(MyArrays.GetInt2dArray(rows, columns, minElement, maxElement)));
            
            int[,] taskArray = MyArrays.GetInt2dArray(rows, columns, minElement, maxElement);
            MyArrays.PrintArray(taskArray);
            int[,] sortArray = Sorting(taskArray);
            Console.WriteLine();
            MyArrays.PrintArray(sortArray);    
        }
        
        static int [,] Sorting(int [,] array)
        {
            for (int i = 0; i < array.GetLength(0); i++ )
            {
                for (int jmin = 0; jmin < array.GetLength(1); jmin++)
                {
                    for (int j = jmin; j < array.GetLength(1); j++)
                    {   
                        if ( array[i,jmin] > array[i,j])
                        {
                            int temp = array[i,j];
                            array[i,j] = array[i,jmin];
                            array[i,jmin] = temp;
                        }
                    }
                }
            }    
        return array;
        }
    }
}