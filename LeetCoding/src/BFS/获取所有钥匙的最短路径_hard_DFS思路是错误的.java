package BFS;

/**
 * @author czj
 * @date   2019-03-22 08:47
 *       给定一个二维网格 grid。 "." 代表一个空房间， "#" 代表一堵墙， "@" 是起点，（"a", "b", ...）代表钥匙，（"A", "B", ...）代表锁。
	我们从起点开始出发，一次移动是指向四个基本方向之一行走一个单位空间。我们不能在网格外面行走，也无法穿过一堵墙。
	如果途经一个钥匙，我们就把它捡起来。除非我们手里有对应的钥匙，否则无法通过锁。
	假设 K 为钥匙/锁的个数，且满足 1 <= K <= 6，字母表中的前 K 个字母在网格中都有自己对应的一个小写和一个大写字母。
	换言之，每个锁有唯一对应的钥匙，每个钥匙也有唯一对应的锁。另外，代表钥匙和锁的字母互为大小写并按字母顺序排列。
	返回获取所有钥匙所需要的移动的最少次数。如果无法获取所有钥匙，返回 -1 。
	示例 1：
	输入：["@.a.#","###.#","b.A.B"]
	@.a.#
	###.#
	b.A.B  8
	
	@..aA
	..B#.
	....b  6
 */
public class 获取所有钥匙的最短路径_hard_DFS思路是错误的 {
	public static void main(String[] args) {
		String[] s = {"@.a.#","###.#","b.A.B"};
		String[] ss = {"@..aA","..B#.","....b"};
		System.out.println(shortestPathAllKeys(s));
		System.out.println(shortestPathAllKeys(new String[] {".@aA"}));
		System.out.println(shortestPathAllKeys(new String[] {"@Aa"}));
		System.out.println(shortestPathAllKeys(new String[] {"@...a",".###A","b.BCc"}));
		
	}
	static boolean[] isGet = null;
	static int k;
	
	static int m;	//m行n列
	static int n;
	
	static int[] dix = {0,1,0,-1};
	static int[] diy = {1,0,-1,0};
	
	static int minStep;
	static boolean[][] isVis = null;
	public static int shortestPathAllKeys(String[] grid) {
		m = grid.length;
		n = grid[0].toCharArray().length;
		char[][] c = new char[m][n];
		isVis = new boolean[m][n];
		for (int i = 0; i < grid.length; i++) {
			c[i] = grid[i].toCharArray();
		}
		//遍历一遍数组，查看钥匙的个数
		k = 0;
		int ax = 0;//确定@坐标
		int ay = 0;
		
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c[i].length; j++) {
				int t = c[i][j] - 'a';
				if(t>=0 && t<6)
					k++;
				if(c[i][j]=='@') {
					ax = i;
					ay = j;
				}
			}
		}
		isGet = new boolean[k];
		minStep = 1000;
		//isVis[ax][ay] = true;
		dfs(ax,ay,c,0,0);
		return minStep==1000?-1:minStep;
    }
	/**
	@.a.#
	###.#
	b.A.B  8
	
	
	@...a
	.###A
	b.BCc
	*/
	private static void dfs(int x, int y,char[][] c,int step, int keyNum) {
		if(keyNum == k) {
			minStep = Math.min(step, minStep);
			return;
		}
		for (int i = 0; i < dix.length; i++) {
			int nx = x+dix[i];
			int ny = y+diy[i];
			if(check(nx,ny,c) && !isVis[nx][ny]) {
				isVis[nx][ny] = true;
				int t = c[nx][ny] - 'a';
				if(t>=0 && t<6 && !isGet[t]) {
					isGet[t] = true;
					dfs(nx,ny,c, step+1, keyNum+1);
				}else {
					dfs(nx,ny,c, step+1, keyNum);
				}
				isVis[nx][ny] = false;
			}
		}
	}
	
	private static boolean check(int nx, int ny, char[][] c) {
		boolean res = true;
		res = res && (nx>=0&&nx<m&&ny>=0&&ny<n&&c[nx][ny]!='#');
		if(res && c[nx][ny] != '.' && c[nx][ny] !='@') {
			int t = c[nx][ny] - 'A';
			if(t>=0 && t<6) {
				res = res && isGet[t]; 
			}
		}
		return res;
	}
}
