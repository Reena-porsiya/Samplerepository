public class LinkedList2 {
    public static class Node {
        private String name;
        private Node nextNode;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Node getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }
    }

    public static void printNodes(Node currNode) {
        while (currNode != null) {
            System.out.println(currNode.getName());
            currNode = currNode.getNextNode();
        }
    }

    public static void addNode(String name, Node headNode) {
        Node newNode = new Node();
        newNode.setName(name);

        Node currentNode = headNode;

        if (currentNode != null) {
            while (currentNode.getNextNode() != null) {
                currentNode = currentNode.getNextNode();
            }
            currentNode.setNextNode(newNode);
        } else {
            headNode = newNode;
        }
    }
public static void deleteNode(String name, Node headNode) {
    Node currentNode = headNode;
    Node previousNode = null;

    // Case 1: If the head node itself holds the name to be deleted
    if (currentNode != null && currentNode.getName().equals(name)) {
        headNode = currentNode.getNextNode();
        return;
    }

    // Case 2: If the name to be deleted is in the middle or end of the list
    while (currentNode != null && !currentNode.getName().equals(name)) {
        previousNode = currentNode;
        currentNode = currentNode.getNextNode();
    }

    // If the name is found, delete the node by updating the nextNode reference of the previous node
    if (currentNode != null) {
        previousNode.setNextNode(currentNode.getNextNode());
    }
}

    public static void main(String[] args) {
        Node n1 = new Node();
        n1.setName("John");

        Node n2 = new Node();
        n2.setName("Lisa");

        Node n3 = new Node();
        n3.setName("Smith");

        n1.setNextNode(n2);
        n2.setNextNode(n3);
        n1.setName("Varrun");

        printNodes(n1);
        addNode("Yuvaraj", n1);
        System.out.println("===========");
        printNodes(n1);
    }
}