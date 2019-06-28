package DP;

/**
 * @author czj
 * @date   2019-06-27 09:58
 */
public class 猜数字大小2 {
	public static void main(String[] args) {
		System.out.println(getMoneyAmount(10));
	}
	/*
	 * 极小极大化问题：
	 * dp[i][j] 表示计算 在数组 i到j的范围内才对的最小花费
	 * 1. dp[i][i] = 0;  当数字范围只有一个的时候花费为0
	 * 2. dp[i][j] = min(max(dp[i][x-1]+x,x+dp[x+1][j]))
	 * 在2的情况下，表示在x这位置没有才对，然后继续猜
	 */
	public static int getMoneyAmount(int n) {
        int[][] dp = new int[n+1][n+1];
        for(int i=0; i<=n; i++) {
        	dp[i][i] = 0;
        }
        for(int i=1; i<=n-1; i++) {
        	for(int j=1; j<=n-i; j++) {//范围[j, j+i]
        		if(i==1) {
        			dp[j][j+i] = Math.min(j+i, j);
        		}else {
        			int min = Integer.MAX_VALUE;
            		for(int x=j+1; x<=j+i-1; x++) {
            			min = Math.min(min, Math.max(dp[j][x-1]+x, dp[x+1][j+i]+x));
            		}
            		dp[j][j+i] = min;
        		}
        	}
        }
		return dp[1][n];
    }
}
