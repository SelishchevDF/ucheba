namespace HelloWorld
{
    class Program
    {
        static void Main(string[] args)
        {
            // Тут писать
            Console.WriteLine("введите число");
            int A = Convert.ToInt32(Console.ReadLine());

            if ( A % 2 == 0){
                Console.WriteLine("Число четное");
            }
            else{ 
                Console.WriteLine("Число НЕ четное");
            }
        }
        
    }
}
