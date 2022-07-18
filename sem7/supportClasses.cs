namespace GeekBrains
{
    class MyArrays
    {
        public static double[,] GetArray(int m, int n, int minElement,int maxElement)
        {
            double[,] array = new double[m,n];
            for (int i = 0; i < m; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    array[i, j] = new Random().Next(minElement, maxElement+1);
                }
            } 
        return array;
        }
        public static double[,] GetArrayDuoble(int m, int n, int minElement,int maxElement)
        {
            double[,] array = new double[m,n];
            for (int i = 0; i < m; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    array[i, j] = new Random().Next(minElement, maxElement+1);
                    array[i, j] = Math.Round((array[i, j] / 3),2);
                }
            } 
        return array;          
        }   
        public static void PrintArray(double[,] array) 
        {
            for (int i = 0; i < array.GetLength(0); i++)
            {
                for (int j = 0; j < array.GetLength(1); j++)
                {
                    Console.Write(array[i,j]+" ");

                }
            Console.WriteLine();
            }
        }
        public static double[,] SetupArrayAndPrint()
        {
            Console.WriteLine("создай свой массив");
            Console.WriteLine("колчество строк, не меньше 1");
            int rows = Values.GetValForIJ();
            Console.WriteLine("колчество столбцов, не меньше 1");
            int columns = Values.GetValForIJ();
            Console.WriteLine("минимальное значение элемента");
            int minElement = Values.GetVal();
            Console.WriteLine("Максимальное значение элемента");
            int maxElement = Values.GetVal();           
            double[,] setupedArray = MyArrays.GetArray(rows, columns, minElement, maxElement);
            Console.WriteLine("массив");
            MyArrays.PrintArray(setupedArray);
            Console.WriteLine();
            return setupedArray;

        }  
    }
    class Values
    {
        public static int GetValForIJ()
        {
            string? str = Console.ReadLine();
            bool result = int.TryParse(str,out int num) && num > 0;
            while (result == false) 
            {
                Console.WriteLine("Число вводи положительное");
                str = Console.ReadLine();
                result = int.TryParse(str,out num) && num > 0;   
            }
            return num;
        }
        public static int GetVal()
        {
            string? str = Console.ReadLine();
            bool result = int.TryParse(str,out int num);
            while (result == false) 
            {
                Console.WriteLine("Число вводи");
                str = Console.ReadLine();
                result = int.TryParse(str,out num);   
            }
            return num;

        }
    }
}