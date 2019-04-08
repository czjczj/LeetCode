package DP;

/**
 * @author czj
 * @date   2019-04-08 15:39
 */
public class 整数拆分 {
	public static void main(String[] args) {
		System.out.println(integerBreak(2));
	}
	public static int integerBreak(int n) {
		int[] dp = new int[n+1];
		int res = get(n, dp);
		return res;
    }
	//最重要的一行代码 res = Math.max(res, Math.max(i*get(n-i,dp),i*(n-i)));
	private static int get(int n, int[] dp) {
		if(n == 1)
			return 1;
		if(dp[n] != 0) return dp[n];
		int res = 1;
		for (int i = 1; i < n; i++) {
			res = Math.max(res, Math.max(i*get(n-i,dp),i*(n-i)));
		}
		dp[n] = res;
		return res;
	}
}
