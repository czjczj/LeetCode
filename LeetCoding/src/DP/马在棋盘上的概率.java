package DP;

/**
 * @author czj
 * @date   2019-04-10 08:39
 */
public class 马在棋盘上的概率 {
	public static void main(String[] args) {
		System.out.println(knightProbability(3, 2, 0, 0));
		System.out.println(knightProbability(8, 30, 6, 4));
	}
	static int dix[] = {1,1,-1,-1,2,2,-2,-2};
	static int diy[] = {2,-2,-2,2,1,-1,-1,1};
	static int k = 0;
	static int n = 0;
	public static double knightProbability(int N, int K, int x, int y) {
		k = K;
		n = N;
		double[][][] dp = new double[k][n][n];
		double prob = dfs(x,y,0,dp); 
		return prob;
	}
	private static double dfs(int x, int y, int idx, double[][][] dp) {
		if(idx == k)
			return 1;
		if(Math.abs(dp[idx][x][y])>0) return dp[idx][x][y];
		double prob = 0;
		int count = 0;
		for (int m = 0; m < dix.length; m++) {
			int nx = x+dix[m];
			int ny = y+diy[m];
			if(check(nx,ny))
				count++;
		}
//		double curProb = 1.0*count/8;
		for (int m = 0; m < dix.length; m++) {
			int nx = x+dix[m];
			int ny = y+diy[m];
			if(check(nx,ny))
				prob += dfs(nx,ny,idx+1,dp)/8.0;
		}
		dp[idx][x][y] = prob;
		return prob;
	}
	private static boolean check(int nx, int ny) {
		return nx>=0&&nx<n&&ny>=0&&ny<n;
	}
}
