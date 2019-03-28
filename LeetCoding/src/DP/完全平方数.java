package DP;

/**
 * @author czj
 * @date   2019-03-28 14:11
 */
public class 完全平方数 {
	public static void main(String[] args) {
		System.out.println(numSquares(288));
	}
	public static int numSquares(int n) {
        int[] a = new int[1000];
        int m = 0;
        for (int i = 1; i < a.length; i++) {
        	if(i*i <= n) {
        		a[m++] = i*i;
        		continue;
        	}
        	break;
        }
        int[][] dp = new int[m][n+1];
//        int res = solve(k-1,a,n,dp);
        
        for (int i = 0; i <= n; i++) {
			if(i%a[0]==0) {
				dp[0][i] = i/a[0];
			}else {
				dp[0][i] = 1000;
			}
		}
        for(int k = 1; k < m; k++) {
        	for(int i = 0; i<=n; i++) {
        		int res = Integer.MAX_VALUE;
        		if(i-a[k]>=0)
        			res = Math.min(res, dp[k][i-a[k]]+1);
        		res = Math.min(res, dp[k-1][i]);
        		dp[k][i] = res;
        	}
        }
        
        int res = dp[m-1][n];
		return res==1000?-1:res;
    }
	private static int solve(int k, int[] a, int n, int[][] dp) {
		if(n == 0)
			return 0;
		if(k<0 || n<0)
			return 1000;
		if(dp[k][n] > 0) return dp[k][n];
		int res = Integer.MAX_VALUE;
		res = Math.min(res, solve(k,a,n-a[k],dp)+1);
		res = Math.min(res, solve(k-1,a,n,dp));
		dp[k][n] = res;
		return res;
	}
}
