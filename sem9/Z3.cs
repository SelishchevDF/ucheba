/*Задача 68: Напишите программу вычисления функции Аккермана с помощью рекурсии. Даны два неотрицательных числа m и n.
m = 2, n = 3 -> A(m,n) = 29
*/

/*
  A  | n=0     1     2     3     4     5     6     7     8     9    10
-----+-----------------------------------------------------------------
 m=0 |   1     2     3     4     5     6     7     8     9    10    11
   1 |   2     3     4     5     6     7     8     9    10    11    12
   2 |   3     5     7     9    11    13    15    17    19    21    23
   3 |   5    13    29    61   125   253   509  1021  2045  4093  8189
   4 |  13 65533   big   really big...
*/

namespace GeekBrains
{
    class Z3
    {
        public static void Z3Main()
        {
            GetResult();
        }
        private static int GetVal()
        {
            int num = 0;
            bool result = false;
            do
            {
                Console.WriteLine("не отрицательное Число вводи");
                string? str = Console.ReadLine();
                result = int.TryParse(str, out num) && num > 0;
            }
            while (result == false);
            return num;
        }
        private static void GetResult()
        {
            int m = GetVal();
            int n = GetVal();

            Console.WriteLine("\nрезультат "+Recu(m,n));
        }
        private static int Recu(int m, int n)
        {
            if (m == 0)
            {
                return n + 1;
            }
            else
            {
                if ((m != 0) && (n == 0))
                {
                    return Recu(m - 1, 1);
                }
                else
                {
                    return Recu(m - 1, Recu(m, n - 1));
                }
            }
        }
    }
}