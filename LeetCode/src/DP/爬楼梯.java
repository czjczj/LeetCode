package DP;

/**
 * @author czj
 * @date   2019��2��25��
 * ������������¥�ݡ���Ҫ n ������ܵ���¥����
	ÿ��������� 1 �� 2 ��̨�ס����ж����ֲ�ͬ�ķ�����������¥���أ�
	dp[i] ��ʾ��į���ߵ�¥���Ĳ�ͬ�߷�  
 */
public class 爬楼梯 {
	public static void main(String[] args) {
		System.out.println(climbStairs(2));
	}
	public static int climbStairs(int n) {
	    int[] dp = new int[n];
	    for (int i = 0; i < dp.length; i++) {
			dp[i] = -1;
		}
	    int res = dfs(dp,0,n);
		return res;
	}
	private static int dfs(int[] dp, int i, int n) {
		if(i == n) return 1;
		if(i > n) return 0;
		if(dp[i] != -1) return dp[i];
		int ans = 0;
		ans += dfs(dp,i+1,n);
		ans += dfs(dp,i+2,n);
		dp[i] = ans;
		return ans;
	}
}
