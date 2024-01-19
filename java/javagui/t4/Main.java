public class Main{
    public static void main(String[] args) {

        WorkerMap wm = new WorkerMap();

        System.out.println(wm.addWorker(new Worker(100, 10, "ivan", "100")));
        System.out.println(wm.addWorker(new Worker(100, 10, "ivan", "100")));
        System.out.println(wm.addWorker(new Worker(200, 12, "alex", "200")));
        System.out.println(wm.addWorker(new Worker(300, 13, "olya", "300")));
        System.out.println(wm.addWorker(new Worker(400, 14, "alex", "400")));
        System.out.println(wm.addWorker(new Worker(500, 12, "dima", "500")));
        System.out.println(wm);

        System.out.println(wm.filterByExpirienceLessThen(12));

        System.out.println(wm.getPhones("alex"));

        System.out.println(wm.getWorkerByServiceNumber(300));

        

    }
            
}