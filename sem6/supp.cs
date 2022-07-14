namespace GeekBrains
{
    static class MyArrays
    {
        public static int[] GetArray()
        {
            int [] A = new int[1];
            string? Elem = "";
            int i = 0;

            while (Elem != "q")
            {
                try
                {
                    while (i < A.Length)
                    {
                        Console.WriteLine("Вводи число, q - выход");
                        Elem = Console.ReadLine();
                        if (Elem == "q")
                        {
                            break;
                        }
                        A[i] = Convert.ToInt32(Elem);
                        Array.Resize(ref A, A.Length+1);
                        i++;                      
                    }
                    Array.Resize(ref A, A.Length-1);
                }
                catch (Exception)
                {
                    Console.WriteLine("Вводи число, не мухлюй");
                } 
            }   
        return A;
        }

        public static void PrintArray(int[] array)
        {
            for (int i = 0; i < array.Length; i++)
                Console.Write(array[i] + " ");
                Console.WriteLine();
        }
    }
}

    class MyLines
    {
        public static double[] GetLine()
        {
            double [] A = new double[2];
            try
            {
                
                Console.WriteLine("y = k * x + b");
                Console.WriteLine("Введите k");
                A[0] = Convert.ToDouble(Console.ReadLine());
                Console.WriteLine("Введите b");
                A[1] = Convert.ToDouble(Console.ReadLine());
            }
            catch (Exception)
            {
                Console.WriteLine("так сложно ввести число? будем пробовать пока не получится"); 
                GetLine();
            }
            return A;
        }
        public static void LineCross(double[] A, double[] B)
        {   
            if (A[0] == B[0] && A[1] == B[1])
                    Console.WriteLine("прямые совпадают");
            else
            {
                if (A[0] == B[0])
                    Console.WriteLine("прямые параллельны");
                else 
                {
                double[] C = new double[2];
                C[0] = (A[1] - B[1]) / (B[0] - A[0]); 
                C[1] = (B[0] * A[1] - A[0] * B[1]) / (B[0] - A[0]);
                Console.WriteLine($"Точка пересечения прямых х={C[0]} ,у={C[1]}");
                }
            }    
        }

    }




