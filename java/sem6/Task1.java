package ucheba.java.sem6;

public class Task1{
    public static void main(String[] args) {

        Product currentProduct = new Product();
        currentProduct.print();

        currentProduct = new CreateProduct()
        .Create();
        currentProduct.print();

        currentProduct = new CreateProduct()
        .setPrise(123)
        .setName("tovar")
        .Create();
        currentProduct.print();
    }
        
}


 


    