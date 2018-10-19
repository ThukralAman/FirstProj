package aman.trees;

import java.util.HashMap;

class NodeInOut {
	//BinaryTreeNode node;
	int in;
	int out;
}

class CurrentInOut {
	int currIn;
	int currOut;
}

public class QueryAncestorDescendantRelationship {
	
	public boolean isAncestor(HashMap<Integer, NodeInOut> hm, int n1, int n2) {
		NodeInOut n1_inOut = hm.get(n1);
		NodeInOut n2_inOut = hm.get(n2);
		
		if( (n1_inOut.in < n2_inOut.in) && (n1_inOut.out > n2_inOut.out) ) {
			return true;
		}
		
		
		
		return false;
	}
	
	public void fillMap(BinaryTreeNode root, HashMap<Integer, NodeInOut> hm, CurrentInOut currInOut) {
		if(root==null) {
			return;
		}
		
		NodeInOut nodeInOut = new NodeInOut();
		//nodeInOut.node = root;
		nodeInOut.in = currInOut.currIn;
		currInOut.currIn++;
		
		fillMap(root.left, hm, currInOut);
		fillMap(root.right, hm, currInOut);
		
		nodeInOut.out = currInOut.currOut;
		currInOut.currOut++;	
		hm.put(root.data, nodeInOut);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree tree = new BinaryTree();
		tree.root = new BinaryTreeNode(10);
		
		tree.root.left = new BinaryTreeNode(20);
		tree.root.right = new BinaryTreeNode(30);
		
		tree.root.left.left = new BinaryTreeNode(40);
		tree.root.left.right = new BinaryTreeNode(50);
		tree.root.right.left = new BinaryTreeNode(60);
		
		tree.root.right.right = new BinaryTreeNode(70);
		
		QueryAncestorDescendantRelationship obj = new QueryAncestorDescendantRelationship();
		
		HashMap<Integer, NodeInOut> inAndOutMap = new HashMap<>();
		
		CurrentInOut currInOut = new CurrentInOut();
		currInOut.currIn=1;
		currInOut.currOut = 1;
		
		obj.fillMap(tree.root, inAndOutMap, currInOut);
		
		
		
		boolean res = obj.isAncestor(inAndOutMap, 20, 40);
		
		System.out.println("is 10 ancestor of 70 : " + res);
		

	}

}
