
public interface WorkerCRUDInterface {
    String addWorker(Worker worker);
    Worker getWorkerByServiceNumber(Integer value);
    Worker getWorkerByName(String name);
    boolean isInMap(Worker worker);
    String updateWorker(Worker worker);
}
