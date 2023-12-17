import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        
        List<BaseWorker> a = new ArrayList<BaseWorker>();
        
        a.add(Freelancer.create("Vasya", 100));
        a.add(Worker.create("Perya", 1000));
        a.add(Freelancer.create("Jenya", 200));
        a.add(Worker.create("Sasha", 2000)); 

        Comparator<BaseWorker> c = new AverageSalaryPerMonthComporator();
        a.sort(c);

        for (BaseWorker worker : a) {
            worker.showWorker();
        }

        WorkersCollection wc = new WorkersCollection(a);
        wc.add(Freelancer.create("qwer", 300));
        wc.add(Worker.create("asdf", 3000));
        for (BaseWorker worker : wc) {
            worker.showWorker();
        }
        
        
    }
}
