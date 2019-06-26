package DataStructure;
import java.util.Arrays;

/**
 * @author czj
 * @date   2019-06-25 09:15
 * 	爱丽丝和鲍勃一起玩游戏，他们轮流行动。爱丽丝先手开局。
	最初，黑板上有一个数字 N 。在每个玩家的回合，玩家需要执行以下操作：
	选出任一 x，满足 0 < x < N 且 N % x == 0 。
	用 N - x 替换黑板上的数字 N 。
	如果玩家无法执行这些操作，就会输掉游戏。
	只有在爱丽丝在游戏中取得胜利时才返回 True，否则返回 false。假设两个玩家都以最佳状态参与游戏。
	示例 1：
	输入：2
	输出：true
	解释：爱丽丝选择 1，鲍勃无法进行操作。
	示例 2：
	输入：3
	输出：false
	解释：爱丽丝选择 1，鲍勃也选择 1，然后爱丽丝无法进行操作。
	
	链接：https://leetcode-cn.com/problems/divisor-game
 */
public class 除数博弈 {
	public static void main(String[] args) {
		System.out.println(divisorGame(100));
	}
	public static boolean divisorGame(int N) {
		int[][] dp = new int[N+1][2];
		for(int i=0; i<=N; i++)
			Arrays.fill(dp[i], -1);
		return f(N,0,dp);
    }
	private static boolean f(int n, int name, int[][] dp) {
		if(dp[n][name] != -1)
			return dp[n][name]==1?true:false;
		boolean f = false;
        for(int i=1; i<n; i++) {
        	if(n%i==0 && !f(n-i,name^1,dp))
        		f = true;
        }
        dp[n][name]=(f?1:0);
		return f;
	}
}
