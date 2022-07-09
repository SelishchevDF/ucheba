namespace HomeWork
{
    class Program
    {
        static void Main()
        {
            
            // Вод выбора

            Console.WriteLine("Выбери задачу от 1 до 3");
            string A = Console.ReadLine();

            // Проверка выбора
            
            # region Выбор и проверка

            bool result = int.TryParse(A,out int num);
            bool result123 = num == 1 | num == 2 | num == 3;
            bool obchsh = result & result123 ; 
            
            while ( obchsh == false ) 
            {
                Console.WriteLine("Число вводи от 1 до 3");
                A = Console.ReadLine();
                result = int.TryParse(A,out num);
                result123 = num == 1 | num == 2 | num == 3;
                obchsh = result & result123;      
            }

            # endregion 

            // Ветвление выбора и вывод результата

            Console.WriteLine($"ты выбрал {A}-ю задачу");
            if (num == 1)
            {
                Console.WriteLine();
                Z1 zad1 = new Z1();
                zad1.Z1Main();
            }
            if (num == 2)
            {
                Console.WriteLine();
                Z2 zad2 = new Z2();
                zad2.Z2Main();
            }
            if (num == 3) 
            {
                Console.WriteLine();
                Z3 zad3 = new Z3();
                zad3.Z3Main();
            }
        }       
    }
}
