public class Main {

    public static void main(String[] args) {
        
        Calculator.divide(10, 2.5);
        Calculator.multiply(2.5, 10);
        Calculator.subtract(6.5, 3);
        Calculator.sum(2.5, 2.5);

        Object arr1[] = {123, "hello", "world"};
        Object arr2[] = {400, "123", "123"};
        Object arr3[] = {123, 123, 123};

        ArraysComparison.compareArrays(arr1, arr2);
        ArraysComparison.compareArrays(arr2, arr3);

        Pair pair = new Pair(123, "hello");
        pair.getFirst();
        pair.getSecond();
        System.out.println(pair);





    }
}