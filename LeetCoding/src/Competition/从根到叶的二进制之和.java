package Competition;

/**
 * @author czj
 * @date   2019-04-07 15:23
 * 给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。
 * 例如，如果路径为 0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。
对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。
以 10^9 + 7 为模，返回这些数字之和。
输入：[1,0,1,0,1,0,1]
输出：22
解释：(100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
 */
public class 从根到叶的二进制之和 {
	public static void main(String[] args) {
		TreeNode t = new TreeNode(1);
		TreeNode t21 = new TreeNode(0);
		TreeNode t22 = new TreeNode(1);
		TreeNode t31 = new TreeNode(0);
		TreeNode t32 = new TreeNode(1);
		TreeNode t33 = new TreeNode(0);
		TreeNode t34 = new TreeNode(1);
		t.left = t21;
		t.right = t22;
		t21.left = t31;
		t21.right = t32;
		t22.left = t33;
		t22.right = t34;
		System.out.println(sumRootToLeaf(t));
	}
	static int sum;
	public static int sumRootToLeaf(TreeNode root) {
		sum = 0;
        get(root,"");
		return sum;
    }
	private static void get(TreeNode root,String res) {
		if(root.left == null && root.right == null) {
			sum += getRadix(res+root.val);
			sum %= (Math.pow(10, 9)+7);
			return;
		}
		if(root.left != null) {
			get(root.left,new String(res+root.val));
		}
		if(root.right != null) {
			get(root.right,new String(res+root.val));	
		}
	}
	private static long getRadix(String res) {
		long a = 0;
		for (int i = 0; i < res.length(); i++) {
			a = a*2+Integer.parseInt(res.charAt(i)+"");
			a %= Math.pow(10, 9)+7;
		}
		return a;
	}
	static class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
}
