package lab3.problem2.main;

import java.util.ArrayList;
import java.util.Scanner;

import lab3.problem2.node.Node;

public class BinarySearchTree {

	ArrayList<Integer> list = new ArrayList<>();

	public static void main(String[] args) {
		BinarySearchTree obj1 = new BinarySearchTree();
		Node root = null;
		Node n = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("Pls enter number of nodes");
		int size = sc.nextInt();
		int i;
		for (i = 1; i <= size; i++) {
			System.out.println("Enter Data for the node");
			int item = sc.nextInt();
			n = new Node(item);
			if (root == null)
				root = n;
			else
				obj1.insert(root, n);

		}

		obj1.inOrder(root);
		System.out.println(obj1.list);

		System.out.println("Enter Sum to search");
		int search = sc.nextInt();
		int flag = 0;
		for (int j = 0; j < obj1.list.size(); j++) {
			int n1 = obj1.list.get(j);
			int n2 = search - n1;
			if (obj1.list.contains(n2)) {
				System.out.println("Found");
				System.out.println(n1 + "," + n2);
				flag = 1;
				break;
			}

		}
		if (flag == 0)
			System.out.println("No matching elements found");

	}

	private void insert(Node root, Node n) {
		if (n.data < root.data) {
			if (root.left == null) {
				root.left = n;
			} else {
				insert(root.left, n);

			}
		} else {
			if (root.right == null) {
				root.right = n;
			} else {
				insert(root.right, n);

			}
		}

	}

	private void inOrder(Node root) {
		if (root != null) {
			inOrder(root.left);
			list.add(root.data);
			inOrder(root.right);
		}
	}

}