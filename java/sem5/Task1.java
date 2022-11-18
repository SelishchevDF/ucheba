package ucheba.java.sem5;

import java.util.ArrayList;

// Сформировать и сделать обход дерева, для которого у каждого узла может быть больше 2-х потомков

// * Сложный пример ПОДУМАТЬ
//          1
//        /   \
//       2      3
//      /     /   \
//     4     5     6
//   / | \        / \
//  7  8  9     11   20


public class Task1{
    public static void main(String[] args) {
        Node root = new Node(1);

        Node n2 = new Node(2);
        Node n3 = new Node(3);

        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);

        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);
        Node n11 = new Node(11);
        Node n20 = new Node(20);

        ArrayList<Node> temp_array_root = new ArrayList<Node>();
        temp_array_root.add(n2);
        temp_array_root.add(n3);
        root.children = temp_array_root;

        ArrayList<Node> temp_array_n2 = new ArrayList<Node>();
        temp_array_n2.add(n4);
        n2.children = temp_array_n2;

        ArrayList<Node> temp_array_n3 = new ArrayList<Node>();
        temp_array_n3.add(n5);
        temp_array_n3.add(n6);
        n3.children = temp_array_n3;

        ArrayList<Node> temp_array_n4 = new ArrayList<Node>();
        temp_array_n4.add(n7);
        temp_array_n4.add(n8);
        temp_array_n4.add(n9);
        n4.children = temp_array_n4;

        ArrayList<Node> temp_array_n6 = new ArrayList<Node>();
        temp_array_n6.add(n11);
        temp_array_n6.add(n20);
        n6.children = temp_array_n6;

        preOrder(root, "");
    }

    static void preOrder(Node tree, String str){
        if (tree != null) {
            System.out.println(str + tree.value);
        }
        else{
            System.out.println(str + "nil");
            return;
        }
        for (int i = 0; i < tree.children.size(); i++) {
            preOrder(tree.children.get(i), str + " ");
        }
    } 
}

class Node{
    int value;
    ArrayList<Node> children = new ArrayList<Node>();
    public Node(int value){
        this.value = value;
    }
}
 


    