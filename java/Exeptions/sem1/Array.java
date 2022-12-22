package sem1;

import java.util.Random;

public class Array {
    private int arr [];

    public Array(int maxSize) {
        try{
            int a [] = new int[new Random().nextInt(maxSize)];
            for (int i = 0; i < a.length; i++){
            a[i] = new Random().nextInt(i+1);
            }
            this.arr = a;
        }
        catch (Exception e){
            System.out.println("Длина массива должна быть больше 0");
        }
    }

    public int[] getArr() {
        return arr;
    }

    public int getArrItem(int index) {
        return arr[index];
    }

    public int size(){
        return this.arr.length;
    }

    @Override
    public String toString(){
        String str = "Array : ";
        for (int i : arr) {
            str += i+" ";   
        }
        return str;
    }
    
}
