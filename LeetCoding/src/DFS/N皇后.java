package DFS;

/**
 * @author czj
 * @date   2019-03-30 20:32
 */
public class N皇后 {
	static int cnt = 0;
	public static void main(String[] args) {
		int n = 12;
		int[][] map = new int[n][n];
		dfs(0,map);
		System.out.println(cnt);
	}

	private static void dfs(int idx, int[][] map) {
		if(idx==map.length) {
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}
			System.out.println();
			cnt++;
		}
		for (int i = 0; i < map.length; i++) {
			if(check(map, idx, i)) {
				map[idx][i] = 1;
				dfs(idx+1,map);
				map[idx][i] = 0;
			}
		}
	}
	private static boolean check(int[][] map, int x, int y) {
		for (int i = 0; i < x; i++) {
			int y1 = y+x-i;
			int y2 = y-(x-i);
			if(y1>=0&&y1<map.length) {
				if(map[i][y1]==1)
					return false;
			}
			if(map[i][y]==1)
				return false;
			if(y2>=0&&y2<map.length) {
				if(map[i][y2]==1)
					return false;
			}
		}
		return true;
	}
}
