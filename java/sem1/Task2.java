import java.util.Random;

//Реализовать алгоритм пирамидальной сортировки (HeapSort)

public class Task2{
    public static void main(String[] args){
        String stringInvatation = "введите длину массива";
        String stringError = "введите длину правильно - целый и больше 0";
        
        int num = Task1InpitInt.inputNum(stringInvatation, stringError);

        int arr[] = new int[num];

        System.out.println("сгенерированный массив");
        rndArray(arr);
        printArray(arr);
        
        sort(arr);

        System.out.println("отсортированный массив");
        printArray(arr);

    }
    public static void sort(int arr[])
    {
        int n = arr.length;

        // Построение кучи (перегруппируем массив)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // Один за другим извлекаем элементы из кучи   
        for (int i=n-1; i>=0; i--)
        {
            // Перемещаем текущий корень в конец
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Вызываем процедуру heapify на уменьшенной куче
            heapify(arr, i, 0);
        }
    }

    // Процедура для преобразования в двоичную кучу поддерева с корневым узлом i, что является
// индексом в arr[]. n - размер кучи
    public static void heapify(int arr[], int n, int i)
    {
        int largest = i; // Инициализируем наибольший элемент как корень
        int l = 2*i + 1; // левый = 2*i + 1
        int r = 2*i + 2; // правый = 2*i + 2

           // Если левый дочерний элемент больше корня
        if (l < n && arr[l] > arr[largest])
            largest = l;

           // Если правый дочерний элемент больше, чем самый большой элемент на данный момент
        if (r < n && arr[r] > arr[largest])
            largest = r;
           // Если самый большой элемент не корень
        if (largest != i)
        {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

        // Рекурсивно преобразуем в двоичную кучу затронутое поддерево
            heapify(arr, n, largest);
        }
    }

    /* Вспомогательная функция для вывода на экран массива размера n */
    public static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    public static int[] rndArray(int arr[])
    {
        Random random = new Random();
        int n = arr.length;
        for (int i=0; i<n; ++i){
            arr[i] = random.nextInt(10);
        }
        return arr;
    }
}


