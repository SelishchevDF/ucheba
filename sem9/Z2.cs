/*Задача 66: Задайте значения M и N. Напишите программу, которая найдёт сумму натуральных элементов в промежутке от M до N.
M = 1; N = 15 -> 120
M = 4; N = 8. -> 30
*/


namespace GeekBrains
{
    class Z2
    {
        public static void Z2Main()
        {  
           GetSumm(); 
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
        private static void GetSumm()
        {
            int m = GetVal();
            int n = GetVal();
            
            Console.WriteLine("\nрезультат "+Recu(m,n));  
        }
        private static int Recu(int m,int n, int result = 0)
        {
            if (m == n+1) return result;  
            return result = m + Recu(m+1,n);
        }
    }
}