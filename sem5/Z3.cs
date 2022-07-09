/*Задайте массив вещественных чисел. Найдите разницу между максимальным и минимальным элементов массива.

[3 7 22 2 78] -> 76*/

namespace HomeWork
{
    class Z3
    {
        public void Z3Main()
        {
            // Обьявление длины массива и элементов

            int MinArrayLength = 5;
            int MaxArrayLength = 10; 
            int MinElement = -10;
            int MaxElement = 11;

            // Заполнение массива

            Arrays ArrayZ3 = new Arrays();            
            double [] ArrayZ = ArrayZ3.DoubleArray(MinArrayLength, MaxArrayLength, MinElement, MaxElement);

            // Печать получившегося массива

            Console.WriteLine("сгенерированный массива");
            ArrayZ3.PrintdoubleArray(ArrayZ);

            // Поиск максимального элемента
            double Max = ArrayZ[0];
            for (int i = 1; i <= ArrayZ.Length-1; i++)
            {
                if (Max < ArrayZ[i])
                    Max = ArrayZ[i];
            }
            Console.WriteLine("Max = " + Max);

            // Поиск минимального элемента
            double Min = ArrayZ[0];
            for (int i = 1; i <= ArrayZ.Length-1; i++)
            {
                if (Min > ArrayZ[i])
                    Min = ArrayZ[i];
            }
            Console.WriteLine("Max = " + Min);
            Console.WriteLine($"разница между максимальным и минимальным элементом = {Max - Min} " );
        }
    }
}