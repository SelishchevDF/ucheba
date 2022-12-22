package sem1;
public class ArraysSubstraction {
    public static int [] arraysSubstraction(int [] a1, int [] a2) {  
        int res [] = new int[a1.length];   
        if (a1.length == a2.length){           
            for (int i = 0; i < res.length; i++){
                res[i] = a1[i] - a2[i];
            } 
            return res;
        }
        else{
            System.out.println("Длины массивов не равны");
            return null;
        }   
    }
}
