namespace HelloWorld
{
    class Program
    {
        static void Main(string[] args)
        {
            // Тут писать 
            /*Задача 10: Напишите программу, которая принимает на вход трёхзначное число и на выходе показывает вторую цифру этого числа.
            456 -> 5
            782 -> 8
            918 -> 1*/
            Console.WriteLine("Введите число");
            string A = Console.ReadLine();

            Console.WriteLine($"второй символ числа {A} - {A[1]}");

            
        }
    }
}
