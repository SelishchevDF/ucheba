namespace HomeWork
{
    class Arrays
    {
        // Массив целых чисел длинной от [a до b), заполняется элементами от [c до d)

        public int [] IntArray(int a, int b, int c, int d) 
        {
            int[] array = new int[new Random().Next(a,b)];
            for (int i = 0; i < array.Length; i++)
            {
                array[i] = new Random().Next(c,d);
            }
            return array; 
        }

        // Массив вещественных чисел чисел длинной от [a до b), заполняется элементами от [c до d)
        public double [] DoubleArray(int a, int b, int c, int d) 
        {
            double[] array = new double[new Random().Next(a,b)];
            for (int i = 0; i < array.Length; i++)
            {
                array[i] = new Random().Next(c,d);
            }
            return array; 
        }

        // Печать INT массива в консоль
        public void PrintIntArray(int [] array)
        {
            for (int i = 0; i < array.Length; i++)
            {
                Console.Write($"{array[i]} ");
            }
            Console.WriteLine();
        }
        
        // Печать Double массива в консоль
        public void PrintdoubleArray(double [] array)
        {
            for (int i = 0; i < array.Length; i++)
            {
                Console.Write($"{array[i]} ");
            }
            Console.WriteLine();
        }  
    }
}