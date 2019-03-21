package DFS;
/**
 * @author czj
 * @date   2019-03-21 12:05
 */
public class 从中序与后序遍历序列构造二叉树 {
	public static void main(String[] args) {
		int[] i = {9,3,15,20,7};
		int[] p = {9,15,7,20,3};
		TreeNode res = buildTree(i, p);
		show(res);
	}
	private static void show(TreeNode res) {
		if(res.left != null) {
			show(res.left);
		}
		System.out.print(res.val + " ");
		if(res.right != null) {
			show(res.right);
		}
	}
	/**
	 * 思路等同与 “从前序与中序遍历构造二叉树”
	 */
	public static TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode t = dfs(postorder.length-1,inorder,postorder,0,inorder.length-1);
		return t;
    }
	private static TreeNode dfs(int index, int[] ior, int[] por, int l, int r) {
		if(l==r) {
			return new TreeNode(ior[l]);
		}
		TreeNode t = null;
		for (int i = index; i >= 0; i--) {
			int idx = getIndex(l,r,ior,por[i]);
			if(idx != -1) {
				t = new TreeNode(por[i]);//将当前元素作为根节点；
				t.left = dfs(i-1, ior, por, l, idx-1);
				t.right = dfs(i-1, ior, por, idx+1, r);
				break;
			}
		}
		return t;
	}
	private static int getIndex(int l, int r, int[] ior, int val) {
		for (int j = l; j <= r; j++) {
			if(ior[j] == val)
				return j;
		}
		return -1;
	}
}
