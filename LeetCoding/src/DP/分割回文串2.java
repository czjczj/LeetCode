package DP;
import java.util.Arrays;

/**
 * @author czj
 * @date   2019-03-04 17:23
 */
public class 分割回文串2 {
	public static void main(String[] args) {
		String a = "aba";
		System.out.println(minCut(a));
		System.out.println(minCut2(a));
		System.out.println(minCut2("abab"));
	}
	/**
	 * 动态规划：
	 * dp[i]表示串s[0...i]分割为回文串的最小分割次数
	 * 定义子串isPar[i][j]（0<=i<=j<=n）为子串s[i...j]是否为回文串，是则True，否则false
	 */
	public static int minCut(String s) {
        char[] a = s.toCharArray();
        int n = a.length;
        int[] dp = new int[n];
        Arrays.fill(dp, n);//初始化每个位置的最小分割次数都为n(这里的n是一个最大情况)
        boolean[][] isPar = new boolean[n][n];
        
        for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				//找到子串s[i...j]是一个回文串的条件:1.a[i]==[j] 2.i-j<=1(此时他们中间只有一个元素)
				//条件2还有一个或者就是isPar[j+1][i-1]记录了为True
				if(a[i]==a[j] && (i-j<=1 || isPar[j+1][i-1])) {
					dp[i] = (j==0)?0:Math.min(dp[j-1]+1, dp[i]);
					isPar[j][i] = true;
				}
			}
		}
        return dp[n-1];
    }
	
	/**
	 * 方法二：
	 * dp[i]仍然表示从s[0....i]的最小分割次数
	 * 但是这次个更新方式为，分别以每一个元素值作为回文字符串的最中间的位置，
	 * 那么即求其作为中心最远可以到达的位置，并在这个过程中不断的更新dp
	 */
	public static int minCut2(String s) {
		char[] a = s.toCharArray();
		int n = a.length;
		int[] dp = new int[n];
		Arrays.fill(dp, n);
		//遍历每一个位置作为字符串中心时候的最长回文串
		for (int i = 0; i < n; i++) {
			update(a,i,i,dp);//回文串的奇数中心
			update(a,i,i+1,dp);//回文串的偶数中心
		}
		return dp[n-1];
	}

	private static void update(char[] a, int i, int j, int[] dp) {
		while(i>=0 && j<dp.length && a[i]==a[j]) {
			dp[j] = Math.min(dp[j], i==0?0:dp[i-1]+1);
			i--;
			j++;
		}
	}
}
