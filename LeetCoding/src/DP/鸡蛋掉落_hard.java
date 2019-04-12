package DP;

/**
 * @author czj
 * @date   2019-04-11 13:08
 */
public class 鸡蛋掉落_hard {
	public static void main(String[] args) {
		System.out.println(superEggDrop2(2, 4));
		System.out.println(superEggDrop3(1, 2));
	}
	
	
	/*争取的解题思路
	 * 	dp[k][m] 的含义是k个鸡蛋 移动m次最多能够确定多少楼层
		这个角度思考
		dp[k][m] 最多能够确定的楼层数为L
		那么我选定第一个扔的楼层之后，我要么碎，要么不碎
		这就是把L分成3段
		左边是碎的那段 长度是dp[k][m - 1]
		右边是没碎的那段 长度是dp[k-1][m - 1] 因为已经碎了一个了
		中间是我选定扔的楼层 是1
		所以递推公式是
		dp[k][m] = dp[k - 1][m - 1] + dp[k][m - 1] + 1
		且dp[0][0...m] = 0 //0个鸡蛋可以确定0层
		  dp[0...k][0]  //一直不移动一次肯定也是无法确定楼层的
	 * */
	public static int superEggDrop2(int K, int N) {
		int[] dp = new int[K+1];
        for(int i=0;i<=K;i++)
            dp[i]=0;
        int r=0;
        while(dp[K]<N+1){
            for(int i=K;i>0;i--)
                dp[i]+=dp[i-1]+1;
            r++;
        }
        return r;
    }
	//正确解法的非简化版本
	public static int superEggDrop3(int k, int N) {
		int[][] dp = new int[k+1][1000];
		for (int i = 0; i <= k; i++) {
			dp[i][0] = 0;
		}
		for (int i = 0; i < dp[0].length; i++) {
			dp[0][i] = 0;
		}
		for (int i = 1; i <= k; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				dp[i][j] = dp[i-1][j-1] + dp[i][j-1] + 1; 
			}
		}
        for(int i = 0; i<dp[0].length; i++){
            for(int j=0; j<=k; j++){
                if(dp[j][i] >= N)
                    return i;
            }
        }
		return -1;
    }
	
	static boolean[] isUsed = null;
	static int max = 0;
	//错误的解法
	public static int superEggDrop(int K, int N) {
		max = 0;
		if(K==1)
			return N;
        f(0,N-1,K,0);
		return max;
    }
	private static void f(int l, int r, int num, int cnt) {
		if(l>r) {
			max = Math.max(max, cnt);
			return;
		}
		if(num == 1) {
			max = Math.max(max, cnt+r-l+1);
			return;
		}
		int L = l;
		int R = r;
		
		int mid = (L+R)/2;
		
		f(mid+1,r,num,cnt+1);//没有碎了的话
		f(l,mid-1,num-1,cnt+1);//碎了的话
	}
}
