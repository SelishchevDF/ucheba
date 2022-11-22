package ucheba.java.sem6;

public class CreateProduct {

    Product temp;

    public CreateProduct() {
        temp = new Product();
        temp.id = -1;
        temp.price = -1;
        temp.name = "EMPTY";
        temp.description = "EMPTY";
    }

    public CreateProduct setId( int id ) {
        temp.id = id;
        return this;
    }

    public CreateProduct setPrise( int price ) {
        temp.price = price;
        return this;
    }

    public CreateProduct setName( String name ) {
        temp.name = name;
        return this;
    }

    public CreateProduct setDescription( String description ) {
        temp.description = description;
        return this;    
    }

    public Product Create(){
        return temp;
    }
}
