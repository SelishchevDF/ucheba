package lesson2.t1;

public class Dog extends Animal {

    private String voise;

    public Dog(int age, String name, String voise) {
        super(age, name);
        this.voise = voise;
    }
    
    @Override
    public String toString() {
        return (this.getClass() + ": " + getName());
    }

    public String makeSound() {
        return voise;
    }
    
}
