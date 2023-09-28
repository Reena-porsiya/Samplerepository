class Node {
    private String data;
    private Node next;

    public Node(String data) {
        this.data = data;
        this.next = null;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

public class Queue8 {
    private Node headNode;
	public Node getHeadNode() {
        return headNode;
    }

    public void setHeadNode(Node headNode) {
        this.headNode = headNode;
    }

    public void addNode(String data) {
        Node newNode = new Node(data);
        if (headNode == null) {
            headNode = newNode;
        } else {
            Node current = headNode;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    // New method to insert a node with the specified data after the given key data
    public void insertNode(String newData, String afterData) {
        Node newNode = new Node(newData);
        if (headNode == null) {
            headNode = newNode;
            } else {
            Node current = headNode;
            while (current != null && !current.getData().equals(afterData)) {
                current = current.getNext();
            }
            if (current != null) {
                newNode.setNext(current.getNext());
                current.setNext(newNode);
            } else {
                // If the afterData is not found, append the new node to the end of the queue
                current = headNode;
                while (current.getNext() != null) {
                    current = current.getNext();
                }
                current.setNext(newNode);
            }
        }
    }
    public void searchNode(String name){
    		Node current = headNode;

    		boolean valuefound = false;
                while (current != null )  {
		 if(current.getData().equals(name)){
		 valuefound = true;
		 return true;
			}
                current = current.getNext();
			}
  }

    public void display() {
        Node current = headNode;
        while (current != null) {
            System.out.print(current.getData() + "  ");
            current = current.getNext();
        }
        System.out.println();
}

    public static void main(String[] args) {
        Queue q1 = new Queue();
        q1.addNode("John");
        q1.addNode("Lisa");
        q1.addNode("ram");
        q1.addNode("abi");

        // Inserting the node with data "vimal" after "John" if it exists, otherwise, append to the end
        q1.insertNode("vimal", "John");

        q1.display();

         Node FoundNode = q1.searchNode("abi");
         if(foundNode != null){
		System.out.println("node found:");
         } else {
		System.out.println(" no node found:");
			}
		}
	}