package sem1;
public class ArraysDiv {
        public static float [] arraysDiv(int [] a1, int [] a2) {  
            float res [] = new float[a1.length];   
            if (a1.length == a2.length){           
                for (float f : a2) {
                    if(f==0){
                        System.out.println("на 0 делить нельзя");
                        return null;
                    }
                }
                for (int i = 0; i < res.length; i++){
                    res[i] = a1[i]/a2[i];
                }
                return res;
            }
            else{
                System.out.println("Длины массивов не равны");
                return null;
            }   
        }
}
