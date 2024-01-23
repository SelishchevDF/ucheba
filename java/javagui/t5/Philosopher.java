public class Philosopher extends Thread {

    private final static int HOW_MANY_EAT = 3;
    Spoon left, right;
    String name;
    int countOfEaten;

    public Philosopher(Spoon left, Spoon right, String name) {
        this.left = left;
        this.right = right;
        this.name = name;
    }

    @Override
    public void run() {
        while (countOfEaten < HOW_MANY_EAT){
            if (left.isAvailable() && right.isAvailable()){
                eat();
            }
        }
        System.out.println(name + " наелся");
    }

    public void eat() {
        //synchronized(left) {
            left.setAvailable(false);
        //}
        //synchronized(right){
            right.setAvailable(false);
        //}
        System.out.println(name + " взял ложки: " + left.getName() + " и "
                            + right.getName() + " и сел есть в " + (countOfEaten + 1) + " раз");
        countOfEaten++;
        try {
            sleep(1500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        left.setAvailable(true);
        right.setAvailable(true);
        System.out.println(name + " поел, вернул ложки: " + left.getName() + " и "
                            + right.getName());    
    }
}
