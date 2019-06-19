package Easy;
import java.util.Arrays;

/**
 * @author czj
 @date   2019-05-29 09:52
 在一个大小在 (0, 0) 到 (N-1, N-1) 的2D网格 grid 中，除了在 mines 中给出的单元为 0，其他每个单元都是 1。
网格中包含 1 的最大的轴对齐加号标志是多少阶？返回加号标志的阶数。如果未找到加号标志，则返回 0。
一个 k" 阶由 1 组成的“轴对称”加号标志具有中心网格  grid[x][y] = 1 ，以及4个从中心向上、向下、向左
、向右延伸，长度为 k-1，由 1 组成的臂。下面给出 k" 阶“轴对称”加号标志的示例。注意，只有加号标志的所有网格
要求为 1，别的网格可能为 0 也可能为 1。

输入: N = 5, mines = [[4, 2]]
输出: 2
解释:
11111
11111
11111
11111
11011

整数N 的范围： [1, 500].
mines 的最大长度为 5000.
mines[i] 是长度为2的由2个 [0, N-1] 中的数组成.
(另外,使用 C, C++, 或者 C# 编程将以稍小的时间限制进行​​判断.)

链接：https://leetcode-cn.com/problems/largest-plus-sign
 */
public class 最大加号标志 {
	public static void main(String[] args) {
		int n = 5;
		int[][] mines = {{4,2}};
		System.out.print(orderOfLargestPlusSign(n, mines));
	}
	/**
	 * 解答思路：遍历每一个坐标点(i,j) ， 并将其向上下左右移动，左右得到
	 * 该点的k为多少，  最终更新maxK并返回
	 */
	static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
	static int N;
	public static int orderOfLargestPlusSign(int n, int[][] mines) {
		N = n;
	    int[][] mat = new int[N][N];
	    for(int i = 0; i < N; i++)
	    	Arrays.fill(mat[i], 1);    
	    for(int i = 0; i < mines.length; i++) {
	    	int x = mines[i][0];
	    	int y = mines[i][1];
	    	mat[x][y] = 0;
	    }
	    int maxK = 0;
	    for(int i = 0; i < N; i++) {
	    	for(int j = 0; j < N; j++) {
	    		if(mat[i][j] == 1) {
	    			int res = 1;
	    			while(isOk(i,j,res,mat))
	    				res += 1;
	    			maxK = Math.max(maxK, res);
	    		}
	    	}
	    }
		return maxK;
	}

	private static boolean isOk(int i, int j, int k, int[][] mines) {
		return (i-k>=0) && (i+k<N) && (j-k>=0) && (j+k<N)
				&& (mines[i-k][j]==1) && (mines[i+k][j]==1) && (mines[i][j-k]==1)
				&& (mines[i][j+k]==1);
	}
}
