namespace HelloWorld
{
    class Program
    {
        static void Main(string[] args)
        {
            // Тут писать
            /*Задача 13: Напишите программу, которая выводит третью цифру заданного числа или сообщает, что третьей цифры нет.

            645 -> 5
            78 -> третьей цифры нет
            32679 -> 6 */
            Console.WriteLine("давай число");
            string A = Console.ReadLine();

            if (A.Length < 3)
            {
                Console.WriteLine("третьего символа нема(((");
            }
            else 
            {
                Console.WriteLine($"третья цифра числа {A} - {A[2]}");
            }
        }
    }
}