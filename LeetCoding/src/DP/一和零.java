package DP;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author czj
 * @date   2019-04-09 12:02
	 * 在计算机界中，我们总是追求用有限的资源获取最大的收益。
	现在，假设你分别支配着 m 个 0 和 n 个 1。另外，还有一个仅包含 0 和 1 字符串的数组。
	你的任务是使用给定的 m 个 0 和 n 个 1 ，找到能拼出存在于数组中的字符串的最大数量。每个 0 和 1 至多被使用一次。
	注意:
	给定 0 和 1 的数量都不会超过 100。
	给定字符串数组的长度不会超过 600。
	示例 1:
	输入: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
	输出: 4
	解释: 总共 4 个字符串可以通过 5 个 0 和 3 个 1 拼出，即 "10","0001","1","0" 。
 */
public class 一和零 {
	public static void main(String[] args) {
		String[] a = {"10", "0001", "111001", "1", "0"};
		System.out.println(findMaxForm2(a, 5, 3));
		System.out.println(findMaxForm2(new String[]{"10", "0", "1"}, 1, 3));
	}
	public static int findMaxForm(String[] a, int m, int n) {
		Arrays.sort(a, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.length()-o2.length();
			}
		});
		int[][][] dp = new int[a.length][m+1][n+1];
		int cnt = dfs(0,a,m,n,dp);
		return cnt;
    }
	private static int dfs(int idx, String[] a, int m, int n, int[][][] dp) {
		if(idx>=a.length)
			return 0;
		if(dp[idx][m][n] != 0) return dp[idx][m][n];
		int res = 0;
		res = Math.max(res, dfs(idx+1,a,m,n,dp));
		int[] t = get(a[idx]);
		if(m>=t[0] && n>=t[1])
			res = Math.max(res, dfs(idx+1,a,m-t[0],n-t[1], dp)+1);
		dp[idx][m][n] = res;
		return res;
	}
	private static int[] get(String a) {
		int[] res = new int[2];
		for (int i = 0; i < a.length(); i++) {
			if(a.charAt(i) == '0')
				res[0]++;
			else 
				res[1]++;
		}
		return res;
	}
	
	//改成非递推的模式 dp[i][j][k]表示在a[i]位置下，当还有j个0和k个1的情况下可以得到最大组合数个数
	public static int findMaxForm2(String[] a, int m, int n) {
		Arrays.sort(a, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.length()-o2.length();
			}
		});
		int[][][] dp = new int[a.length+1][m+1][n+1];
		
		dp[a.length][0][0] = 0;
		for(int i=a.length-1; i>=0; i--) {
			dp[i][0][0] = 0;
			for (int j = 0; j <= m; j++) {
				for (int k = 0; k <= n; k++) {
					int res = 0;
					res = Math.max(res, dp[i+1][j][k]);//dfs(idx+1,a,m,n,dp)
					int[] t = get(a[i]);
					if(j>=t[0] && k>=t[1])
						res = Math.max(res, dp[i+1][j-t[0]][k-t[1]]+1);//dfs(idx+1,a,m-t[0],n-t[1], dp)+1
					dp[i][j][k] = res;
				}
			}
		}
		return dp[0][m][n];
    }
}
