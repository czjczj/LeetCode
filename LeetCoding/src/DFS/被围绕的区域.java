package DFS;

/**
 * @author czj
 * @date   2019-04-15 09:13
 */
public class 被围绕的区域 {
	public static void main(String[] args) {
		char[][] a = {
				{'X', 'X', 'X', 'X'},
				{'X', 'O', 'O', 'X'},
				{'X', 'X', 'O', 'X'},
				{'X', 'O', 'X', 'X'},
		};
		
		char[][] b = {
				{'O','X','X','O','X'},
				{'X','O','O','X','O'},
				{'X','O','X','O','X'},
				{'O','X','O','O','O'},
				{'X','X','O','X','O'},
		};
		char[][] c = {
			{'O','X','O','O','O','O','O','O','O'},
			{'O','O','O','X','O','O','O','O','X'},
			{'O','X','O','X','O','O','O','O','X'},
			{'O','O','O','O','X','O','O','O','O'},
			{'X','O','O','O','O','O','O','O','X'},
			{'X','X','O','O','X','O','X','O','X'},
			{'O','O','O','X','O','O','O','O','O'},
			{'O','O','O','X','O','O','O','O','O'},
			{'O','O','O','O','O','X','X','O','O'}
		};
		solve(c);
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(c[i][j]);
			}
			System.out.println();
		}
	}
	/**
	 * 思路：从边缘是"O"的位置进行dfs，不断更新与其靠近且结果是"O"的位置，在这个过程中
	 * 保存boolean类型的res数组得到最后的结果
	 */
	static int M = 0;
	static int N = 0;
	static boolean[][] res = null;
	static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
	public static void solve(char[][] a) {
		if(a.length == 0)
			return;
		M = a.length;
		N = a[0].length;
		res = new boolean[M][N];
		
		boolean[][] vis = new boolean[M][N];
		if(M==1 || N==1)
			return;
        for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(a[i][j] == 'X') {
					res[i][j] = false;
					continue;
				}
				res[i][j] = true;
			}
		}
        
        for(int i=0; i<N; i++) {
        	if(a[0][i]=='O' && res[0][i]) {
        		dfs(0,i,a,vis);
        	}
        	if(a[M-1][i]=='O' && res[M-1][i]) {
        		dfs(M-1,i,a,vis);
        	}
        }
        for(int i=1; i<M-1; i++) {
        	if(a[i][0]=='O' && res[i][0]) {
        		dfs(i,0,a,vis);
        	}
        	if(a[i][N-1]=='O' && res[i][N-1]) {
        		dfs(i,N-1,a,vis);
        	}
        }
        for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(res[i][j]) {
					a[i][j] = 'X';
				}
			}
		}
    }
	private static void dfs(int x, int y, char[][] a, boolean[][] vis) {
		vis[x][y] = true;
		res[x][y] = false;
		for (int k = 0; k < dir.length; k++) {
			int nx = x + dir[k][0];
			int ny = y + dir[k][1];
			if(nx<0||nx>=M||ny<0||ny>=N||a[nx][ny]=='X'||vis[nx][ny]||!res[nx][ny])
				continue;
			dfs(nx,ny,a,vis);
		}
		vis[x][y] = false;
	}
}
