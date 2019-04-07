package Tree;
import java.util.Arrays;

/**
 * @author czj
 * @date   2019-03-19 15:27
	返回与给定先序遍历 preorder 相匹配的二叉搜索树（binary search tree）的根结点。
	(回想一下，二叉搜索树是二叉树的一种，其每个节点都满足以下规则，对于 node.left 的任何后代，值总 < node.val，而 node.right 的任何后代，
	值总 > node.val。此外，先序遍历首先显示节点的值，然后遍历 node.left，接着遍历 node.right。）
 */
public class 先序遍历构造二叉树 {
	public static void main(String[] args) {
		int[] preorder = {8,5,1,7,10,12};
		TreeNode t = bstFromPreorder(preorder);
		show(t);
	}
	private static void show(TreeNode t) {
		if(t==null)
			return;
		show(t.left);
		show(t.right);
		System.out.println(t.val);
	}

	//解题思路：二叉搜索树的中序遍历结果是一个有序数组
	public static TreeNode bstFromPreorder(int[] preorder) {
		int[] midorder = new int[preorder.length];
		for (int i = 0; i < midorder.length; i++) {
			midorder[i] = preorder[i];
		}
		Arrays.sort(midorder);
//		for (int i = 0; i < midorder.length; i++) {
//			System.out.print(midorder[i] + " ");
//		}
		TreeNode t = solve(0,0,preorder.length-1,preorder,midorder);
		return t;
    }
	private static TreeNode solve(int idx, int l, int r, int[] pre, int[] mid) {
		if(l>r)
			return null;
		TreeNode res = null;
		boolean flag = false;
		for(int j=idx; j<pre.length; j++) {
			for(int i=l; i<=r; i++) {
				if(mid[i]==pre[j]) {
					res = new TreeNode(pre[j]);
					res.left = solve(j+1, l, i-1, pre, mid);
					res.right = solve(j+1, i+1, r, pre, mid);
					flag = true;
					break;
				}
			}
			if(flag)
				break;
		}
		return res;
	}

	static class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
}
