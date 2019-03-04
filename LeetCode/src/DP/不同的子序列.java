package DP;

/**
 * @author czj
 * @date   2019��3��2��
 * ����һ���ַ��� S ��һ���ַ��� T�������� S ���������� T ���ֵĸ�����
      һ���ַ�����һ����������ָ��ͨ��ɾ��һЩ��Ҳ���Բ�ɾ�����ַ��Ҳ�����ʣ���ַ����λ������ɵ����ַ�����
      �����磬"ACE" �� "ABCDE" ��һ�������У��� "AEC" ���ǣ�
 */
public class 不同的子序列 {
	static int count = 0;
	public static void main(String[] args) {
		String s = "rabbbit";
		String t = "rabbit";
		System.out.println(numDistinct2(s, t));
		System.out.println(numDistinct2("babgbag", "bag"));
	}
	public static int numDistinct(String s, String t) {
        int ans = dfs(s.toCharArray(),t.toCharArray(),0,0);
		return ans;
    }
	/**
	 * ���ֵݹ鷽���ᳬʱ
	 */
	private static int dfs(char[] s, char[] t, int ids, int idt) {
		if(idt==t.length) return 1;
		if(ids >= s.length || idt >= t.length) return 0;
		
		int res = 0;
		while(ids < s.length && s[ids] != t[idt])
			ids++;
		if(ids < s.length) {
			res += dfs(s,t,ids+1,idt+1);
			res += dfs(s,t,ids+1,idt);
		}
		return res;
	}
	
	/**
	 * DP˼��
	 * dp[i][j] ��ʾ��s[i...len]��������t[j...len]�ĸ���
	 * ��ô���s[i]==t[j]  dp[i][j] = dp[i+1][j+1]
	 * 	    ���� s[i]!=t[j]  dp[i][j] = dp[i+1][j]
	 */
	public static int numDistinct2(String s, String t) {
		int m = s.length();
		int n = t.length();
		int[][] dp = new int[m][n];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				dp[i][j] = -1;
			}
		}
		int ans = dfs2(s.toCharArray(),t.toCharArray(),0,0,dp);
		return ans;
	}
	private static int dfs2(char[] s, char[] t, int i, int j, int[][] dp) {
		if(j==t.length) return 1;
		if(i >= s.length) return 0;
		if(dp[i][j] != -1) return dp[i][j];
		int res = 0;
		if(s[i] == t[j])
			res += dfs2(s,t,i+1,j+1,dp);
		res += dfs2(s,t,i+1,j,dp);
		dp[i][j] = res;
		return res;
	}
}
