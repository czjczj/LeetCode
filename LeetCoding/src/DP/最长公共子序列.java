package DP;

/**
 * @author czj
 * @date   2019-03-27 17:54
 */
public class 最长公共子序列 {
	public static void main(String[] args) {
		String a = "ABCBDABA";
		String b = "BDCABAA";
		int[][] dp = new int[a.length()+1][b.length()+1];
//		int res = solve(a,b,a.length()-1,b.length()-1,dp);
		//这里的初始条件变为了dp[0][0...n]为0  可以此时理解a字符串为空串 
		//dp[0...n][0]为0
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[i].length; j++) {
				int res = 0;
				int ca = a.charAt(i-1);
				int cb = b.charAt(j-1);
				
				if(ca == cb) {
					res = Math.max(res, dp[i-1][j-1]+1);
				}else {
					res = Math.max(res, dp[i-1][j]);
					res = Math.max(res, dp[i][j-1]);
					res = Math.max(res, dp[i-1][j-1]);
				}
				dp[i][j] = res;
			}
		}
		
		System.out.println(dp[a.length()][b.length()]);
	}

	private static int solve(String a, String b, int i, int j, int[][] dp) {
		if(i<0 || j<0)
			return 0;
		if(dp[i][j] > 0) return dp[i][j];
		int res = 0;
		int ca = a.charAt(i);
		int cb = b.charAt(j);
		
		if(ca == cb) {
			res = Math.max(res, solve(a.substring(0, i), b.substring(0, j), i-1, j-1,dp)+1);
		}else {
			res = Math.max(res, solve(a.substring(0, i), b, i-1, j,dp));
			res = Math.max(res, solve(a, b.substring(0, j), i, j-1,dp));
			res = Math.max(res, solve(a.substring(0, i), b.substring(0, j), i-1, j-1,dp));
		}
		dp[i][j] = res;
		return res;
	}
}
