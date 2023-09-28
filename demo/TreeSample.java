class TreeNode {

	private int value;
	private TreeNode leftNode;
	private TreeNode rightNode;

	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public TreeNode getLeftNode() {
		return leftNode;
	}
	public void setLeftNode(TreeNode leftNode) {
		this.leftNode = leftNode;
	}
	public TreeNode getRightNode() {
		return rightNode;
	}
	public void setRightNode(TreeNode rightNode) {
		this.rightNode = rightNode;
	}

}

public class TreeSample {

	private TreeNode rootNode;

	public TreeNode getRootNode() {
		return rootNode;
	}

	public void setRootNode(TreeNode rootNode) {
		this.rootNode = rootNode;
	}

	public void addNode(int value) {
		TreeNode newNode = new TreeNode();
		newNode.setValue(value);

		if (rootNode == null) {
			rootNode = newNode;
			return;
		}

		addNode(getRootNode(), newNode);
	}

	public void addNode(TreeNode currentNode, TreeNode newNode) {
		int currentValue = currentNode.getValue();
		int newNodeValue = newNode.getValue();

		if (newNodeValue < currentValue) {
			if (currentNode.getLeftNode() == null) {
				currentNode.setLeftNode(newNode);
			} else {
				addNode(currentNode.getLeftNode(), newNode);
			}
		} else {
			if (currentNode.getRightNode() == null) {
				currentNode.setRightNode(newNode);
			} else {
				addNode(currentNode.getRightNode(), newNode);
			}
		}
	}
	public void removeNode(int value) {
		rootNode = removeNode(rootNode, value);
	}

	public TreeNode removeNode(TreeNode currentNode, int value) {
		if (currentNode == null) {
			return null;
		}

		int currentValue = currentNode.getValue();

		if (value < currentValue) {
			currentNode.setLeftNode(removeNode(currentNode.getLeftNode(), value));
		} else if (value > currentValue) {
			currentNode.setRightNode(removeNode(currentNode.getRightNode(), value));
		} else {
			if (currentNode.getLeftNode() == null) {
				return currentNode.getRightNode();
			} else if (currentNode.getRightNode() == null) {
				return currentNode.getLeftNode();
			}
			currentNode.setValue(findMinValue(currentNode.getRightNode()));
			currentNode.setRightNode(removeNode(currentNode.getRightNode(), currentNode.getValue()));
		}

		return currentNode;
	}

	public int findMinValue(TreeNode node) {
		int minValue = node.getValue();
		while (node.getLeftNode() != null) {
			minValue = node.getLeftNode().getValue();
			node = node.getLeftNode();
		}
		return minValue;
	}



	public void printAllNodes() {
		printNode(getRootNode());
	}

	private void printNode(TreeNode node) {
		if (node == null) {
			return;
		}

		System.out.print(node.getValue() + ",");
		if (node.getLeftNode() != null) {
			System.out.print("..L..");
			printNode(node.getLeftNode());
		}
		if (node.getRightNode() != null) {
			System.out.print("..R..");
			printNode(node.getRightNode());
		}
	}

	public static void main(String[] args) {
		TreeSample tSample = new TreeSample();
		tSample.addNode(50);
		tSample.addNode(40);
		tSample.addNode(30);
		tSample.addNode(20);
		tSample.addNode(70);
		tSample.addNode(68);
		tSample.addNode(63);
                tSample.addNode(80);
		tSample.addNode(72);
		tSample.printAllNodes();

		tSample.removeNode(70);

		System.out.println("\nTree after removing 30:");
		tSample.printAllNodes();
	}
}
