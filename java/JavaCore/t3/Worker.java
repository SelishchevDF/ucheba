
public class Worker extends BaseWorker {
    
    private float monthSalary;


    //constructor
    public Worker(String name, float monthSalary) {
        super(name);
        this.monthSalary = monthSalary;
        setAverageSalaryPerMonth();
    }
    

    //getters and setters
    public float getMonthSalary() {
        return monthSalary;
    }


    public void setMonthSalary(float monthSalary) {
        this.monthSalary = monthSalary;
        setAverageSalaryPerMonth();
    }


    //methods
    protected void setAverageSalaryPerMonth(){
        averageSalaryPerMonth = monthSalary;
    }

    public static Worker create(String name, float monthSalary){
        return new Worker(name, monthSalary);
    }
}

