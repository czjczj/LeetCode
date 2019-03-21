package Easy;
/**
 * @author czj
 * @date   2019-03-21 16:18
 *      	给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
	说明: 叶子节点是指没有子节点的节点。
	给定如下二叉树，以及目标和 sum = 22，

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
	返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 */
public class 路径总和_easy {
	public static void main(String[] args) {
		TreeNode t = new TreeNode(-2);
		TreeNode t_r = new TreeNode(-3);
		t.right = t_r;
		System.out.println(hasPathSum(t,-5));
	}
	public static boolean hasPathSum(TreeNode root, int sum) {
		if(root == null)
			return false;
		if(root.left == null && root.right == null) {
			return sum-root.val==0;
		}
		boolean res = false;
		if(root.left != null) {
			res = res || hasPathSum(root.left, sum-root.val);
		}
		if(root.right != null) {
			res = res || hasPathSum(root.right, sum-root.val);
		}
		return res;
    }
}
