package Graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @author czj
 * @date   2019-03-31 20:48
 * 求最小生成树，避圈法
 */
public class Kruskal {
	static int n = 0;//节点个数
	static int m = 0;//边的个数
	
	static Edge[] edges = null;
	
	static int res = 0;//最小生成数的边长
	
	//并查集
	static int[] pre = null;
	static int[] rank = null;
	
	public static void main(String[] args) {
		input();
		get();
		System.out.println(res);
	}
	private static void get() {
		Arrays.sort(edges);
		for (int i = 0; i < m; i++) {
			int s = edges[i].s;
			int t = edges[i].t;
			int cost = edges[i].cost;
			if(!(root(s) == root(t))) {
				res += cost;
				union(s,t);
			}
		}
	}

	private static void union(int x, int y) {
		int rx = root(x);
		int ry = root(y);
		if(rx==ry)
			return;
		if(rank[rx] < rank[ry]) {
			pre[rx] = ry;
		}else {
			if(rank[rx] == rank[ry]) {
				rank[rx]++;
			}
			pre[ry] = rx;
		}
	}
	private static int root(int i) {
		if(pre[i] == i)
			return i;
		return pre[i] = root(pre[i]);
	}
	
	private static void input() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		pre = new int[n];
		rank = new int[n];
		for (int i = 0; i < n; i++) {
			pre[i] = i;
			rank[i] = 1;
		}
		
		m = sc.nextInt();
		edges = new Edge[m];
		for (int i = 0; i < m; i++) {
			int s = sc.nextInt();
			int t = sc.nextInt();
			int cost = sc.nextInt();
			edges[i] = new Edge(s, t, cost);
		}
	}
	
	static class Edge implements Comparable<Edge>{
		int s; 
		int t;
		int cost;
		public Edge(int s, int t, int cost) {
			this.s = s;
			this.t = t;
			this.cost = cost;
		}
		@Override
		public int compareTo(Edge o) {
			return this.cost-o.cost;
		}
	}
}
