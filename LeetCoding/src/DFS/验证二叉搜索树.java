package DFS;
import java.util.Arrays;


/**
 * @author czj
 * @date   2019-03-21 09:11
 * 假设一个二叉搜索树具有如下特征：
节点的左子树只包含小于当前节点的数。
节点的右子树只包含大于当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。
 */
public class 验证二叉搜索树 {
	public static void main(String[] args) {
		TreeNode t = new TreeNode(0);
//		t.left = new TreeNode(-1);
//		t.right = new TreeNode(3);
		System.out.println(isValidBST(t));
	}
	/**
	 * 思路：中序遍历二叉搜索树为一个递增的序列
	 */
	static int[] a = new int[100000];
	static int k = 0;
	public static boolean isValidBST(TreeNode root) {
		Arrays.fill(a, 0);
        if(root==null) return true;
		dfs(root);
		for (int i = 1; i < k; i++) {
			if(a[i] < a[i-1]) {
				return false;
			}
		}
		return true;
    }
	private static void dfs(TreeNode root) {
		if(root==null) {
			return;
		}
		if(root.left != null) {
			dfs(root.left);
		}
		a[k++] = root.val;
		if(root.right != null) {
			dfs(root.right);
		}
	}
}
/* 更加巧妙的解法
double last = -Double.MAX_VALUE;
public boolean isValidBST(TreeNode root) {
    if (root == null) {
        return true;
    }
    if (isValidBST(root.left)) {
        if (last < root.val) {
            last = root.val;
            return isValidBST(root.right);
        }
    }
    return false;
}
 */
//已在其他文件定义
class TreeNode {
	 int val;
	 TreeNode left;
	 TreeNode right;
	 TreeNode(int x) { val = x; }
}