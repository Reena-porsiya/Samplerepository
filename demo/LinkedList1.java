public class LinkedList1 {
	public static void printNodes(Node currNode) {
		while(currNode != null) {
			System.out.println(currNode.getName());
			currNode = currNode.getNextNode();
		}
	}
	public static void addNode(String name, Node headNode) { 
		Node newNode = new Node();
		newNode.setName(name);
		
		Node currentNode = headNode;
		
		if(currentNode != null) {
			while(currentNode.getNextNode() != null) {
				currentNode = currentNode.getNextNode();
			}
			currentNode.setNextNode(newNode);
		}
	}
	*/public static void deleteNode(String name, Node headNode) {


		
	}*/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node n1 = new Node();
		n1.setName("John"); // John is the name
		
		Node n2 = new Node();
		n2.setName("Lisa");
		
		Node n3 = new Node();
		n3.setName("Smith");
		
		n1.setNextNode(n2);
		n2.setNextNode(n3);
		n1.setName("Varrun"); //updating the name
		
		printNodes(n1);
		addNode("Yuvaraj",n1);
		System.out.println("===========");
		printNodes(n1);
		
	}

}