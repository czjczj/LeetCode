package DataStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author czj
 * @date   2019-03-30 16:28
 * SPFA算法是bellmanford的改进，主要是在原始的bellmanford算法中加入了一个队列和判断是否访问的数组isVis
 * 
 * 
7 10
1 2 2
2 3 10
3 4 5
1 5 5
2 5 4
2 6 6
3 7 3
4 7 9
5 6 2
6 7 1
 */
public class SPFA {
	
	static int[] dis = null;
	static int[] pre = null;
	static boolean[] isVis = null;
	static int n = 0;//节点个数
	static int m = 0;//边个数
	static int[][] edges = null;
	static Queue<Integer> q = new LinkedList<>();
	public static void main(String[] args) {
		init();
		solve();
	}
	private static void solve() {
		dis = new int[n+1];
		pre = new int[n+1];
		isVis = new boolean[n+1];
		Arrays.fill(dis, 1000);
		Arrays.fill(pre, -1);
		
		dis[1] = 0;
		pre[1] = -1;
		q.add(1);
		while (!q.isEmpty()) {
			Integer p = q.poll();
			isVis[p] = true;
			for (int i = 1; i <= n; i++) {
				if(edges[p][i] != 0) {
					if(dis[p]+edges[p][i] < dis[i]) {
						dis[i] = dis[p]+edges[p][i];
						pre[i] = p;
						if(!isVis[i])
							q.add(i);
					}
				}
			}
		}
		
		for (int i = 2; i <= n; i++) {
			String s = get(i);
			System.out.println(""+1+"到"+i+"的路徑:"+s+" 長度："+dis[i]);
		}
	}
	private static String get(int i) {
		if(pre[i]==-1)
			return " 1";
		String s = " "+i;
		return s+get(pre[i]);
	}
	private static void init() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		edges = new int[n+1][n+1];
		for (int i = 0; i < m; i++) {
			int s = sc.nextInt();
			int t = sc.nextInt();
			int cost = sc.nextInt();
			edges[s][t] = cost;
			edges[t][s] = cost;
		}
	}
}

