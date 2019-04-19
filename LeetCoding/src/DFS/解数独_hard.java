package DFS;

/**
 * @author czj
 * @date   2019-04-17 21:57
 */
public class 解数独_hard {
	public static void main(String[] args) {
		char[][] a = {
				{'5','3','.','.','7','.','.','.','.'},
				{'6','.','.','1','9','5','.','.','.'},
				{'.','9','8','.','.','.','.','6','.'},
				{'8','.','.','.','6','.','.','.','3'},
				{'4','.','.','8','.','3','.','.','1'},
				{'7','.','.','.','2','.','.','.','6'},
				{'.','6','.','.','.','.','2','8','.'},
				{'.','.','.','4','1','9','.','.','5'},
				{'.','.','.','.','8','.','.','7','9'}
		};
		solveSudoku(a);
//		for (int i = 0; i < a.length; i++) {
//			for (int j = 0; j < a.length; j++) {
//				System.out.print(a[i][j]);
//			}
//			System.out.println();
//		}
	}
	static boolean[][] rowUsed = new boolean[9][10];//这个数字 行 中是否使用了
	static boolean[][] colUsed = new boolean[9][10];//这个数字 列 中是否使用了
	static boolean[][] blockUsed = new boolean[9][10];//这个数字行中是否使用了
	
	static char[][] res = null;
	public static void solveSudoku(char[][] a) {
		res = new char[9][9];
        for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if(a[i][j] != '.') {
					int num = Integer.parseInt(a[i][j]+"");
					rowUsed[i][num] = true;
					colUsed[j][num] = true;
					blockUsed[i/3*3+j/3][num] = true;
				}
				res[i][j] = a[i][j];
			}
		}
        
        dfs(0,0,res,a);
    }
	private static void dfs(int x, int y, char[][] a, char[][] res) {
		if(x==9 && y==0) {
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a.length; j++) {
					res[i][j] = a[i][j];
					System.out.print(a[i][j]);
				}
				System.out.println();
			}
			System.out.println();
			return;
		}
		if(a[x][y] != '.') {
			if(y==8) {
				dfs(x+1,0,a,res);
			}else {
				dfs(x,y+1,a,res);
			}
		}else {
			for (int k = 1; k <= 9; k++) {
				if(rowUsed[x][k] || colUsed[y][k] || blockUsed[x/3*3+y/3][k])
					continue;
				else {
					a[x][y] = (char) ('0' + k);
					rowUsed[x][k] = true;
					colUsed[y][k]= true;
					blockUsed[x/3*3+y/3][k]= true;
					if(y==8) {
						dfs(x+1,0,a,res);
					}else{
						dfs(x,y+1,a,res);
					}
					rowUsed[x][k] = false;
					colUsed[y][k]= false;
					blockUsed[x/3*3+y/3][k]= false;
					a[x][y] = '.';//这里如果并进行（仅仅这一行代码，可能会出现问题），因为在下一个for循环的时候
					//并不会讲a[x][y]重新复制，而是直接跳出该循环，这个时候再次进来的时候，a[][]改变了，但是理论上这里
					//应该回溯了
				}
			}
		}
	}
}
