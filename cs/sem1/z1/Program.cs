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

            if (A == B) {
                Console.WriteLine("Числа равны");
            }
            if (A > B) {
                Console.WriteLine($"большее число {A} ");
            }   
            if (A < B) {
                Console.WriteLine($"большее число {B} ");
            } 
        }
    }
}
