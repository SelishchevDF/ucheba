public class Node {
    
	Node left, right;
    int data;

    boolean color;
     
    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
        color = true;
    }
}