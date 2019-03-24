package BFS;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/**
 * @author czj
 * @date   2019-03-24 10:36
	 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
	 * 例如:
	给定二叉树: [3,9,20,null,null,15,7],
	
	    3
	   / \
	  9  20
	    /  \
	   15   7
 */
public class 二叉树的层次遍历 {
	public static void main(String[] args) {
		
	}
	static class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	public static List<List<Integer>> levelOrder(TreeNode root) {
		if(root == null) return new ArrayList<>();
        List<List<Integer>> ls = new ArrayList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<Integer> tls = new ArrayList<>();
        Queue<TreeNode> tq = new LinkedList<>();
        while(!q.isEmpty()) {
        	TreeNode p = q.poll();
        	tls.add(p.val);
        	if(p.left != null) {
        		tq.add(p.left);
        	}
        	if(p.right != null) {
        		tq.add(p.right);
        	}
        	if(q.isEmpty()) {
        		ls.add(tls);
        		tls = new ArrayList<>();
        		q = tq;
        		tq = new LinkedList<>();
        	}
        }
		return ls;
    }
}


