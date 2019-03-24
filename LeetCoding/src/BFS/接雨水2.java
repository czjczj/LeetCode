package BFS;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author czj
 * @date   2019-03-24 12:25
 * 给定一个 m x n 的矩阵，其中的值均为正整数，代表二维高度图每个单元的高度，请计算图中形状最多能接多少体积的雨水。
	m 和 n 都是小于110的整数。每一个单位的高度都大于0 且小于 20000。
	示例：
	给出如下 3x6 的高度图:
	[
	  [1,4,3,1,3,2],
	  [3,2,1,3,2,4],
	  [2,3,3,2,3,1]
	]
	返回 4。
 */
public class 接雨水2 {
	public static void main(String[] args) {
		int[][] a = { {1,4,3,1,3,2},
				  {3,2,1,3,2,4},
				  {2,3,3,2,3,1}};
		System.out.println(trapRainWater(a));
	}
	static class State implements Comparable<State>{
		int x;
		int y;
		int h;
		public State(int x, int y, int h) {
			this.x = x;
			this.y = y;
			this.h = h;
		}
		@Override
		public int compareTo(State o) {
			return this.h-o.h;
		}
	}
	
	/**
	 * [1,4,3,1,3,2],
	  [3,2,1,3,2,4],
	  [2,3,3,2,3,1]
	  思路：采用一个优先级队列（不断取出最小的元素），在队列不为空的情况下，不断的取出元素p,扩展p,到下一个位置
	  nx,ny,如果下一个点的高度h小于当前点的高度，则ans加上高度差，并将下一个点置为已经访问。
	  显然对于每一个边缘位置的元素其都是初始化为已经访问过的，然后不断采用此方法更新。
	  可以理解为在边缘的地方每个位置都是一个水池，比如(1,0)位置高度为3,则水池高度为3，他会不断向比他低的位置注入水[例如（1,1）位置]，
	  在最小高度优先级的队列中，每次取出的都是高度相对于较小的位置的元素
	 */
	static int[] dix = {1,-1,0,0};
	static int[] diy = {0,0,1,-1};
	public static int trapRainWater(int[][] a) {
		if(a.length == 0) return 0;
		if(a[0].length == 0) return 0;
		int m = a.length;
		int n = a[0].length;
		
		int ans = 0;
		boolean[][] isVis = new boolean[m][n];
		Queue<State> q = new PriorityQueue<>();
		//将四周的位置给初始化到数组中去
		for (int i = 0; i < m; i++) {
			isVis[i][0] = true;
			q.add(new State(i, 0, a[i][0]));
			isVis[i][n-1] = true;
			q.add(new State(i, n-1, a[i][n-1]));
		}
		for (int i = 1; i < n-1; i++) {
			isVis[0][i] = true;
			isVis[m-1][i] = true;
			q.add(new State(0, i, a[0][i]));
			q.add(new State(m-1, i, a[m-1][i]));
		}
		
		while(!q.isEmpty()) {
			State p = q.poll();
			int x = p.x;
			int y = p.y;
			int curH = p.h;
			for (int i = 0; i < dix.length; i++) {
				int nx = x+dix[i];
				int ny = y+diy[i];
				if(nx<0||nx>=m||ny<0||ny>=n||isVis[nx][ny])
					continue;
				ans += Math.max(0, curH-a[nx][ny]);
				q.add(new State(nx, ny, Math.max(curH, a[nx][ny])));
				isVis[nx][ny] = true;
			}
		}
		return ans;
    }
}
