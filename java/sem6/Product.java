package ucheba.java.sem6;

public class Product {

    int id;
    int price;
    String name;
    String description;

    public void print() {
        System.out.println(
            String.format(
                "%d %d %s %s",
                this.id,
                this.price,
                this.name,
                this.description));
    }
}
