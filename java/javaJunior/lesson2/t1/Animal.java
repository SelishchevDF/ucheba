package lesson2.t1;

public abstract class Animal {
    
    private int age;
    private String name;

    public Animal(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
}
