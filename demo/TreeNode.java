package com.demo;

public class TreeNode {

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
 class TreeSample {
	
	private TreeNode rootNode;
	
	public TreeNode getRootNode() {
		return rootNode;
	}

	public void setRootNode(TreeNode rootNode) {
		this.rootNode = rootNode;
	}


	public void addNode(int value) {
		
		//Create a node with the value
		TreeNode newNode = new TreeNode();
		newNode.setValue(value);
		
		if(rootNode == null) {
			rootNode = newNode;
			return;
		}
		
		//if root node exist, then traverse till the leaf node and then add the new node.
		addNode(getRootNode(), newNode);
		
		
	}
	
	public void addNode(TreeNode currentNode, TreeNode newNode) {
		int currentValue = currentNode.getValue();
		int newNodeValue = newNode.getValue();
		
		if(newNodeValue < currentValue) {
			//traverse left side
			if(currentNode.getLeftNode() == null) {
				currentNode.setLeftNode(newNode);
			}else {
				addNode(currentNode.getLeftNode(), newNode); // recursive call
			}
		} else {
			//traverse right side
			if(currentNode.getRightNode() == null) {
				currentNode.setRightNode(newNode);
			}else {
				addNode(currentNode.getRightNode(), newNode);// recursive call
			}
		}
		
	}
	
	
	public void removeNode(int value) {
		
	}
	
	public void printAllNodes() {
		printNode(getRootNode());
	}
	
	public void printNode(TreeNode node) {
		if(node == null) {
			return;
		}
		
		System.out.print(node.getValue() + ",");
		if(node.getLeftNode() !=null) {
			System.out.print("..L..");
			printNode(node.getLeftNode()); //recursive call
		}
		if(node.getRightNode() != null) {
			System.out.print("..R..");
			printNode(node.getRightNode());//recursive call
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeSample tSample = new TreeSample();
		tSample.addNode(50);
		tSample.addNode(30);
		tSample.addNode(80);
		tSample.addNode(37);
		tSample.addNode(89);
		tSample.addNode(25);
		tSample.addNode(70);
		tSample.printAllNodes();
		tSample.removeNode(89);
		
	}

}
