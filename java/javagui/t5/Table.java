import java.util.ArrayList;
import java.util.List;

public class Table{

    private List<Spoon> spoons;
    private List<Philosopher> philosophers;

    public Table(int numberOfPersonsAndSpoons){
        spoons = new ArrayList<>(numberOfPersonsAndSpoons);
        philosophers = new ArrayList<>(numberOfPersonsAndSpoons);
        for (int i = 0; i < numberOfPersonsAndSpoons; i++){
            spoons.add(new Spoon("ложка " + Integer.toString(i + 1)));
        }

        // чтобы не лепить в цикле проверку последний или нет
        philosophers.add(new Philosopher(spoons.get(numberOfPersonsAndSpoons - 1), spoons.get(0), "философ 1"));
        // создание остальных философов
        for (int i = 1; i < numberOfPersonsAndSpoons; i++) {
            philosophers.add(new Philosopher(spoons.get(i - 1), 
                            spoons.get(i), ("философ ") + Integer.toString(i + 1)));
        }
    }

    public void startEating(){
        for (Philosopher philosopher : philosophers) {
            philosopher.start();
        }
    }

    public Philosopher getPhilosopher(int index){
        return philosophers.get(index);
    }
}