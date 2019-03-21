package Easy;

/**
 * @author czj
 * @date   2019-03-21 14:52
 *  给定两个二叉树，编写一个函数来检验它们是否相同。
	如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 */
public class 相同的树_easy {
	public static void main(String[] args) {
		TreeNode t = new TreeNode(1);
		TreeNode t_l = new TreeNode(2);
		TreeNode t_r = new TreeNode(3);
//		t.left = t_l;
		t.right = t_r;
		
		TreeNode r = new TreeNode(1);
		TreeNode r_l = new TreeNode(2);
		TreeNode r_r = new TreeNode(3);
		r.left = r_l;
		r.right = r_r;
		
		System.out.println(isSameTree(t, r));
	}
	public static boolean isSameTree(TreeNode p, TreeNode q) {
		if(p==null && q==null)
			return true;
		if((p==null&&q!=null) || (p!=null&&q==null))
			return false;
		boolean res = true;
        res = res && isSameTree(p.left, q.left);
        res = res && (p.val==q.val);
        res = res && isSameTree(p.right, q.right);
		return res;
    }
}
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
