package DP;
import java.util.HashMap;
import java.util.Map;

/**
 * @author czj
 * @date   2019-03-13 12:22
 */
public class 打家劫舍3 {
	static Map<TreeNode, Integer> trueDp = new HashMap<>();
	static Map<TreeNode, Integer> falseDp = new HashMap<>();
	public static void main(String[] args) {
		
	}
	public static int rob(TreeNode root) {
        int res = robot(root,true);
		return res;
    }
	/**
	 */
	private static int robot(TreeNode root, boolean canRob) {
		if(root == null)
			return 0;
		int res = 0;
		if(canRob) {
			int tmp = 0;
			if(trueDp.containsKey(root)) {
				tmp = trueDp.get(root);
			}else {
				tmp = root.val+robot(root.left, false)+robot(root.right, false);
				trueDp.put(root, tmp);
			}
			res = Math.max(res, tmp);
		}
		int tmp = 0;
		if(falseDp.containsKey(root)) {
			return Math.max(res, falseDp.get(root));
		}else {
			tmp = robot(root.left, true)+robot(root.right, true);
			falseDp.put(root, tmp);
		}
		return Math.max(res, tmp);
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}