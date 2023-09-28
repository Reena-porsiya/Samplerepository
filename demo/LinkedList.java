public class LinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node n1 = new Node();
		n1.setName("John");
		
		Node n2 = new Node();
		n2.setName("Lisa");
		
		Node n3 = new Node();
		n3.setName("Smith");
		
		n3.setPreviousNode(n2);
		n2.setPreviousNode(n1);
		
		Node currentNode =  n3;
		
		while(currentNode != null) {
			System.out.println(currentNode.getName());
			currentNode = currentNode.getPreviousNode();
		}
		
		
	}

}