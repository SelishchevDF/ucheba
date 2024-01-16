public class Calculator {
    
    public static <T extends Number> void sum(T first, T second) {
        System.out.println(first.doubleValue() + second.doubleValue());
    }

    public static <T extends Number> void multiply(T first, T second) {
        System.out.println(first.doubleValue() * second.doubleValue());
    }

    public static <T extends Number> void divide(T first, T second) {
        try {
            System.out.println(first.doubleValue() / second.doubleValue());
        } 
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static <T extends Number> void subtract(T first, T second) {
        System.out.println(first.doubleValue() - second.doubleValue());
    }

}
