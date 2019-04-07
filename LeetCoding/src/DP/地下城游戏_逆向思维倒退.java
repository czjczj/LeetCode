package DP;
import java.util.Arrays;

/**
 * @author czj
 * @date   2019-03-12 10:58
 */
public class 地下城游戏_逆向思维倒退 {
	public static void main(String[] args) {
		int[][] a = {
				{-2,-3,3},	
				{-5,-10,1},
				{10,30,-5}
		};
		System.out.println(calculateMinimumHP(a));
	}
	/**
	 * dp[i][j]表示从点（i，j）走到右下角P所需要的最小初始健康值，（这里很巧妙，如果将dp[i][j]表示为从（0,0）到（i，j）则
	 *     这道题目将变得很难做，）
	 * 这里采用后退的方式，dp[i][j] = Math.min(dp[i+1][j]-a[i][j], dp[i][j+1]-a[i][j])
	 * 
	 * 注意：很重要的一点，如果计算到某个位置dp[i][j] 为负数，说明此位置到结尾是没有生命值的消耗的，这个时候只需要初始化为1就可以了。
	 */
	public static int calculateMinimumHP(int[][] dungeon) {
		int m = dungeon.length;
        int n = dungeon[0].length;
        int dp[][] = new int[m][n];
        dp[m-1][n-1] = dungeon[m-1][n-1] < 0 ? -1 * dungeon[m-1][n-1] + 1 : 1;
        for(int i=m-2;i>=0;i--){
            dp[i][n-1] = Math.max(dp[i+1][n-1] - dungeon[i][n-1],1);
        }
        for(int i=n-2;i>=0;i--){
            dp[m-1][i] = Math.max(dp[m-1][i+1] - dungeon[m-1][i],1);
        }
        for(int i = m-2;i >= 0;i--){
            for(int j = n-2;j >= 0;j--){
                int tempMin = Math.min(dp[i][j+1]-dungeon[i][j],dp[i+1][j]-dungeon[i][j]);
                dp[i][j] = Math.max(1, tempMin);
            }
        }
        return dp[0][0];
    }
}
