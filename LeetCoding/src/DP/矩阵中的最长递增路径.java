package DP;

/**
 * @author czj
 * @date   2019-03-13 11:13
 */
public class 矩阵中的最长递增路径 {
	public static void main(String[] args) {
		int[][] a = {
				{9,9,4},
				{6,6,8},
				{2,1,1}
		};
		int[][] b = {
				{3,4,5},
				{3,2,6},
				{2,2,1}
		};
		
		System.out.println(longestIncreasingPath(b));
	}
	
	public static int longestIncreasingPath(int[][] a) {
		if(a.length == 0)
			return 0;
		int[][] dp = new int[a.length][a[0].length];//初始化dp，并赋值为0
		int res = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				int ans = 0;
				for (int k = 0; k < dirx.length; k++) {
					int ni = dirx[k] + i;
					int nj = diry[k] + j;
					if(ni>=0&&ni<a.length&&nj>=0&&nj<a[0].length&&a[ni][nj]>a[i][j]) {
						ans = Math.max(ans, dp[ni][nj]);
					}
				}
				dp[i][j] = ans+1;
				res = Math.max(res, ans+1);
			}
		}
		return res;
    }
	/**
	 * 
	 */
	static int[] dirx = {1,-1,0,0};
	static int[] diry = {0,0,1,-1};
	private static int robot(int i, int j, int[][] a, int[][] dp) {
		if(dp[i][j] > 0) return dp[i][j];
		int ans = 0;
		for (int k = 0; k < dirx.length; k++) {
			int ni = dirx[k] + i;
			int nj = diry[k] + j;
			if(ni>=0&&ni<a.length&&nj>=0&&nj<a[0].length&&a[ni][nj]>a[i][j]) {
				ans = Math.max(ans, robot(ni, nj, a, dp));
			}
		}
		dp[i][j] = ans+1;
		return ans+1;
	}
}
