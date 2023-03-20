
public class Main {
	
	public static void main(String[] args) {
				 
		Tree tree = new Tree();
		 
		tree.root = tree.insert(tree.root, 12);

		tree.root.color = false;
		 
		tree.root = tree.insert(tree.root, 9);
		tree.root.color = false;
		 
		tree.root = tree.insert(tree.root, 48);
		tree.root.color = false;
		 
		tree.root = tree.insert(tree.root, 100);
		tree.root.color = false;
		 
		tree.root = tree.insert(tree.root, 1);
		tree.root.color = false;
		 
		tree.root = tree.insert(tree.root, 60);
		tree.root.color = false;

		tree.inorder(tree.root);
		}
}
