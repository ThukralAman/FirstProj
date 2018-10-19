package aman.trees;
import java.util.ArrayList;

import aman.trees.CRUDBinaryTree;

/*
 * 	Print all paths possible in a given binary tree.
 * 
 *   https://www.geeksforgeeks.org/given-a-binary-tree-print-out-all-of-its-root-to-leaf-paths-one-per-line/
 */

public class TreePaths {
	
	public ArrayList<ArrayList<LearnBinaryTreeNode>> getTreePaths(LearnBinaryTreeNode root) {
		if(root == null) {
			return null;
		}
		
		ArrayList<ArrayList<LearnBinaryTreeNode>> paths = new ArrayList<ArrayList<LearnBinaryTreeNode>>();
		ArrayList<LearnBinaryTreeNode> path = new ArrayList<>();
		paths = this.getTreePathsUtil(root, paths, path, 0);
		
		return paths;
		
		
	}
	
	public ArrayList<ArrayList<LearnBinaryTreeNode>> getTreePathsUtil(LearnBinaryTreeNode root, ArrayList<ArrayList<LearnBinaryTreeNode>> paths, ArrayList<LearnBinaryTreeNode> path, int nextIndex) {
		if(root==null) {
			return null;
		}
		
		if(nextIndex < path.size()) {
			path.set(nextIndex, root);
		} else {
			path.add(root);
		}
		nextIndex++;
		
		
		if(root.left == null && root.right == null) {
			paths = this.addPathToPaths(paths, path, nextIndex);
		}
		
		if(root.left != null) {
			this.getTreePathsUtil(root.left, paths, path, nextIndex);
		}
		
		if(root.right != null) {
			this.getTreePathsUtil(root.right, paths, path, nextIndex);
		}
		
		return paths;
	}
	
	public ArrayList<ArrayList<LearnBinaryTreeNode>> addPathToPaths(ArrayList<ArrayList<LearnBinaryTreeNode>> paths, ArrayList<LearnBinaryTreeNode> path, int len) {
		ArrayList<LearnBinaryTreeNode> newPath = new ArrayList<>();
		for(int i=0; i<len; i++) {
			newPath.add(path.get(i));
		}
		paths.add(newPath);
		return paths;
	}
	

	public static void main(String[] args) {
		/*
		 * 
		 * 
		 * 
		 * 				
		 * 										1
		 * 								2				3
		 * 							4		5
		 * 								6		7
		 * 
		 * solution : [1, 2, 4,] [1, 2, 5, 6,] [1, 2, 5, 7,] [1, 3,] 
		 */
		// TODO Auto-generated method stub
		LearnBinaryTree tree = new LearnBinaryTree();
		tree.root = new LearnBinaryTreeNode(1);
		tree.root.left = new LearnBinaryTreeNode(2);
		tree.root.right = new LearnBinaryTreeNode(3);
		tree.root.left.left = new LearnBinaryTreeNode(4);
		tree.root.left.right = new LearnBinaryTreeNode(5);
		tree.root.left.right.left = new LearnBinaryTreeNode(6);
		tree.root.left.right.right = new LearnBinaryTreeNode(7);
		
		
		ArrayList<ArrayList<LearnBinaryTreeNode>> paths = new TreePaths().getTreePaths(tree.root);
		System.out.println("finalPathSize = "   + paths.size());
		
		for(ArrayList<LearnBinaryTreeNode> path : paths) {
			for(LearnBinaryTreeNode node : path) {
				System.out.println(node.data + ", ");
			}
			System.out.println("\n");
		}
		
		
		
		

	}

}

