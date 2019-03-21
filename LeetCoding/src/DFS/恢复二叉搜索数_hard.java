package DFS;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author czj
 * @date   2019-03-21 10:12
 */
public class 恢复二叉搜索数_hard {
	public static void main(String[] args) {
		TreeNode t = new TreeNode(1);
		TreeNode t_l = new TreeNode(3);
		TreeNode t_l_r = new TreeNode(2);
		t.left = t_l;
		t_l.right = t_l_r;
		recoverTree(t);
		System.out.println(t);
	}
	/**思路：一个特别傻逼的解法，但是我没有想到
	 * 		所谓简单的O(n)个空间的思路：
        	中序遍历得到数组，比如[1,3,2,4],在用一个hashmap<int,TreeNode>保存对象.
        	然后对数组排序，得到[1,2,3,4],对比得到2和3两个节点不一样，交换一下值即可。
	 */
	static int[] a = new int[1000];
	static int k = 0;
	static Map<Integer, TreeNode> r = new HashMap<>();
	public static void recoverTree(TreeNode root) {
		Arrays.fill(a, 0);
		k = 0;
		//得到中序遍历结果
		dfs(root);
		int[] b = new int[k];
		for (int i = 0; i < b.length; i++) {
			b[i] = a[i];
		}
		Arrays.sort(a, 0, k);
		//对比两个数组判断要交换的位置
		int idx1 = -1;
		int idx2 = -1;
		for (int i = 0; i < b.length; i++) {
			if(a[i] != b[i]) {
				if(idx1 != -1) {
					idx2 = i;
					break;
				}else {
					idx1 = i;
				}
			}
		}
		int tmp = r.get(idx1).val;
		r.get(idx1).val = r.get(idx2).val;
		r.get(idx2).val = tmp;
    }
	private static void dfs(TreeNode root) {
		if(root==null) return;
		if(root.left != null) {
			dfs(root.left);
		}
		a[k] = root.val;
		r.put(k, root);
		k++;
		if(root.right != null) {
			dfs(root.right);
		}
	}
}
