package DFS;
import java.util.Arrays;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

/**
 * @author czj
 * @date   2019-03-05 11:03
 * 	给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 * 	输入: [2,3,-2,4]
	输出: 6
	解释: 子数组 [2,3] 有最大乘积 6。
 */
public class 乘机最大子序列 {
	public static void main(String[] args) {
		System.out.println(maxProduct2(new int[] {2,3,-2,4}));
		System.out.println(maxProduct2(new int[] {-2}));
		System.out.println(maxProduct2(new int[] {0,2}));
	}
	
	/**
	 * DP
	 * 思想：dp[i]表示前i个数字中最大的子序列乘机，maxm表示以第i-1个字符结尾的连续序列的最大乘积，minm表示以
	 * 第i-1个字符结尾的的连续序列最小乘积，那么
	 * dp[i] = max(maxm*nums[i],minm*nums[i],dp[i-1])
	 * 
	 * maxm,minm在执行的过程中不断的更新，则
	 * maxm = max(maxm*nums[i], minm*nums[i], nums[i])
	 * minm = min(maxm*nums[i], minm*nums[i], nums[i])
	 */
	public static int maxProduct(int[] a) {
		int n = a.length;
		int[] dp = new int[n];
		int maxm = a[0];
		int minm = a[0];
		dp[0] = a[0];
		for (int i = 1; i < a.length; i++) {
			dp[i] = Math.max(maxm*a[i]>minm*a[i]?maxm*a[i]:minm*a[i],i-1>=0?dp[i-1]:Integer.MIN_VALUE);
			maxm = Math.max(maxm*a[i]>minm*a[i]?maxm*a[i]:minm*a[i], a[i]);
			minm = Math.min(maxm*a[i]<minm*a[i]?maxm*a[i]:minm*a[i], a[i]);
		}
		return dp[n-1];
	}
	
	public static int maxProduct2(int[] a) {
		int res = a[0];
		int n = a.length;
		int[] maxed = new int[n];
		int[] mined = new int[n];
		for (int i = 0; i < n; i++) {
			maxed[i] = Math.max(a[i],i>0?Math.max(a[i]*maxed[i-1], a[i]*mined[i-1]):a[i]);
			mined[i] = Math.min(a[i],i>0?Math.min(a[i]*maxed[i-1], a[i]*mined[i-1]):a[i]);
		}
		
		for (int i = 1; i < n; i++) {
			res = Math.max(res, maxed[i]);
		}
		return res;
	}
}

