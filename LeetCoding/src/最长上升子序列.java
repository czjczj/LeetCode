
/**
 * @author czj
 * @date   2019-03-13 09:51
 */
public class 最长上升子序列 {
	public static void main(String[] args) {
		int[] a = {1,3,6,7,9,4,10,5,6};
		int[] dp = new int[a.length];
		int res = f(a.length-1,a,dp);
		System.out.println(dp[a.length-1]);
	}

	/**
	 * 找冗余，同一个递归同一个状态是否会走很多次
	 *递归的方式极难优化，论断是判定
	 */
	private static int f(int idx, int[] a, int[] dp) {
		if(idx<0) return 0;
		if(dp[idx] > 0) return dp[idx];
		int ans = 0;
		for(int i = 0; i < idx; i++) {
			if(a[i]<a[idx]) {
				ans = Math.max(ans, f(i,a,dp));
			}
		}
		dp[idx] = ans+1;
		return ans+1;
	}
	
}
