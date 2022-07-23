namespace GeekBrains
{
    class Program
    {
        static void Main(string[] args)
        {
            ConsoleKeyInfo select;
            Console.WriteLine("1 - первая задача, 2 - вторая задача, 3 - задача задача");
            select = Console.ReadKey();
            Console.WriteLine();
                
            if (select.Key == ConsoleKey.D1)
            {
                Console.Clear();
                Console.WriteLine("Первая задача");
                Z1.Z1Main();
            }

            if (select.Key == ConsoleKey.D2)
            {
                Console.Clear();
                Console.WriteLine("Вторая задача");
                Z2.Z2Main();
            }
    
            if (select.Key == ConsoleKey.D3)
            {
                Console.Clear();
                Console.WriteLine("Третья задача");
                Z3.Z3Main();
            }

            if (select.Key != ConsoleKey.D1
                    && select.Key != ConsoleKey.D2
                    && select.Key != ConsoleKey.D3
                )
            {
                Console.WriteLine("еще разок");
            }                 
            
        }
        // тут методы
    }
}
