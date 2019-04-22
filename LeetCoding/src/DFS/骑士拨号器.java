package DFS;

/**
 * @author czj
 * @date   2019-04-22 21:01
 */
public class 骑士拨号器 {
	
	public static void main(String[] args) {
		System.out.println(knightDialer(161));
	}
	static boolean[][] vis = null;
	static int[][] dir = {{1,-2},{1,2},{-1,-2},{-1,2},{2,1},{2,-1},{-2,1},{-2,-1}};
	static int n = 0;
	public static int knightDialer(int N) {
		n = N;
        vis = new boolean[4][3];
        vis[3][0] = true;
        vis[3][2] = true;//这两个坐标不能够访问
        
        int[][][] dp = new int[4][3][N];
        
        int sum = 0;
        for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				if(!vis[i][j]) {
					sum += dfs(i,j,0,dp);
					sum %= 1000000007;
				}
			}
		}
		return sum;
    }
	private static int dfs(int x, int y, int idx, int[][][] dp) {
		if(idx == n-1)
			return 1;
		
		if(dp[x][y][idx] != 0) return dp[x][y][idx];
		
		int res = 0;
		for (int i = 0; i < dir.length; i++) {
			int nx = x+dir[i][0];
			int ny = y+dir[i][1];
			if(nx<0||nx>=4||ny<0||ny>=3||vis[nx][ny])
				continue;
			res += dfs(nx,ny,idx+1,dp);
			res %= 1000000007;
		}
		
		dp[x][y][idx] = res;
		return res;
	}
}
