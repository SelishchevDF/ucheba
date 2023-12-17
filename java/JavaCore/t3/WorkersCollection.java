import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WorkersCollection implements Iterable<BaseWorker>{

    private List<BaseWorker> workers = new ArrayList<BaseWorker>();



    //constructor
    public WorkersCollection(List<BaseWorker> workers) {
        this.workers = workers;
    }


    //getters and setters 
    public List<BaseWorker> getWorkers() {
        return workers;
    }


    //Methods
    @Override
    public Iterator<BaseWorker> iterator() {
        return workers.iterator();
    }

    public void add(BaseWorker worker){
        workers.add(worker);
    }
    
}
