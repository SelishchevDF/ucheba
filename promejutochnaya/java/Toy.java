import java.util.List;
import java.util.Random;

public class Toy {

    private int id;
    private String name;
    private int quantity;
    private int weight;
    
    public Toy(List<Toy> list, String name, int quantity, int weight) {
        this.id = setId(list);
        this.name = name;
        this.quantity = quantity;
        this.weight = weight;
    }
    
    public Toy(int id, String name, int quantity, int weight) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public int setId(List<Toy> list) {
        int upperRange = 1000;
        Random random = new Random();
        int tempId = random.nextInt(upperRange);
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).getId() == tempId){
                tempId++;
                i = 0;
            }
        }
        return this.id = tempId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String toyToString(){
        String res = "";
        res = "id: " + this.id + " / " + "название: " + this.name + " / " + 
        "количество: " + this.quantity +" / " + "вес: " + this.weight + "\n";       
        return res; 
    }
}