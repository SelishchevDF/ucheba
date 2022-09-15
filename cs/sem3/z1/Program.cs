//Напишите программу, которая принимает на вход пятизначное число и проверяет, является ли оно палиндромом.
//14212 -> нет
//12821 -> да
//23432 -> да

namespace HelloWorld
{
    class Program
    {
        static void Main(string[] args)
        {
            // Тут писать
            Console.WriteLine("введи число");
            string str = Console.ReadLine();

            // проверка на пятизначность, если нужна
            /*if (str.Length == 5) 
            {*/
                //метод счета пар для дальнейшей проверки на палиндромность
                static int shchetpar (string strmetod)
                {
                int count = 0;
                for ( int i = 0; i < strmetod.Length; i++ )
                {
                    if (strmetod[i] == strmetod[(strmetod.Length-1)-i])
                    {
                        count++;
                    }
                }
                return count;
                }                 
                if (str.Length == shchetpar(str))
                {
                    Console.WriteLine("У вас палиндромность");
                }
                else 
                {
                    Console.WriteLine("У вас не палиндром");
                }
                            
            //вторя часть проверки на 5тизначность
            /*else
            //{
                //Console.WriteLine("попробуй еще раз ввести пятизначное число");
            }*/
        }   
    }
}