package DP;

/**
 * @author czj
 * @date   2019-04-12 13:04
 * 	在二维地图上， 0代表海洋， 1代表陆地，我们最多只能将一格 0 海洋变成 1变成陆地。
	进行填海之后，地图上最大的岛屿面积是多少？（上、下、左、右四个方向相连的 1 可形成岛屿）
	示例 1:
	输入: [[1, 0], [0, 1]]
	输出: 3
	解释: 将一格0变成1，最终连通两个小岛得到面积为 3 的岛屿。
 */
public class 最大人工岛_hard {
	public static void main(String[] args) {
		int[][] a = {
				{1, 1, 0}, 
				{1, 0, 1},
				{1, 0, 1},
		};
		int[][] b = {
				{1, 0}, 
				{0, 1},
		};
		int[][] c = {
				{1}, 
		};
		System.out.println(largestIsland(c));
		System.out.println(largestIsland(b));
		System.out.println(largestIsland(a));
	}
	//做一遍啊dfs,计算有多少个陆地分块，并记录每个陆地的面积于count[2...k]数组中，count[2]表示2号陆地的面积，做一遍循环分别统计
	//当每一个位置变为0后的情况就可以了，记录该a[i][j]==0的区域上下左右位置的陆地，相加就可以得到结果
	static int[] dix = {1,-1,0,0};
	static int[] diy = {0,0,1,-1};
	static int n = 0;
	public static int largestIsland(int[][] a) {
		n = a.length;
		int num = 2;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(a[i][j] == 1) {
					dfs(i,j,num,a);
					num++;
				}
			}
		}
		int[] count = new int[num];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 2; k < count.length; k++) {
					if(a[i][j] == k)
						count[k]++;
				}
			}
		}
		
		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(a[i][j] == 0) {
					int sum = 0;
					boolean[] isUsed = new boolean[num];
					for (int k = 0; k < dix.length; k++) {
						int nx = i+dix[k];
						int ny = j+diy[k];
						if(nx>=0&&nx<n&&ny>=0&&ny<n&&!isUsed[a[nx][ny]]) {
							sum += count[a[nx][ny]];
							isUsed[a[nx][ny]] = true;
						}
					}
					sum += 1;
					max = Math.max(max, sum);
				}
			}
		}
		for (int i = 2; i < count.length; i++) {
			max = Math.max(max, count[i]);
		}
		return max;
    }
	private static void dfs(int x, int y, int num, int[][] a) {
		a[x][y] = num;
		for (int i = 0; i < dix.length; i++) {
			int nx = x + dix[i];
			int ny = y + diy[i];
			if(nx>=0&&nx<n&&ny>=0&&ny<n&&a[nx][ny]==1)
				dfs(nx,ny, num, a);
		}
	}
}
