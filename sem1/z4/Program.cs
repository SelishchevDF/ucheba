namespace HelloWorld
{
    class Program
    {
        static void Main(string[] args)
        {
            // Тут писать
            Console.WriteLine("введите число");
            int A = Convert.ToInt32(Console.ReadLine());

            int index = 1;
            while ( index < A - 1){
                if ( index%2 == 0 ){
                    Console.Write($" {index}");
                }
                index++;
            }
        }
        
    }
}
