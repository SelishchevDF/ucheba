/*Задача 43: Напишите программу, которая найдёт точку пересечения двух прямых, заданных уравнениями 

y = k1 * x + b1, y = k2 * x + b2; значения b1, k1, b2 и k2 задаются пользователем.

b1 = 2, k1 = 5, b2 = 4, k2 = 9 -> (-0,5; -0,5)
*/
namespace GeekBrains
{
    static class Z2
    {
        public static void Z2Main()
        {
            Console.Clear();
            Console.WriteLine("Первая прямая");
            double[] A = MyLines.GetLine();
            Console.WriteLine($"получившаяся прямая y = {A[0]} * x + {A[1]}");
            Console.WriteLine("Вторая прямая");
            double[] B = MyLines.GetLine();
            Console.WriteLine($"получившаяся прямая y = {B[0]} * x + {B[1]}");
            MyLines.LineCross(A,B);
        }
    }
}