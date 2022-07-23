/*Задача 64: Задайте значения M и N. Напишите программу, которая выведет все натуральные числа в промежутке от M до N.
M = 1; N = 5. -> ""1, 2, 3, 4, 5""
M = 4; N = 8. -> ""4, 6, 7, 8""
*/

namespace GeekBrains
{
    class Z1
    {
        public static void Z1Main()
        {
            GetNambers(); 
        }
        private static int GetVal()
        {
            int num = 0;
            bool result = false;
            do
            {
                Console.WriteLine("Число вводи");
                string? str = Console.ReadLine();
                result = int.TryParse(str,out num);   
            }
            while(result == false);
            return num;
        }
        private static void GetNambers()
        {
            int m = GetVal();
            int n = GetVal();
            
            Recu(m,n);  
        }
        private static void Recu(int m,int n)
        {
            Console.WriteLine(" "+m);
            if (m == n) return;  
            Recu(m+1,n);  
        }
    }
}