package DFS;
import java.util.Arrays;

/**
 * @author czj
 * @date   2019-04-25 16:37
 * 给定一个 m × n 的网格和一个球。球的起始坐标为 (i,j) ，你可以将球移到相邻的单元格内，
 * 或者往上、下、左、右四个方向上移动使球穿过网格边界。但是，你最多可以移动 N 次。找出可以
 * 将球移出边界的路径数量。答案可能非常大，返回 结果 mod 109 + 7 的值。
 */
public class 出界的路径数 {
	public static void main(String[] args) {
		System.out.println(findPaths(2, 2, 2, 0, 0));
		System.out.println(findPaths(1, 3, 3, 0, 1));
	}
	
	/**
	 * dfs+记忆化，这里记忆化数组dp[i][j][step]表示当我的坐标位置为(i,j)点的时候
	 * 剩余step步时，我能够去的位置的剩余步骤为多少
	 * 注意这里dp数组初始化为-1，而不能初始化为0，当初始化为0的时候，可能会TLE,因为dp[][][]=0是有意义的
	 * 这种情况下，该位置经过step步骤是不能够移动到外边去的，一开始我就是卡在这里导致了自己一直显示TLE
	 */
	static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
	static int M = 0;
	static int N = 0;
	static int[][][] dp = null;
	public static int findPaths(int m, int n, int step, int i, int j) {
		M = m;
		N = n;
		dp = new int[M][N][step+1];
		for (int o = 0; o < M; o++) {
			for (int p = 0; p < N; p++) {
				Arrays.fill(dp[o][p], -1);
			}
		}
		return dfs(i,j,step);
    }
	private static int dfs(int i, int j, int step) {
		if(i<0||i>=M||j<0||j>=N)
			return 1;
		if(step<=0)
			return 0;
		if(dp[i][j][step] != -1)
			return dp[i][j][step];
		int res = 0;
		for (int k = 0; k < dir.length; k++) {
			int ni = dir[k][0] + i;
			int nj = dir[k][1] + j;
			res += dfs(ni,nj,step-1);
			res %= 1000000007;
		}
		dp[i][j][step] = res;
		dp[M-i-1][N-j-1][step] = res;
		return res;
	}
}