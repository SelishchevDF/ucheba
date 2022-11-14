import java.util.Random;

//Реализовать алгоритм Быстрой сортировки

public class Task1{
    public static void main(String[] args){
        String stringInvatation = "введите длину массива";
        String stringError = "введите длину правильно - целый и больше 0";
        
        int num = Task1InpitInt.inputNum(stringInvatation, stringError);

        int arr[] = new int[num];

        System.out.println("сгенерированный массив");
        rndArray(arr);
        printArray(arr);
        
        quickSort(arr, 0, arr.length - 1);

        System.out.println("отсортированный массив");
        printArray(arr);

    }
    
    public static void quickSort(int[] source, int leftBorder, int rightBorder) {
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        int pivot = source[(leftMarker + rightMarker) / 2];
        do {
            // Двигаем левый маркер слева направо пока элемент меньше, чем pivot
            while (source[leftMarker] < pivot) {
                leftMarker++;
            }
            // Двигаем правый маркер, пока элемент больше, чем pivot
            while (source[rightMarker] > pivot) {
                rightMarker--;
            }
            // Проверим, не нужно обменять местами элементы, на которые указывают маркеры
            if (leftMarker <= rightMarker) {
                // Левый маркер будет меньше правого только если мы должны выполнить swap
                if (leftMarker < rightMarker) {
                    int tmp = source[leftMarker];
                    source[leftMarker] = source[rightMarker];
                    source[rightMarker] = tmp;
                }
                // Сдвигаем маркеры, чтобы получить новые границы
                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);

        // Выполняем рекурсивно для частей
        if (leftMarker < rightBorder) {
            quickSort(source, leftMarker, rightBorder);
        }
        if (leftBorder < rightMarker) {
            quickSort(source, leftBorder, rightMarker);
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


