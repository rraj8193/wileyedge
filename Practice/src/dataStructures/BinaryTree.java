package dataStructures;

class Node{
	int data;
	Node left;
	Node right;
	
	public Node(int data) {
		this.data = data;
		left = right = null;
	}
}

public class BinaryTree {
	Node root;
	
	public static void inorder(Node root) {
		if (root==null) {
			return;
		}
		inorder(root.left);
		System.out.print(root.data+"--->");
		inorder(root.right);
	}
	
	
	
	public static void main(String[] args) {
		BinaryTree tree  = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.right.right = new Node(5);
		inorder(tree.root);
	}
}
