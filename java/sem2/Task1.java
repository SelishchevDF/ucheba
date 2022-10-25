
//Написать программу, показывающую последовательность действий для игры “Ханойская башня”

public class Task1 {
    public static void main(String[] args) {

        String stringInvatation = "введите количество дисков";
        String stringError = "введите количество дисков правильно правильно - целый и больше 0";
        
        int num = Task1InpitInt.inputNum(stringInvatation, stringError);
        towerOfHanoi(num, 'A', 'C', 'B');
        
    }
    
    static void towerOfHanoi(int num, char from_rod, char to_rod, char aux_rod)
    {
        if (num == 1)
        {
            System.out.println("Move disk 1 from rod " +  from_rod + " to rod " + to_rod);
            return;
        }
        towerOfHanoi(num-1, from_rod, aux_rod, to_rod);
        System.out.println("Move disk " + num + " from rod " +  from_rod + " to rod " + to_rod);
        towerOfHanoi(num-1, aux_rod, to_rod, from_rod);
    }         
}