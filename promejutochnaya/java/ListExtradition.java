

public class ListExtradition extends ToyList {

    public ListExtradition() {
        super();
    }
    
    public String extradition(ListExtradition l) {

        // что бы из очереди ушел первый
        try {
            int i = 0; 
            Toy exToy = l.get(i);
            l.removeToy(l.get(i));
            return exToy.toyToString();
        } catch (Exception e) {
            // TODO: handle exception
            return Texts.QEr;
        }

    }

    public void addToyToExtradition(Toy toy, ListExtradition l){
        int id = toy.getId();
        String name = toy.getName();
        int quantity = 1; // одна же игрушка поиграла
        int weight = toy.getWeight();
        l.addToy(id, name, quantity, weight);
    }
}
