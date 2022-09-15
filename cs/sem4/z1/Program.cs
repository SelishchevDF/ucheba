/*
Задача 25: Напишите цикл, который принимает на вход два числа (A и B) и возводит число A в натуральную степень B.

3, 5 -> 243 (3⁵)

2, 4 -> 16

*/
namespace GeekBrains
{
    class Program
    {
        static void Main(string[] args)
        {
            //Тут писать главное
        stepen();    
        }
        //тут методы
        public static void stepen ()
        {
        Console.WriteLine("Какое число будем возводить?");    
        int A = Convert.ToInt32(Console.ReadLine());
        Console.WriteLine("В какую степень будем возводить?");    
        int B = Convert.ToInt32(Console.ReadLine());
        int result = A;
        if (B > 0)
        {
            for (int i = 1; i < B; i++)
            {
               result = result*A;
            }
            Console.WriteLine($"{A} в степени {B} = {result}");
        }
        else 
            Console.WriteLine($"{B} не натуральное число");
        
        
        }
    }
}
