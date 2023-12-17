
public class Freelancer extends BaseWorker{

    private float hourlyRate;



    //constructor
    public Freelancer(String name, float hourlyRate) {
        super(name);
        this.hourlyRate = hourlyRate;
        setAverageSalaryPerMonth();
    }
    

    //getters and setters
    public float getHourlyRate() {
        return hourlyRate;
    }


    public void setHourlyRate(float hourlyRate) {
        this.hourlyRate = hourlyRate;
        setAverageSalaryPerMonth();
    }

    
    //methods
    protected void setAverageSalaryPerMonth(){
        averageSalaryPerMonth = 20.8 * 8 * hourlyRate;
    }

    public static Freelancer create(String name, float hourlyRate){
        return new Freelancer(name, hourlyRate);
    }
}
