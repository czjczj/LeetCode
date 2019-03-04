package DP;

import java.util.ArrayList;
import java.util.List;

/**
 * @author czj
 * @date   2019��3��1��
 */
public class 不同的二叉搜索树2 {
	public static void main(String[] args) {
		List<TreeNode> a = generateTrees(3);
		System.out.println(a);
	}
	
	public static List<TreeNode> generateTrees(int n) {
        if(n < 1) return new ArrayList<>();
        List[][] dp = new List[n+2][n+2];
        
		return generateTrees(1,n,dp);
    }

	/**
	 */
	private static List<TreeNode> generateTrees(int start, int end, List[][] dp) {
		List<TreeNode> res = new ArrayList<>();
		if(end < start) {
			res.add(null);
			return res;
		}
		//ѭ���жϸ��ڵ��λ�����ģ�Ȼ��ݹ�Ĺ�������������������
		for(int i=start; i<=end; i++) {
			List<TreeNode> list1 = dp[start][i-1];
			if(list1 == null) {
				list1 = generateTrees(start, i-1, dp);
				dp[start][i-1] = list1;
			}
			//�ԣ�start,i-1��Ϊ��������������ͬ�����������
			for(TreeNode left:list1) {
				List<TreeNode> list2 = dp[i+1][end];
				if(list2 == null) {
					list2 = generateTrees(i+1, end, dp);
					dp[i+1][end] = list2;
				}
				
				for (TreeNode right:list2) {
					TreeNode root = new TreeNode(i);
					root.left = left;
					root.right = right;
					res.add(root);
				}
			}
		}
		return res;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}