/*
Дополнительная задача
Задача 60. Сформируйте трёхмерный массив из неповторяющихся двузначных чисел. 
Напишите программу, которая будет построчно выводить массив, добавляя индексы каждого элемента.
массив размером 2 x 2 x 2
12(0,0,0) 22(0,0,1)
45(1,0,0) 53(1,0,1)
*/
namespace GeekBrains
{
    class Task4
    {
        public static void Task4Main()
        {
            int rows = 2;
            int columns = 2;
            int depth = 2;
            int minElement = 0;
            int maxElement = 9;

            GetArray(rows, columns, depth, minElement, maxElement);
            Console.WriteLine(); 
        }
        
        static void GetArray(int rows, int columns, int depth, int minElement, int maxElement)
        {
            int [,,] array = new int [rows,columns,depth]; 
            List<int> elemList = new List<int>();
            bool chek = false;
            int temp = 0;
            for (int i = 0; i < array.GetLength(0); i++)
            {     
                Console.WriteLine();          
                for (int j = 0; j < array.GetLength(1); j++)
                {                 
                    for (int k = 0; k < array.GetLength(2); k++)
                    {
                        chek = false;
                        while (chek == false)
                        {                          
                            chek = true;
                            temp = new Random().Next(minElement,maxElement);
                            for (int m = 0; m < elemList.Count; m++) 
                            {
                                if (elemList[m] == temp) chek = false;
                            }
                        } 
                        elemList.Add(temp);
                        array[i,j,k] = temp;
                        Console.Write($"{array[i,j,k]}({i},{j},{k}) ");
                    }
                }
            }
        }
    }
}