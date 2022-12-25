package sem2.task2;

public class Main {

    public static void main(String[] args) {
        
        int [] intArray = {6};

        try {
            int d = 0;
            double catchedRes1 = intArray[0] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        }   
    }
}