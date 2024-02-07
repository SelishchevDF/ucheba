package lesson2.t1;

public class Cat extends Animal {
    
    private int mustacheLength;

    public Cat(int age, String name, int mustacheLength) {
        super(age, name);
        this.mustacheLength = mustacheLength;
    }
    
    @Override
    public String toString() {
        return (this.getClass().getSimpleName() + ": " + getName() + ", mustacheLength:" + mustacheLength);
    }
}
