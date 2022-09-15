namespace HelloWorld
{
    class Program
    {
        static void Main(string[] args)
        {
            // Тут писать
            Console.WriteLine("введите трехзначное число или любое число");
            string str = Console.ReadLine();
            char [] B = str.ToCharArray();
            Console.WriteLine(B[B.Length-1]);
            
            
        }
        
    }
}
