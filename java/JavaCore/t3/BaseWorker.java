
public abstract class BaseWorker {
    
    protected String name;
    protected double averageSalaryPerMonth;


    //constructor
    protected BaseWorker(String name){
        this.name = name;
    }


    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAverageSalaryPerMonth() {
        return averageSalaryPerMonth;
    }


    //methods
    abstract protected void setAverageSalaryPerMonth();

    public void showWorker(){
        System.out.println("name: " + name + ", Class:" + this.getClass().getSimpleName() + ", averageSalaryPerMonth: " + averageSalaryPerMonth);
    }
}
