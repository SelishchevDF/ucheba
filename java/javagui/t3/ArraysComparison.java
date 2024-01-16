
public class ArraysComparison {
    
    public static <T> void compareArrays(T[] first, T[] second) {
        Integer count = 0;
        if (first.length == second.length){
            for (int i = 0; i < first.length; i++){
                if (first[i].getClass().getName().equals(second[i].getClass().getName())){
                    count++;
                }
            }
            if (count == first.length){
                System.out.println("Равны");
            }
            else {
                System.out.println("НЕ равны");
            }
        }
        else {
            System.out.println("НЕ равны");
        }
    }
}
