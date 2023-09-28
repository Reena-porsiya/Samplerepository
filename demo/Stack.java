 public class Stack {
	
	private Node lastNode;
	
	public Node getLastNode() {
		return lastNode;
	}

	public void setLastNode(Node lastNode) {
		this.lastNode = lastNode;
	}

	public void push(String name) {
	Node newNode = new Node(name);
        if (lastNode == null) {
            lastNode = newNode;
        } else {
            newNode.setNext(lastNode);
            lastNode = newNode;
        }
		
	}
	
	public void pop() {
	if (lastNode != null) {
            lastNode = lastNode.getNext();
        }
		
	}
	
	public void print() {
	Node current = lastNode;
        System.out.println("Stack elements:");
        while (current != null) {
            System.out.println(current.getName());
            current = current.getNext();
        }
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack s1 = new Stack();
		s1.push("John");
		s1.push("Lisa");
		s1.print();
		s1.pop();
		s1.print();
	}

}