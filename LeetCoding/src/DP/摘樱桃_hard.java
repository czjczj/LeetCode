package DP;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author czj
 * @date   2019-06-22 08:22
一个N x N的网格(grid) 代表了一块樱桃地，每个格子由以下三种数字的一种来表示：

0 表示这个格子是空的，所以你可以穿过它。
1 表示这个格子里装着一个樱桃，你可以摘到樱桃然后穿过它。
-1 表示这个格子里有荆棘，挡着你的路。
你的任务是在遵守下列规则的情况下，尽可能的摘到最多樱桃：

从位置 (0, 0) 出发，最后到达 (N-1, N-1) ，只能向下或向右走，并且只能穿越有效的格子（即只可以穿过值为0或者1的格子）；
当到达 (N-1, N-1) 后，你要继续走，直到返回到 (0, 0) ，只能向上或向左走，并且只能穿越有效的格子；
当你经过一个格子且这个格子包含一个樱桃时，你将摘到樱桃并且这个格子会变成空的（值变为0）；
如果在 (0, 0) 和 (N-1, N-1) 之间不存在一条可经过的路径，则没有任何一个樱桃能被摘到。
示例 1:

输入: grid =
[[0, 1, -1],
 [1, 0, -1],
 [1, 1,  1]]
输出: 5
解释： 
玩家从（0,0）点出发，经过了向下走，向下走，向右走，向右走，到达了点(2, 2)。
在这趟单程中，总共摘到了4颗樱桃，矩阵变成了[[0,1,-1],[0,0,-1],[0,0,0]]。
接着，这名玩家向左走，向上走，向上走，向左走，返回了起始点，又摘到了1颗樱桃。
在旅程中，总共摘到了5颗樱桃，这是可以摘到的最大值了。
说明:

grid 是一个 N * N 的二维数组，N的取值范围是1 <= N <= 50。
每一个 grid[i][j] 都是集合 {-1, 0, 1}其中的一个数。
可以保证起点 grid[0][0] 和终点 grid[N-1][N-1] 的值都不会是 -1。

链接：https://leetcode-cn.com/problems/cherry-pickup
 */
public class 摘樱桃_hard {
	public static void main(String[] args) {
		int[][] grid = {{0, 1, -1},
				        {1, 0, -1},
				        {1, 1,  1}};
		System.out.println(cherryPickup(grid));
	}
	static int N = 0;
	static int maxSum = 0;
	public static int cherryPickup(int[][] a) {
		maxSum = 0;
		N = a.length;
		int S = 2*N-1;
		int[][][] dp = new int[S+1][N][N];
		for(int i=0; i<S; i++)
			for(int j=0; j<N; j++)
				Arrays.fill(dp[i][j],2);
		dp[S-1][N-1][N-1] = a[N-1][N-1];		
		int res = f(0,0,0,a,dp);
		return res==-1?0:res;
    }

	/*
	 * 思路：这道题目加深对于，动态规划类型题目的思考，做这道题目花了几个小时（我太菜了）
	 * 将题目转化为两个人同时从（0，0）到（N-1,N-1）这个点的距离，这样转化的原因是，题目要求要进行一次往返的操作
	 * 那么问题就可以转化为两个人同时走，并且每一时刻也就各自的只能 想下 or 向右移动一次，当两个人移动到相同的位置的
	 * 时候，如果改位置由殷桃，那么只数据只加一次。
	 * 能够想到的是 dp[x1][y1][x2][y2] 我们保存这个状态（x1,y1）,(x2,y2)分别表示当前的两个人的位置，那么
	 * 初始化dp[N-1][N-1][N-1][N-1]=a[N-1][N-1]  那么这个样子以后，
	 * 1. 为什么要有动态规划，举一个粒子
	 * 假设当前 x1,y1,x2,y2 分别为（0,0,0,0）--> (0,1,0,1)-->(1,1,1,1)
	 * 然后另外一次移动                          （0,0,0,0）--> (1,0,0,1)-->(1,1,1,1)
	 * 可以看到从（0,0,0,0）-->经过一些点--->(1,1,1,1)  其实这里就存在了冗余，因为作为一个dfs操作，我们
	 * 不保存状态（1,1，1,1）的情况下，这个状态会被计算两次。
	 * 
	 * 2.自己出现的问题，导致自己在这个题目上一直没有AC的原因，自己对于当前状态的理解不深刻，自己在计算 每一步骤都的 sum的时候
	 * 出现了终止条件（这个问题对应的就是在（v1==-1 && v2==-1 && v3==-1 && v4==-1），这里我直接进行了 return -1）,然后
	 * 导致该状态下dp[][][][] 这个值没有进行相应更新为 sum,  然后程序每次移动到这里就会进行一次dfs,出现超时。
	 */
	private static int f(int s, int r1, int r2, int[][] a, int[][][] dp) {
		if(r1>=N || r2>=N || s>2*(N-1))
			return -1;
		int c1 = s-r1;
		int c2 = s-r2;
		if(c1>=N || c2>=N || a[r1][c1]==-1 || a[r2][c2]==-1) {
			dp[s][r1][r2]=-1;
			return -1;
		}
		
		if(dp[s][r1][r2] != 2)
			return dp[s][r1][r2];
		
		int tmp = 0;
		if(r1==r2) {
			tmp = a[r1][c1];
		}else {
			tmp = a[r1][c1]+a[r2][c2];
		}
		int sum = 0;
		int v1 = f(s+1,r1,r2,a,dp);
		int v2 = f(s+1,r1+1,r2+1,a,dp);
		int v3 = f(s+1,r1+1,r2,a,dp);
		int v4 = f(s+1,r1,r2+1,a,dp);
		
		if(v1==-1 && v2==-1 && v3==-1 && v4==-1) {
			sum = -1;
		}else {
			int max = Math.max(v1, Math.max(v2, Math.max(v3, v4)));
			sum = tmp+max;
		}
		dp[s][r1][r2] = sum;
		return sum;
	}





	/*
	 * 最开始的思路：不能够AC, 从（0，0）到 （N-1,N-1）  这个分成两步走，是一个超时的算法
	 */
//	private static void dfs(int x, int y, int[][] a, int sum) {
//		if(x==N-1 && y==N-1) {
//			if(a[x][y]==1) {
//				a[x][y] = 0;
//				dfs2(x,y,a,sum+1);
//				a[x][y] = 1;
//			}else {
//				dfs2(x,y,a,sum);
//			}
//		}
//		if(x>=N || y>=N || a[x][y]==-1)
//			return;
//		if(a[x][y] == 1) {
//			a[x][y] = 0;
//			dfs(x+1,y,a,sum+1);
//			dfs(x,y+1,a,sum+1);
//			a[x][y] = 1;
//		}else {
//			dfs(x+1,y,a,sum);
//			dfs(x,y+1,a,sum);
//		}
//			
//	}
//
//	private static void dfs2(int x, int y, int[][] a, int sum) {
//		if(x==0 && y==0) {
//			maxSum = Math.max(sum, maxSum);
//			return;
//		}
//		if(x<0 || y<0 || a[x][y]==-1)
//			return;
//		if(a[x][y] == 1) {
//			a[x][y] = 0;
//			dfs2(x-1,y,a,sum+1);
//			dfs2(x,y-1,a,sum+1);
//			a[x][y] = 1;
//		}else {
//			dfs2(x-1,y,a,sum);
//			dfs2(x,y-1,a,sum);
//		}
//	}
}
