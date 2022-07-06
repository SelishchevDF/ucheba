/*
Задача 29: Напишите программу, которая задаёт случайный массив случайного размера (от 5 до 10) элементов (значение элементов от 1 до 40) и выводит на экран массив квадратов этих чисел.

1, 2, 5, 7, 19 -> [2, 4, 25, 49, 361]

6, 1, 33 -> [36, 1, 1089]
*/
namespace GeekBrains
{
    class Program
    {
        static void Main(string[] args)
        {
        // Тут писать главное
        //переменные из тз
        int MinArrayLength = 5;
        int MaxArrayLength = 10; // 10 потому что в рнд мы добавляем +1 ко второму аргументу, для удобства пользака
        int MinElement = 1;
        int MaxElement = 40; // 10 потому что в рнд мы добавляем +1 ко второму аргументу, для удобства пользака
        //обьявление массива
        int [] A = new int[rnd(MinArrayLength,MaxArrayLength)];
        //заполнение и вывод рандомного массива
        Console.WriteLine("Сгенерированный массив");
        for (int i = 0; i < A.Length; i++)
        {
            A[i] = rnd(MinElement,MaxElement);
            Console.Write($" {A[i]}");
        }
        Console.WriteLine();
        //заполнение и вывод массива из тз
        Console.WriteLine("ответ в задаче");
        int [] B = new int[A.Length];
        for (int i = 0; i< B.Length; i++)
        {
            B[i] = Convert.ToInt32(sqr(A[i]));
            Console.Write($" {B[i]}");
        }
        Console.WriteLine();          
        }
        // тут методы
        //рандомное число
        public static int rnd(int a, int b)
        {
        int val = new Random().Next(a,b+1); //b+1 чтоб включить последне число, [1,11), где пользак ввел от [1,10]
        return val;
        }
        //подсчет квадрата
        public static double sqr(int a)
        {
            double val = Math.Pow(a,2); //2 - квадрат потому что тз
            return val;
        }
    }
}
