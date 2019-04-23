package DFS;
import java.util.ArrayList;
import java.util.List;

/**
 * @author czj
 * @date   2019-04-22 22:05
 */
public class 太平洋大西洋水流问题 {
	public static void main(String[] args) {
		int[][] a = {
				{1,2,2,3,5},
				{3,2,3,4,4},
				{2,4,5,3,1},
				{6,7,1,4,5},
				{5,1,1,2,4}
		};
		int[][] b = {
				{3,3,3,3,3,3},{3,0,3,3,0,3},{3,3,3,3,3,3}
		};
		pacificAtlantic(b);
	}
	static int M = 0;
	static int N = 0;
	static List<int[]> ls = null;
	static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
	/*
	 * 解题思路：对于每一个位置，使用一个状态压缩数组 00 表示，如果这个点可以到达大西洋则为01，如果可以达到太平洋
	 * 则为10，两者都可以到达的话则为11，初始化对于矩阵边缘的元素进行赋值，然后对于每一个点与其周围的遍历，如果改点高于周围某个点
	 * 则更新当前点为该店可以到的位置和某点可以到的位置（或操作）。否则的话更新某点为相应的情况，如果两个高度相等，则相互更新
	 * 重复此操作，直到没有点再更新为止
	 */
	
	public static List<int[]> pacificAtlantic(int[][] a) {
		if(a.length==0)
			return new ArrayList<>();
		M = a.length;
		N = a[0].length;
		ls = new ArrayList<>();
		
		int[][] status = new int[M][N];
		
		//能够到 太 加2^1,  能够到 西 加2^0
		for (int i = 0; i < M; i++) {
			status[i][0] = status[i][0]|2;//第一列每一个元素都可以到 太
			status[i][N-1] = status[i][N-1]|1;//最后一列每一个元素都可以到 西
		}
		for (int i = 0; i < N; i++) {
			status[0][i] = status[0][i]|2;//第一列每一个元素都可以到 太
			status[M-1][i] = status[M-1][i]|1;//最后一列每一个元素都可以到 西
		}
		while(true) {
			boolean flag = false;
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					for (int k = 0; k < dir.length; k++) {
						int ni = i+dir[k][0];
						int nj = j+dir[k][1];
						if(ni<0||ni>=M||nj<0||nj>=N)
							continue;
						
						int t1 = status[ni][nj];
						int t2 = status[i][j];
						if(a[i][j]==a[ni][nj]) {
	                        status[ni][nj] = status[ni][nj]|status[i][j]; 
	                        status[i][j] = status[ni][nj]|status[i][j]; 
	                        if(t1!=status[ni][nj] || t2!=status[i][j]){
	                        	flag = true;
	                        }
	                    }else if(a[i][j]<a[ni][nj]){
	                        status[ni][nj] = status[ni][nj]|status[i][j]; 
	                        if(t1!=status[ni][nj]){
	                        	flag = true;
	                        }
	                    }else{
	                        status[i][j] = status[ni][nj]|status[i][j]; 
	                        if(t2!=status[i][j]){
	                        	flag = true;
	                        }
	                    }
					}
				}
			}
			if(!flag)
				break;
			
		}
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(status[i][j] == 3) {
					ls.add(new int[] {i,j});
					System.out.println(i+","+j);
				}
			}
		}
//		for (int i = 0; i < M; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(status[i][j]+" ");
//			}
//			System.out.println();
//		}
        return ls;
    }
	static class Status{
		int i;
		int j;
		boolean tai;
		boolean xi;
		public Status(int i, int j, boolean tai, boolean xi) {
			this.i = i;
			this.j = j;
			this.tai = tai;
			this.xi = xi;
		}
	}
}
