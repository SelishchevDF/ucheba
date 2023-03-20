public class Tree {
 
    Node root = null;
     
    Node rotateLeft(Node myNode){
        Node child = myNode.right;
        Node childLeft = child.left;
 
        child.left = myNode;
        myNode.right = childLeft;
 
        return child;
    }

    Node rotateRight(Node myNode){
        Node child = myNode.left;
        Node childRight = child.right;
 
        child.right = myNode;
        myNode.left = childRight;
 
        return child;
    }
 
    boolean isRed(Node myNode){
        if (myNode == null)
            return false;
        return (myNode.color == true);
    }
 
    void swapColors(Node Node1, Node Node2){
        boolean temp = Node1.color;
        Node1.color = Node2.color;
        Node2.color = temp;
    }
 
    Node insert(Node myNode, int data){
        if (myNode == null)
            return new Node(data);
 
        if (data < myNode.data)
            myNode.left = insert(myNode.left, data);
         
        else if (data > myNode.data)
            myNode.right = insert(myNode.right, data);
         
        else
            return myNode;
 
        if (isRed(myNode.right) && !isRed(myNode.left)){
            myNode = rotateLeft(myNode);
            swapColors(myNode, myNode.left);
        }
 
        if (isRed(myNode.left) && isRed(myNode.left.left)){
            myNode = rotateRight(myNode);
            swapColors(myNode, myNode.right);
        }

        if (isRed(myNode.left) && isRed(myNode.right)){

            myNode.color = !myNode.color;

            myNode.left.color = false;
            myNode.right.color = false;
        }
 
        return myNode;
    }
 
    void inorder(Node Node)
    {
        if (Node != null){
            inorder(Node.left);
            System.out.print(Node.data + " ");
            inorder(Node.right);
        }
    }
}