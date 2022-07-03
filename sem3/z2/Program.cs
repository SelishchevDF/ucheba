/*Напишите программу, которая принимает на вход координаты двух точек и находит расстояние между ними в 3D пространстве.

A (3,6,8); B (2,1,-7), -> 15.84

A (7,-5, 0); B (1,-1,9) -> 11.53*/

namespace HelloWorld
{
    class Program
    {
        static void Main(string[] args)
        {
            // Тут писать
        // метод заполнение точки
        static int[] tochka()
        {
            //магические тройки тк у точки 3 координаты
            int [] tochka = new int[3];
            for (int i=0; i < 3; i++)
            {
                tochka[i] = new Random().Next(-10,11);
            }
            return tochka;
        }
        //вывод координат
        int [] A = tochka();
        Console.WriteLine($"точка A координаты x={A[0]} y={A[1]} z={A[2]}");
        int [] B = tochka();
        Console.WriteLine($"точка B координаты x={B[0]} y={B[1]} z={B[2]}");
        // метод расчета отрезка
        static double dlina (int [] tochka1,int [] tochka2)
        {
            double dlinaot = Math.Sqrt(Math.Pow(tochka2[0]-tochka1[0],2) + Math.Pow(tochka2[1]-tochka1[1],2) + Math.Pow(tochka2[2]-tochka1[2],2));
            return dlinaot;
        }
        Console.WriteLine($"длина отрезка {dlina(A,B)}");      
        }
    }
}
