package DP;

/**
 * @author czj
 * @date   2019-03-27 20:11
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后
 * 一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
	给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
	示例 1:
	输入: [2,3,2]
	输出: 3
	解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 */
public class 打家劫舍2_代码还是需要优化 {
	public static void main(String[] args) {
		int[] a = {2,7,9,3,1};
		System.out.println(rob(a));
	}
	
	//这个代码写的跟个垃圾一样
	static int f = 0;
	public static int rob(int[] nums) {
		int len = nums.length;
		int[][][] dp = new int[nums.length][2][2];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[i].length; j++) {
				for (int k = 0; k < dp[i][j].length; k++) {
					dp[i][j][k] = -1;
				}
			}
		}
        int res = solve(len-1,1,nums,dp);
		return res;
    }
	private static int solve(int idx, int flag, int[] a, int[][][] dp) {
		if(idx == 0) {
			if(flag == 1) {
				if(f==1)
					return 0;
				else
					return a[idx];
			}
			return 0;
		}
		if(idx<0)
			return 0;
		if(dp[idx][flag][f] >= 0)
			return dp[idx][flag][f];
		int res = 0;
		if(flag==1) {
			if(idx==a.length-1) {
				f= 1;
				res = Math.max(res, solve(idx-1, 0, a, dp) + a[idx]);
				f = 0;
			}else {
				res = Math.max(res, solve(idx-1, 0, a, dp) + a[idx]);
			}
		}
		
		res = Math.max(res, solve(idx-1,1,a,dp));
		dp[idx][flag][f] =res;
		return res;
	}
}
