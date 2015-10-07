import java.util.ArrayList;
import java.util.Scanner;

public class IsValidBST {

	public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int numTests = in.nextInt();
        in.nextLine();
        
        for (int i = 0; i < numTests; i++) {
        	int numNodes = in.nextInt();
        	in.nextLine();
        	String[] treeStrings = in.nextLine().split(" ");
        	int[] tree = new int[numNodes];
        	
        	for (int j = 0; j < numNodes; j++) { // create the tree
        		tree[j] = Integer.parseInt(treeStrings[j]);
        	}
        	
        	System.out.println(checkPreOrder(tree));
        	
        }
		
	}
	
	static String checkPreOrder(int[] tree) {
		
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		int bottom = -1;
		
		for (int i = 0; i < tree.length; i++) {
			if (bottom > -1 && tree[i] < bottom) {
				return "NO";
			}
			while (numbers.size() > 0 && numbers.get(numbers.size() - 1) < tree[i]) {
				bottom = numbers.get(numbers.size() - 1);
				numbers.remove(numbers.size() - 1);
			}
			numbers.add(tree[i]);
		}
		return "YES";
	}

}
/*import java.util.Scanner;

public class IsValidBST {
	
	public static class Node {
		private Node right;
		private Node left;
		private int value;
		
		public Node(int value) {
			this.value = value;
		}
		
		public Node leftNode() {
			return left;
		}
		
		public Node rightNode() {
			return right;
		}
		
		public int getValue() {
			return value;
		}
		public static void insert(Node node, int value) {
			
			if (value < node.value) {
				
				if (node.left != null) {
					insert(node.left, value);
				} else {
					node.left = new Node(value);
				}
				
			} else if (value > node.value) {
				
				if (node.right != null) {
					insert(node.right, value);
				} else {
					node.right = new Node(value);
				}
				
			}
			
		}
		  public static void printInOrder(Node node) {
			    if (node != null) {
			      printInOrder(node.left);
			      System.out.println("  Traversed " + node.value);
			      printInOrder(node.right);
			    }
			  }
		
	}
	
	public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int numTests = in.nextInt();
        in.nextLine();
        
        for (int i = 0; i < numTests; i++) {
        	int numNodes = in.nextInt();
        	in.nextLine();
        	String[] treeStrings = in.nextLine().split(" ");
        	int[] tree = new int[numNodes];
        	Node root = new Node(Integer.parseInt(treeStrings[0]));
        	tree[0] = Integer.parseInt(treeStrings[0]);
        	
        	for (int j = 1; j < numNodes; j++) { // create the tree
        		tree[j] = Integer.parseInt(treeStrings[j]);
        		Node.insert(root, tree[j]);
        	}
        	
        	Node.printInOrder(root);
        	System.out.println(checkPreOrder(root));
        	
        	
        }
		
		
	}
	
	static String checkPreOrder(Node root) {
		
		if (root == null) {
			return "YES";
		}
		
		checkPreOrder(root.leftNode());
		checkPreOrder(root.rightNode());
		
		return "NO";
		
	}
	
}
*/