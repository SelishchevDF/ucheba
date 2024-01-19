import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorkerMap implements WorkerCRUDInterface, WorkersFilterInterface {

    Map<Integer, Worker> workers = new HashMap<Integer, Worker>();

    public WorkerMap() {   
    }

    @Override
    public String addWorker(Worker worker) {
        if (!isInMap(worker)){
            workers.put(worker.getServiceNumber(), worker);
            return "add - ok";
        }
        else {
            return "worker whith serviceNumber: " + worker.getServiceNumber() + " exists"; 
        }
    }

    @Override
    public Worker getWorkerByServiceNumber(Integer value) {
        for (Worker worker: workers.values()) {
            if (worker.getServiceNumber().equals(value)){
                return worker;
            }
        }
        return null;
    }

    @Override
    public Worker getWorkerByName(String name) {
        for (Worker worker: workers.values()) {
            if (worker.getName().equals(name)){
                return worker;
            }
        }
        return null;
    }

    @Override
    public boolean isInMap(Worker worker) {
        if (workers.containsKey(worker.getServiceNumber())){
            return true;
        }
        else {
            return false;
        }   
    }

    @Override
    public String updateWorker(Worker worker) {
        return "updateWorker TODO";
    }

    @Override
    public WorkerMap filterByExpirienceMoreThen(Integer value) {
        WorkerMap result = new WorkerMap();
        for (Worker worker: workers.values()) {
            if (worker.getExperience() >= value){
                result.addWorker(worker);
            }        
        }
        return result;
    }

    @Override
    public WorkerMap filterByExpirienceLessThen(Integer value) {
        WorkerMap result = new WorkerMap();
        for (Worker worker: workers.values()) {
            if (worker.getExperience() <= value){
                result.addWorker(worker);
            }        
        }
        return result;
    }

    @Override
    public WorkerMap filterByNames(String name) {
        WorkerMap result = new WorkerMap();
        for (Worker worker: workers.values()) {
            if (worker.getName().equals(name)){
                result.addWorker(worker);
            }        
        }
        return result;
    }

    public List<String> getPhones(String name) {
        List<String> result = new ArrayList<String>();
        for (Worker worker: filterByNames(name).workers.values()){
            result.add(worker.getPhone());
        }
        return result;
    }

    @Override
    public String toString() {
        String result = "";
        for (Worker w : workers.values()){
            result += w.toString() + "\n";
        }

        return result;
    }

}
