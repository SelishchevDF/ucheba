import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

//волновой алгоритм

public class Task1 {
    public static void main(String[] args) {

        Integer [][] labirint = {{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
                             {-1,  0, -1, -1, -1, -1, -1, -1,  0, -1},
                             {-1,  0,  0,  0,  0,  0,  0,  0,  0, -1},
                             {-1,  0,  0, -1,  0, -1,  0,  0,  0, -1},
                             {-1,  0,  0, -1,  0, -1, -1, -1,  0, -1},
                             {-1,  0, -1, -1,  0, -1, -1, -1,  0, -1},
                             {-1,  0, -1, -1,  0, -1, -1, -1,  0, -1},
                             {-1,  0,  0,  0,  0,  0,  0,  0,  0, -1},
                             {-1,  0, -1,  0,  0,  0, -1,  0, -1, -1},
                             {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1}
                            };

        Integer [] labInter = {1, 1};
        Integer [] labExit1 = {8, 7};
        Integer [] labExit2 = {1, 8};

        for (Integer i = 0; i < labirint.length; i++){
            for (Integer j = 0; j < labirint[i].length; j++){         
                if (i == labInter[0] && j == labInter[1]){
                    System.out.printf("@");
                }
                else if (i == labExit1[0] && j == labExit1[1]){
                    System.out.printf("X");
                }
                else if (i == labExit2[0] && j == labExit2[1]){
                    System.out.printf("X");
                }
                else if (labirint[i][j] == -1){
                    System.out.printf("█");
                }
                else if (labirint[i][j] == 0){
                    System.out.printf("▒");
                }
            }
            System.out.println();
        }

        tuda(labirint,labInter,labExit1,labExit2);
        System.out.println();
        suda(labirint,labInter,labExit2);
        System.out.println();
        suda(labirint,labInter,labExit1);

 
    }

    public static void tuda(Integer[][] arr, Integer[] inter, Integer[] exit1, Integer[] exit2){
        List<Integer[]> q = new ArrayList<Integer[]>();
        q.add(inter);
        Integer[] tern = new Integer[2];
        arr[inter[0]][inter[1]] = 1; //вошли - сделали первый шаг

        while(!q.isEmpty()){
            Integer[] temp = new Integer[2];
            tern = q.get(0);
            if (arr[tern[0]+1][tern[1]] == 0){ // вниз
                arr[tern[0]+1][tern[1]] = arr[tern[0]][tern[1]] +1;
                temp = tern.clone();
                temp[0] = temp[0] + 1;                
                q.add(temp);
            }
            else if (arr[tern[0]][tern[1]+1] == 0){ // вправо
                arr[tern[0]][tern[1]+1] = arr[tern[0]][tern[1]] +1;
                temp = tern.clone();
                temp[1] = temp[1] + 1;                
                q.add(temp);
            }
            else if (arr[tern[0]-1][tern[1]] == 0){ // вверх
                arr[tern[0]-1][tern[1]] = arr[tern[0]][tern[1]] +1;
                temp = tern.clone();
                temp[0] = temp[0] - 1;                
                q.add(temp);

            }
            else if (arr[tern[0]][tern[1]-1] == 0){ // влево
                arr[tern[0]][tern[1]-1] = arr[tern[0]][tern[1]] +1;
                temp = tern.clone();
                temp[1] = temp[1] - 1;                
                q.add(temp);
            }
            else{
                q.remove(0); // удалили первый элемент списка, если нет совпадений и пошли дальше
            }
        }
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){         
                System.out.print(arr[i][j] + "    ");
        }
        System.out.println();
        }
    }

    public static void suda(Integer[][] arr, Integer[] inter, Integer[] exit){
        Integer[] tern = exit.clone();
        arr[inter[0]][inter[1]] = 2;
        
        while(arr[inter[0]][inter[1]] != 1 ){
            if ((arr[tern[0]][tern[1]] > arr[tern[0]][tern[1]-1]) && (arr[tern[0]][tern[1]-1] != -1)){ // влево
                arr[tern[0]][tern[1]] = 1;
                tern[1] = tern[1] - 1;
            }
            else if ((arr[tern[0]][tern[1]] > arr[tern[0]-1][tern[1]]) && (arr[tern[0]-1][tern[1]] != -1)){ // вверх
                arr[tern[0]][tern[1]] = 1;
                tern[0] = tern[0] - 1;
            }
            else if ((arr[tern[0]][tern[1]] > arr[tern[0]][tern[1]+1]) && (arr[tern[0]][tern[1]+1] != -1)){ // вправо
                arr[tern[0]][tern[1]] = 1;
                tern[1] = tern[1] + 1;
            }
            else if ((arr[tern[0]][tern[1]] > arr[tern[0]+1][tern[1]]) && (arr[tern[0]+1][tern[1]] != -1)){ // вниз
                arr[tern[0]][tern[1]] = 1;
                tern[0] = tern[0] + 1;
            }           
            else{
                arr[inter[0]][inter[1]] = 1;
            }
        }
       
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){         
                if (arr[i][j] == 1){
                    System.out.printf("*");
                }
                else if (arr[i][j] == -1){
                    System.out.printf("█");
                }
                else if (arr[i][j] != 0){
                    System.out.printf("▒");
                }
            }
            System.out.println();
        }
    }  
} 
