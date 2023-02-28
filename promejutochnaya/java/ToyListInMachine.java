
public class ToyListInMachine extends ToyList{

    public ToyListInMachine() {
        super();
    }

    public Toy raffle(int i, ToyListInMachine l) {
        l.get(i).setQuantity(l.get(i).getQuantity() - 1);
        return l.get(i) ;
    }

    public void changeWeight(int i, int weight, ToyListInMachine l ) {
        l.get(i).setWeight(weight); 
        }
}
