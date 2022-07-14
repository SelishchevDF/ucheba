
namespace GeekBrains
{
    class ProgramSem6
    {
        static void Main()
        {
            ConsoleKeyInfo select;
            Console.WriteLine("1 - первая задача, 2 - вторая задача");
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
            if (select.Key != ConsoleKey.D1 && select.Key != ConsoleKey.D2)
            {
                Console.WriteLine("еще разок");
            }                       
        }        
    }
}