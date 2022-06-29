namespace HelloWorld
{
    class Program
    {
        static void Main(string[] args)
        {
            // Тут писать
            /* Задача 15: Напишите программу, которая принимает на вход цифру, обозначающую день недели, и проверяет, является ли этот день выходным.
            6 -> да
            7 -> да
            1 -> нет*/
        Console.WriteLine("Число дня недели, где пнд - 1, а вскр - 7");
        int A = Convert.ToInt32(Console.ReadLine());

        // вдруг у кого больше 7 дней?
        if (A <= 7 && A >= 1)
        {
            //какой там день недели?
           if (A >=1 && A <=5)
           {
            Console.WriteLine($"{A}й день - рабочий");
           }
           else 
           {
            Console.WriteLine($"{A}й день - выходной!!!");
           }  
        }
        else 
        {
           Console.WriteLine("еще попытку");     
        }


            
        }
    }
}