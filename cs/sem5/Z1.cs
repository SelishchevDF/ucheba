/*Задача 34: Задайте массив заполненный случайными положительными трёхзначными числами. Напишите программу, которая покажет количество чётных чисел в массиве.

[345, 897, 568, 234] -> 2*/

namespace HomeWork
{
    class Z1
    {
        public void Z1Main()
        {
            // Обьявление длины массива и элементов

            int MinArrayLength = 5;
            int MaxArrayLength = 10; 
            int MinElement = 100;
            int MaxElement = 1000;

            // Заполнение массива
            Arrays ArrayZ1 = new Arrays();
            int [] ArrayZ = ArrayZ1.IntArray(MinArrayLength, MaxArrayLength, MinElement, MaxElement);
            
            // Печать получившегося массива

            Console.WriteLine("сгенерированный массива");
            ArrayZ1.PrintIntArray(ArrayZ);

            // Счет четных элементов

            int count = 0;
            for(int i = 0; i < ArrayZ.Length; i++)
            {
                if (ArrayZ[i] %2 == 0)
                    count++;
            }
            Console.WriteLine($"Четных элементов - {count}");
        } 
    }
}