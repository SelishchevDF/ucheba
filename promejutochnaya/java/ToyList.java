import java.util.ArrayList;
import java.util.List;

public class ToyList {
    
    private List<Toy> list;

    public ToyList() {
        this.list = new ArrayList<Toy>();
    }

    public Toy get(int index){
        return this.list.get(index);
    }

    public int size(){
        return this.list.size();
    }

    public String toyListToString(){
        String result = "";
        for (int i = 0; i < this.list.size(); i++){
            result = result + list.get(i).toyToString() + "\n";
        }
        return result;
    }

    public void addToy(String name, int quantity, int weight){
        Toy toyToAdd = new Toy(this.list, name, quantity, weight);
        this.list.add(toyToAdd);
    }

    public void addToy(int id, String name, int quantity, int weight){
        Toy toyToAdd = new Toy(id, name, quantity, weight);
        this.list.add(toyToAdd);
    }

    protected void removeToy(Toy i){
        this.list.remove(i);
    }
    
    protected void removeQuantity (int i){
        this.list.get(i).setQuantity(this.list.get(i).getQuantity() - 1);
        if (this.list.get(i).getQuantity() == 0){
            removeToy(this.list.get(i));
        }
    }    
}
