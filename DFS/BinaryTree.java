package DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BinaryTree {
	Node root;

	public static void main(String args[]) throws Exception {
		// 같은 구조체를 사용하므로 배열을 선언한것이지
		// 자식들을 인덱스로 접근하기 위해서는 아님.
		/*
		 * for (int i = 1; i < 16; i++) {//정점들 초기화. node[i] = new Node(); node[i].data =
		 * i; node[i].leftChild = null; node[i].rightChild = null; }
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Node node = new Node(Integer.parseInt(br.readLine()), null, null);
		String s = "";
		while ((s = br.readLine()) != null && s.length() != 0) { // EOF까지 입력받음
			node = addTree(node, Integer.parseInt(s));
		}
		postOrder(node);
	}

	public static Node addTree(Node root, int value) {
		if (root == null) {
			return new Node(value, null, null);
		}
		if (value < root.data) {
			root.leftChild = addTree(root.leftChild, value);
			return root;
		} else {
			root.rightChild = addTree(root.rightChild, value);
			return root;
		}
	}

	public static void preOrder(Node root) {
		// 요령 : 자기먼저 출력하고 왼쪽->오른쪽 탐색, 출력문이 제일 처음.
		if (root != null) {
			System.out.print(root.data + " ");
			preOrder(root.leftChild);
			preOrder(root.rightChild);
		}
	}

	public static void inOrder(Node root) {
		// 요령 : 왼쪽으로 쭉간 다음, 왼쪽 먼저 출력, 왼쪽 다 출력한 부모 출력 후 오른쪽 출력
		if (root != null) {
			inOrder(root.leftChild);
			System.out.print(root.data + " ");
			inOrder(root.rightChild);
		}
	}

	public static void postOrder(Node root) {
		// 요령 : 왼쪽으로 쭉간 다음, 왼쪽 오른쪽 다 출력한 다음 부모 출력
		if (root != null) {
			postOrder(root.leftChild);
			postOrder(root.rightChild);
			System.out.print(root.data + " ");
		}
	}
}

class Node {
	int data;
	Node leftChild, rightChild;

	public Node(int data, Node leftChild, Node rightChild) {
		this.data = data;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}
}