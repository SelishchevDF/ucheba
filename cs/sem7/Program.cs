
namespace GeekBrains
{
    class ProgramSem7
    {
        static void Main()
        {
            ConsoleKeyInfo select;
            Console.WriteLine("1 - первая задача, 2 - вторая задача, 3 - задача");
            select = Console.ReadKey();
            Console.WriteLine();
                
            if (select.Key == ConsoleKey.D1)
            {
                Console.Clear();
                Console.WriteLine("Первая задача");
                Task1.Task1Main();
            }
            if (select.Key == ConsoleKey.D2)
            {
                Console.Clear();
                Console.WriteLine("Вторая задача");
                Task2.Task2Main();
            }
            if (select.Key == ConsoleKey.D3)
            {
                Console.Clear();
                Console.WriteLine("Третья задача");
                Task3.Task3Main();
            }
            if (select.Key != ConsoleKey.D1
                    && select.Key != ConsoleKey.D2
                    && select.Key != ConsoleKey.D3)
            {
                Console.WriteLine("еще разок");
            }                       
        }        
    }
}
