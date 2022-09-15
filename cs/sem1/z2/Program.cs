namespace HelloWorld
{
    class Program
    {
        static void Main(string[] args)
        {
            // Тут писать
            Console.WriteLine("введите 1е число");
            int A = Convert.ToInt32(Console.ReadLine());
            Console.WriteLine("введите 2е число");
            int B = Convert.ToInt32(Console.ReadLine());
            Console.WriteLine("введите 3е число");
            int C = Convert.ToInt32(Console.ReadLine());

            int Max = A;
            if (Max < B) {
                Max = B;
            }
            if (Max < C) {
                Max = C;
            }   
            Console.WriteLine($"большее число {Max} ");
        }
        
    }
}
