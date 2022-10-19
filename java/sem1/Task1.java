
//Написать программу вычисления n-ого треугольного числа.

public class Task1 {
    public static void main(String[] args) {

        String stringInvatation = "введите номер элемента";
        String stringError = "введите номер элемента правильно - целый и больше 0";
        
        int num = Task1InpitInt.inputNum(stringInvatation, stringError);
        int answer = num*(num + 1)/2;
        System.out.println("Ответ " + answer);
    }
    
}