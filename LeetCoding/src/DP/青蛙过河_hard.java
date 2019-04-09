package DP;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

/**
 * @author czj
 * @date   2019-04-08 17:09
 */
public class 青蛙过河_hard {
	public static void main(String[] args) {
		int[] a = {0,1,3,5,6,8,12,17};
		System.out.println(canCross(a));
	}
	static boolean[] vis = null;
	public static boolean canCross(int[] stones) {
		int n = stones.length;
		if(stones[1] != 1)
			return false;
		vis = new boolean[n+1];
		vis[0] = vis[1] = true;
		
		int[][] dp = new int[n][n];
		boolean res = dfs(1,1,stones,stones[n-1], dp);//当前位置，上一次跳过的单元k,数组,目标位置
		return res;
    }
	private static boolean dfs(int idx, int k, int[] s, int target, int[][] dp) {
		if(s[idx]==target)
			return true;
		if(dp[idx][k] != 0) return dp[idx][k]==1?true:false;
		boolean res = false;
		for(int i=k-1; i<=k+1; i++) {
			int tmp = s[idx] + i;
			int j = idx;
			while(j<s.length && s[j]<tmp && s[j]!=tmp) {
				j++;
			}
			if(j>=s.length || s[j] > tmp)
				continue;
			if(s[j]==tmp && !vis[j]) {
				vis[j] = true;
				res = res || dfs(j,i,s,target,dp);
				vis[j] = false;
			}
		}
		dp[idx][k] = res?1:-1;
		return res;
	}
}
