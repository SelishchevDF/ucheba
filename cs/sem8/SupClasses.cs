namespace GeekBrains
{
    /// <summary>
    /// Работа с массивами
    /// </summary>
    class MyArrays
    {
        ///<summary>
        /// Случайное заполнение двумерного int массива 
        ///</summary>
        ///<param name="m">
        ///колчиство строк
        ///</param>
        ///<param name="n">
        ///колчиство столбцов
        ///</param>
        ///<param name="minElement">
        ///величина минимального элемента
        ///</param>
        ///<param name="maxElement">
        ///величина максимального элемента, включительно
        ///</param>
        public static int [,] GetInt2dArray(int m, int n, int minElement,int maxElement)
        {
            int [,] array = new int [m,n];
            for (int i = 0; i < m; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    array[i, j] = new Random().Next(minElement, maxElement+1);
                }
            } 
        return array;
        }

        ///<summary>
        /// Вывод в консоль двумерного массива 
        ///</summary>
        ///<param name="array">
        ///Выводимый массив
        ///</param>
        public static void PrintArray(int[,] array) 
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
    }
}