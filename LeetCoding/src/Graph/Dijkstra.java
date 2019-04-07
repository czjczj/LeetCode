package Graph;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author czj
 * @date   2019-03-31 20:48
 *  4 5
 0 1 2
 0 2 6
 0 3 4
 1 3 1
 2 3 1
 */
public class Dijkstra {
	static int[] d = null;
	static int n = 0;//n个节点
	static int m = 0;//m条边
	static int[][] map = null;//邻接矩阵表示边的关系
	static boolean[] isVis = null;//判断已经确定了节点，从源点到这里的距离确定了则为true
	public static void main(String[] args) {
		input();
		get();
		display();
	}
	//显示信息
	private static void display() {
		for(int i=0; i<n; i++) {
			System.out.print("源点到"+i+"距离为:"+d[i]+"\n");
		}
	}
	private static void get() {
		//初始化每个位置到单源最短点的距离为最大值
		for (int i = 0; i < n; i++) {
			d[i] = 1000;
		}
		//只有源点的距离是最小的
		d[0] = 0;
		
		//寻找一个没有被访问，且到源点距离最小的元素为已经方位
		while(true) {
			int v = -1;
			for(int i=0; i<n; i++) {
				if(!isVis[i] && (v==-1 || d[i]<d[v])) {
					v = i;
				}
			}
			//如果每一个元素都被访问了的话
			//停止更新
			if(v==-1)
				break;
			isVis[v] = true;
			//使用该贪心得到的最小值更新与他想领结的元素
			for (int i = 0; i < n; i++) {
				if(map[v][i] != 0) {
					d[i] = Math.min(d[i], map[v][i]+d[v]);
				}
			}
		}
	}
	private static void input() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		d = new int[n];
		isVis = new boolean[n];
		map = new int[n][n];
		for (int i = 0; i < m; i++) {
			int s = sc.nextInt();
			int t = sc.nextInt();
			int cost = sc.nextInt();
			map[s][t] = cost;
			map[t][s] = cost;
		}
		System.out.println("haha");
	}
}
