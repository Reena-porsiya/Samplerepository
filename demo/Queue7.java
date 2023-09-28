public class Queue {
	
	private Node headNode;
	
	public Node getHeadNode() {
		return headNode;
	}

	public void setHeadNode(Node headNode) {
		this.headNode = headNode;
	}

	public void addNode(String name) {
		Node newNode = new Node(name);
		if (headNode == null) {
			headNode = newNode;
		} else {
			Node currentNode = headNode;
			while (currentNode.next != null) {
				currentNode = currentNode.next;
			}
currentNode.next = newNode;
		}
	}
	
	public void removeNode() {
		if (headNode != null) {
			headNode = headNode.next;
		}
	}
	
	public void insert(String name) {
		Node newNode = new Node(name);
		newNode.next = headNode;
		headNode = newNode;
	}
public void insert(String name) {
		Node newNode = new Node(name);
		newNode.next = headNode;
		headNode = newNode;
	}
	
	public void printNodes() {
		Node currentNode = headNode;
		while (currentNode != null) {
			System.out.println(currentNode.name);
			currentNode = currentNode.next;
		}
	}
	
	public static void main(String[] args) {
		Queue q1 = new Queue();
		q1.addNode("John");
		q1.addNode("Lisa");
		q1.printNodes();
		q1.removeNode();
		q1.printNodes();
q1.insert("Mike");
		q1.printNodes();
	}
	
	private static class Node {
		private String name;
		private Node next;

		public Node(String name) {
			this.name = name;
		}
	}
}