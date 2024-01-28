package t6;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {

    // based on "https://www.knowprogram.com/java/monty-hall-java-program/" 

    public static void main(String[] args) {

        Random random = new Random();
        Map<Integer, Boolean> playerNeverChagesTheDoorResultMap = new HashMap<Integer, Boolean>();
        Map<Integer, Boolean> playerAlwaysChagesTheDoorResultMap = new HashMap<Integer, Boolean>();
        int trial = 1000;

        System.out.println("The player never changes the door.");
        int win = 0;
        for (int i = 1; i <= trial; i++) {
            int prizeDoor = random.nextInt(3);
            int contestantDoor = random.nextInt(3);

            if (contestantDoor == prizeDoor) {
                win++;
                playerNeverChagesTheDoorResultMap.put(i, true);
            }
            else{
                playerNeverChagesTheDoorResultMap.put(i, false);
            }
        }

        System.out.println("Total Wins out of " + trial + ": " + win);
        System.out.println("Percent win: " + (double) win / trial);
        System.out.println();

        System.out.println("The player always changes the door.");
        win = 0;
        for (int i = 1; i <= trial; i++) {
            int prizeDoor = random.nextInt(3);
            int contestantDoor = random.nextInt(3);

            int wrongDoor = prizeDoor;
            while (wrongDoor == prizeDoor || wrongDoor == contestantDoor) {
            wrongDoor = random.nextInt(3);
            }

            int alternateDoor = 3 - (contestantDoor + wrongDoor);

            if (alternateDoor == prizeDoor) {
                win++;
                playerAlwaysChagesTheDoorResultMap.put(i, true);
            }
            else{
                playerAlwaysChagesTheDoorResultMap.put(i, false);
            }
        }

        System.out.println("Total Wins out of " + trial + ": " + win);
        System.out.println("Percent win: " + (double) win / trial);
    }
}
    
