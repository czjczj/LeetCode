package DFS;

/**
 * @author czj
 * @date   2019-03-21 10:40
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
	注意:
	你可以假设树中没有重复的元素。
	例如，给出
	前序遍历 preorder = [3,9,20,15,7]
	中序遍历 inorder = [9,3,15,20,7]
 */
public class 从前序与中序遍历序列构造二叉树 {
	public static void main(String[] args) {
		int[] p = {3,9,20,15,7};
		int[] i = {9,3,15,20,7};
		TreeNode res = buildTree(p, i);
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
	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		TreeNode t = dfs(0, preorder, inorder, 0, inorder.length-1);
		return t;
    }
	/**
	 * 思路：思路很重要这道题目他妈的做了一个小时才做出来，刚开始就是思路没有搞清楚就开始瞎写（划重点）
	 * 在中序遍历的序列中在区间（l,r）[初始的时候范围为（0,inorder.length）]寻找需要的index的值，直到找到一个index
	 * 然后将该index作为根节点将中序列分为(l,index-1)和(index+1,r),同样的方式在（l,index-1）和（index+1,r)的返回结果
	 * 为index根节点的左右子树，然后在左右区间内部继续寻找需要的值，进行递归
	 */
	private static TreeNode dfs(int index, int[] preorder, int[] inorder, int l, int r) {
		if(l==r) {
			return new TreeNode(inorder[l]);
		}
		TreeNode t = null;
		for (int i = index; i < preorder.length; i++) {
			int idx = getIndex(inorder, l, r, preorder[i]);
			if(idx != -1) {
				t = new TreeNode(preorder[i]);
				t.left = dfs(i+1, preorder, inorder, l, idx-1);
				t.right = dfs(i+1, preorder, inorder, idx+1, r);
				break;
			}
		}
		return t;
	}
	

	private static int getIndex(int[] inorder, int l, int r, int val) {
		for (int i = l; i <= r; i++) {
			if(inorder[i] == val)
				return i;
		}
		return -1;
	}
}
//class TreeNode {
//	 int val;
//	 TreeNode left;
//	 TreeNode right;
//	 TreeNode(int x) { val = x; }
//}
