
public class Worker {

    private Integer serviceNumber;
    private Integer experience;
    private String name;
    private String phone;

    public Worker(Integer serviceNumber, Integer experience, String name, String phone) {
        this.serviceNumber = serviceNumber;
        this.experience = experience;
        this.name = name;
        this.phone = phone;
    }

    public Integer getServiceNumber() {
        return serviceNumber;
    }

    public void setServiceNumber(Integer serviceNumber) {
        this.serviceNumber = serviceNumber;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
 
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return this.serviceNumber + ": " + this.name;
    }
}
