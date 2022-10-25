import java.util.Random;

//Реализовать алгоритм сортировки вставками

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

    public static void sort(int[] sortArr) {
        int j;
        //сортировку начинаем со второго элемента, т.к. считается, что первый элемент уже отсортирован
        for (int i = 1; i < sortArr.length; i++) {
            //сохраняем ссылку на индекс предыдущего элемента
            int swap = sortArr[i];
            for (j = i; j > 0 && swap < sortArr[j - 1]; j--) {
                //элементы отсортированного сегмента перемещаем вперёд, если они больше элемента для вставки
                sortArr[j] = sortArr[j - 1];
            }
            sortArr[j] = swap;
        }
    }

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


