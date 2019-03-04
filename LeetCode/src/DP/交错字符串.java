package DP;

/**
 * @author czj
 * @date   2019��3��2��
 */
public class 交错字符串 {
	public static void main(String[] args) {
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbcbcac";
		System.out.println(isInterleave2(s1, s2, s3));
		System.out.println(isInterleave2("aabcc", "dbbca", "aadbbbaccc"));
		System.out.println(isInterleave2("aa", "bb", "aabb"));
	}
	//�ݹ飬���������ַ���Ч���ã�������ʱ
	public static boolean isInterleave(String s1, String s2, String s3) {
		if(s1.length() + s2.length() != s3.length()) return false;
		if(s1.length()==0 || s2.length()==0) return s3.equals(s2) || s3.equals(s1);
		
        boolean res = false;
        if(s1.substring(0, 1).equals(s3.substring(0, 1))) {
        	res = res || isInterleave(s1.substring(1), s2, s3.substring(1));
        }
        if(s2.substring(0, 1).equals(s3.substring(0, 1))) {
        	res = res || isInterleave(s1, s2.substring(1), s3.substring(1));
        }
        return res;
	}
	
	/**
	 * dp���仯����
	 * ˼·��dp[i][j][k] ��ʾ���ַ��� s1�±�i����β���Ӵ���s2�±�j����β���Ӵ����Ƿ��ܹ�����Ϊs3�±�k����β���Ӵ�
	 * ��ʼ��dpÿ��Ԫ��λ-1, �������ܹ�����Ϊ�Ӵ��� dp[][][]Ϊ1������Ϊ0
	 * 
	 * ����Ԫ�رȽϣ����s1[i]==s3[k]  �ݹ�����Ϊs1[i+1]��s2, s3[k+1]
	 *            ���s2[j]==s3[k]  �ݹ�����Ϊs1,s2[j+1],s3[k+1]
	 * ��֦����Ϊ��1.���s1,s2�ĳ��ȺͲ�������s3,ֱ�ӷ���false
	 * 			2.���s1����s2��ĳһ��Ԫ�ر�������β����ʱΪ�մ���ֱ���ж�ʣ��һ��Ԫ��(s1,s2)����s3(��Ҫ) 
	 */
	public static boolean isInterleave2(String s1, String s2, String s3) {
		int[][][] dp = new int[s1.length()][s2.length()][s3.length()];//s1,s2,s3������±�Ϊs1.length()-1, s2.length()-1, s3.length()-1
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				for (int k = 0; k < dp[0][0].length; k++) {
					dp[i][j][k] = -1;
				}
			}
		}
		boolean res = dfs(s1,s2,s3,dp,0,0,0);
		return res;
	}
	private static boolean dfs(String s1, String s2, String s3, int[][][] dp, int i, int j, int k) {
		if(s1.substring(i).length() + s2.substring(j).length() != s3.substring(k).length()) return false;
		if(s1.substring(i).length()==0 || s2.substring(j).length()==0) 
			return s3.substring(k).equals(s2.substring(j)) || s3.substring(k).equals(s1.substring(i));
		if(dp[i][j][k] != -1) return dp[i][j][k]==1?true:false;
		boolean res = false;
		if(s1.substring(i, i+1).equals(s3.substring(k, k+1))) {
			res = res || dfs(s1, s2, s3, dp, i+1, j, k+1);
		}
		if(s2.substring(j, j+1).equals(s3.substring(k, k+1))) {
			res = res || dfs(s1, s2, s3, dp, i, j+1, k+1);
		}
		dp[i][j][k] = res?1:0;
		return res;
	}
}
