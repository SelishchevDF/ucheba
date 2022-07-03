/*Напишите программу, которая принимает на вход число (N) и выдаёт таблицу кубов чисел от 1 до N.

3 -> 1, 8, 27
5 -> 1, 8, 27, 64, 125*/


namespace HelloWorld
{
    class Program
    {
        static void Main(string[] args)
        {
            // Тут писать
            Console.WriteLine("дайте N");
            int N = Convert.ToInt32(Console.ReadLine());
            // считаем кубы
            static void Kub(int a)
            {
                for (int i = 1; i <=a; i++)
                {
                    double kubik = Math.Pow(i,3);
                    Console.WriteLine($"куб {i} = " + kubik);
                }
            }
            Kub(N);
        }
    }
}
