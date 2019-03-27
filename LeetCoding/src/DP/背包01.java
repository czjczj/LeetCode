package DP;

/**
 * @author czj
 * @date   2019-03-27 15:20
 */
public class 背包01 {
	static int[] w = {2,3,4};
	static int[] v = {3,5,7};
	static int max = 7;
	public static void main(String[] args) {
		int[][] dp = new int[w.length][max+1];
//		int res = solve(w.length-1,max,dp);
		
		for (int wei = 0; wei <= max; wei++) {
			if(w[0] <= wei) {
				dp[0][wei] = v[0];
			}
		}
		for(int idx=1; idx<w.length; idx++) {
			for (int wei = 0; wei <= max; wei++) {
				int res = 0;
				if(wei >= w[idx]) {
					res = Math.max(res, dp[idx-1][wei-w[idx]]+v[idx]);
				}
				res = Math.max(res, dp[idx-1][wei]);
				dp[idx][wei] = res;
			}
		}
		for (int i = 0; i < w.length; i++) {
			for (int j = 0; j <= max; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println(dp[w.length-1][max]);
	}
//	private static int solve(int idx, int max, int[][] dp) {
//		if(max < 0 || idx < 0)
//			return 0;
//		if(dp[idx][max] > 0) return dp[idx][max];
//		int res = 0;
//		if(max >= w[idx]) {
//			res = Math.max(res, solve(idx-1,max-w[idx],dp)+v[idx]);
//		}
//		res = Math.max(res, solve(idx-1,max,dp));
//		dp[idx][max] = res;
//		return res;
//	}
}
