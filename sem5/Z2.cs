/* Задайте одномерный массив, заполненный случайными числами. Найдите сумму элементов, стоящих на нечётных позициях.

[3, 7, 23, 12] -> 19

[-4, -6, 89, 6] -> 0
*/

namespace HomeWork
{
    class Z2
    {
        public void Z2Main()
        {
            // Обьявление длины массива и элементов

            int MinArrayLength = 5;
            int MaxArrayLength = 10; 
            int MinElement = -10;
            int MaxElement = 11;

            // Заполнение массива

            Arrays ArrayZ2 = new Arrays();            
            int [] ArrayZ = ArrayZ2.IntArray(MinArrayLength, MaxArrayLength, MinElement, MaxElement);

            // Печать получившегося массива

            Console.WriteLine("сгенерированный массива");
            ArrayZ2.PrintIntArray(ArrayZ);

            //Счет элементов на нечетных местах

            int count = 0;
            for(int i=1; i <= ArrayZ.Length-1; i++)
            {
                if (i % 2 != 0)
                    count = count +ArrayZ[i];
            }
            Console.WriteLine($"Сумма элементов на нечетных местах - {count}");

        }
    }
}