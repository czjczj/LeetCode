package DP;

/**
 * @author czj
 * @date   2019��2��21��
 */
public class 数位DP_HDU4734 {
	static int[] a = new int[20];
	static int[][] dp;
	public static void main(String[] args) {
		int A = 4;
		int B = 13;
		dp = new int[20][f(A)];
		for(int i=0; i<dp.length; i++) {
			for(int j=0; j<dp[0].length; j++) {
				dp[i][j] = -1;
			}
		}         
		System.out.println(f(A));
		System.out.println(solve(B,A));
	}
	
	
	private static int solve(int x, int A) {
		int p = 0;
		while(x != 0) {
			a[p++] = x%10;
			x /= 10;
		}
		return dfs(p-1,f(A),true,true);
	}
	
	private static int dfs(int pos, int state, boolean lead, boolean limit) {
		if(pos == -1 && state > 0) return 1;
		if(!limit && !lead && dp[pos][state] != -1) return dp[pos][state];
		int up = limit?a[pos]:9;
		int tmp = 0;
		for(int i=0; i<=up; i++) {
			int res = (int) (i*Math.pow(2, pos));
			if(state-res <= 0) continue;
			tmp += dfs(pos-1,state-res,lead&&i==0,limit&&i==a[pos]);
		}
		if(!limit && !lead) tmp = dp[pos][state];
		return tmp;
	}


	private static int f(int x) {
		int n = 0;
		int sum = 0;
		while(x != 0) {
			sum += x%10 * Math.pow(2, n);
			x /= 10;
			n++;
		}
		
		return sum;
	}
}
