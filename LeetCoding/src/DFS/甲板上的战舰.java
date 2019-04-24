package DFS;

/**
 * @author czj
 * @date   2019-04-24 10:10
 */
public class 甲板上的战舰 {
	public static void main(String[] args) {
		char[][] a = {
				{'X','.','.','X'},
				{'.','.','.','X'},
				{'.','.','.','X'}
		};
		System.out.println(countBattleships(a));
	}
	
	/**
	 * 解题思路：
	 * 对于每一个点遍历一遍即可。对于式该位置的点则进项相关的操作，因为题目对应的要求，直接按照相应的方式，
	 * 将相应的方向遍历完全就可以了
	 */
	static int M = 0;
	static int N = 0;
	static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
	public static int countBattleships(char[][] a) {
		M = a.length;
		N = a[0].length;
		int count = 0;
		int[][] sta = new int[M][N];
        for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(a[i][j]=='X' && sta[i][j]==0) {
					count++;
					sta[i][j] = count;
					for (int k = 0; k < dir.length; k++) {
						int ni = i+dir[k][0];
						int nj = j+dir[k][1];
						if(ni<0||ni>=M||nj<0||nj>=N||a[ni][nj]=='.')
							continue;
						int dix = dir[k][0];
						int diy = dir[k][1];
						while(true) {
							if(ni<0||ni>=M||nj<0||nj>=N||a[ni][nj]=='.')
								break;
							sta[ni][nj] = count;
							ni = ni+dix;
							nj = nj+diy;
						}
						break;
					}
				}
			}
		}
		return count;
    }
}
