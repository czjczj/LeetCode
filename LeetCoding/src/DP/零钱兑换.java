package DP;
import java.util.Arrays;

/**
 * @author czj
 * @date   2019-03-27 16:47
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * 输入: coins = [1, 2, 5], amount = 11
	输出: 3 
	解释: 11 = 5 + 5 + 1
 */
public class 零钱兑换 {
	public static void main(String[] args) {
		int[] coins = {370,417,408,156,143,434,168,83,177,280,117};
		int amount = 9953;
		System.out.println(coinChange(coins, amount));
	}
	public static int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[][] dp = new int[coins.length][amount+1];
//        int res = solve(coins.length-1, coins, amount, dp);
        
     
        
        for (int i = 1; i <= amount; i++) {
        	if(i%coins[0]==0)
        		dp[0][i] = i/coins[0];
        	else
        		dp[0][i] = 1000;
		}
        dp[0][0] = 0;
        for(int idx = 1; idx < coins.length; idx++) {
        	dp[idx][0] = 0;
        	for (int j = 1; j <= amount; j++) {
        		int res = Integer.MAX_VALUE;
        		for(int nums = 0; nums <= amount/coins[idx]; nums++) {
        			if(j-nums*coins[idx]>=0) {
        				res = Math.min(dp[idx-1][j-nums*coins[idx]]+nums, res);
        			}
        		}
        		dp[idx][j] = res;
			}
        }
		return dp[coins.length-1][amount]==1000?-1:dp[coins.length-1][amount];
    }
	private static int solve(int idx, int[] coins, int amount, int[][] dp) {
		if(idx < 0) {
			if(amount == 0)
				return 0;
			else 
				return 1000;
		}
		if(amount < 0)
			return 1000;
		if(dp[idx][amount] > 0) return dp[idx][amount];
		int res = Integer.MAX_VALUE;
		for(int nums = 0; nums <= amount/coins[idx]; nums++) {
			res = Math.min(solve(idx-1, coins, amount-nums*coins[idx], dp) + nums, res);
		}
		dp[idx][amount] = res;
		return res;
	}
}
