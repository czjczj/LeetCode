
/**
 * @author czj
 * @date   2019-04-13 14:38
 */
public class 最高的广告牌 {
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6};
		int[] b = {1,2,4,8,16,32,64,128,256,512,50,50,50,150,150,150,100,100,100,123};
		System.out.println();
		System.out.println(tallestBillboard2(a));
		System.out.println(tallestBillboard2(b));
	}
	
	
	static int Max = 0;
	static int sum = 0;
	public static int tallestBillboard(int[] a) {
		if(a.length == 0)
			return 0;
		sum = 0;
        for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}

        dfs(0,0,0,a);
		return Max;
    }
	
	private static void dfs(int idx, int k1, int k2, int[] a) {
		if(k1==k2) {
			Max = Math.max(Max, k1);
		}
		if(idx==a.length || Math.abs(k1-k2)>=sum/2 || k1+k2+sum<=Max*2)
			return;
		
		dfs(idx+1,k1,k2,a);//不加入集合中的任何一个
		dfs(idx+1,k1+a[idx],k2,a);//加入k1这个集合中
		dfs(idx+1,k1,k2+a[idx],a);//加入k2这个集合中
	}
	//正确的解法
	/**
	 *dp[i][j]表示前i个集合中高度差为j的最长公共长度
	 *dp[0][0...max] 为0 
	 *
	 * 对于一个新的长度a[i]的加入，可以分为三种情况
	 * 1.a[i]不加入到当前的两个长度差为j的广告牌中，dp[i][j] = max(dp[i-1][j], dp[i][j]);
	 * 2.a[i](设为h)加入到广告牌长度更长的一个中，那么dp[i][j+h] = max(dp[i-1][j+h],dp[i][j]+h);
	 * 3.a[i](设为h)加入到广告牌长度短的一个中去，那么dp[i][abs(j-h)] = max(dp[i][abs(j-h)],dp[i-1][j]+min(j,h));
	 */
	
	public static int tallestBillboard2(int[] rods) {
		int len = rods.length;
        int[][] dp = new int[len+1][5001];
        for (int i = 0; i < len+1; i++)
            for (int j = 0; j < dp[0].length; j++) dp[i][j] = -5001;
        int sum = 0;
        dp[0][0] = 0;
        for (int i = 1; i <= len; i++) {
            sum += rods[i-1];
            for (int j = 0; j <= sum; j++) {
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j]);
                if (j + rods[i-1] <= sum)
                    dp[i][j+rods[i-1]] = Math.max(dp[i-1][j], dp[i][j+rods[i-1]]);

                dp[i][Math.abs(j-rods[i-1])] = Math.max(dp[i][Math.abs(j-rods[i-1])], dp[i-1][j] + Math.min(j,rods[i-1]));
            }
        }
        return dp[len][0];
    }
}
