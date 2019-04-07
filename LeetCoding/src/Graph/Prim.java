package Graph;
import java.util.Scanner;

/**
 * @author czj
 * @date   2019-03-31 19:52
 * 
 4 5
 0 1 3
 0 2 5
 0 3 4
 1 3 2
 2 3 1
 */
//求最小生成树算法-->①破圈法 ②避圈法
public class Prim {
	static int n = 0;//节点个数
	static int m = 0;//边的个数
	static int[][] map = null;//领结表表示边的关系
	static int res = 0;//最小生成数的边长
	
	static int[] d = null;//判断每个数字到集合S的当前最小的距离
	static boolean[] isVis = null;
	public static void main(String[] args) {
		input();
		get();
		System.out.println(res);
	}
	private static void get() {
		//初始化d[0] 将0号节点加入，并赋值其到距离为0,其他的都是无求大的
		for (int i = 0; i < n; i++) {
			d[i] = 100000;
		}
		d[0] = 0;
		//找到一个未加入到集合S，到S的距离最小的边
		//这里的v=-1很好的完成了初始化为0的情况
		while(true) {
			int v = -1;
			for(int i = 0; i < n; i++) {
				if(!isVis[i] && (v==-1 || d[i]<d[v])) {
					v = i;
				}
			}
			
			if(v==-1)//这里很巧妙的使用一个标志避免了重复计算的情况
				break;
			isVis[v] = true;
			res += d[v];
			
			//使用当前节点更新一些没有到S的最小值
			for(int i=0; i<n; i++) {
				if(map[v][i] != 0)
					d[i] = Math.min(d[i], map[v][i]);
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
	}
}
