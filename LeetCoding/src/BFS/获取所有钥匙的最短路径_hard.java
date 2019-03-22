package BFS;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author czj
 * @date   2019-03-22 08:47
 *       给定一个二维网格 grid。 "." 代表一个空房间， "#" 代表一堵墙， "@" 是起点，（"a", "b", ...）代表钥匙，（"A", "B", ...）代表锁。
	我们从起点开始出发，一次移动是指向四个基本方向之一行走一个单位空间。我们不能在网格外面行走，也无法穿过一堵墙。
	如果途经一个钥匙，我们就把它捡起来。除非我们手里有对应的钥匙，否则无法通过锁。
	假设 K 为钥匙/锁的个数，且满足 1 <= K <= 6，字母表中的前 K 个字母在网格中都有自己对应的一个小写和一个大写字母。
	换言之，每个锁有唯一对应的钥匙，每个钥匙也有唯一对应的锁。另外，代表钥匙和锁的字母互为大小写并按字母顺序排列。
	返回获取所有钥匙所需要的移动的最少次数。如果无法获取所有钥匙，返回 -1 。
	示例 1：
	输入：["@.a.#","###.#","b.A.B"]
	@.a.#
	###.#
	b.A.B  8
 */
public class 获取所有钥匙的最短路径_hard {
	public static void main(String[] args) {
		String[] s = {"@.a.#","###.#","b.A.B"};
		String[] ss = {"@..aA","..B#.","....b"};
		System.out.println(shortestPathAllKeys(ss));
		System.out.println(shortestPathAllKeys(new String[] {".@aA"}));
		System.out.println(shortestPathAllKeys(new String[] {"@Aa"}));
		System.out.println(shortestPathAllKeys(new String[] {"@...a",".###A","b.BCc"}));
		
	}
	/**
	 * 解题思路：
	 * # 要求最短路径，采用广度优先搜索。用队列实现广度优先搜索。
	        # 因为增加了钥匙，所以我们需要引入状态，以表达当前有多少钥匙。在同一个位置，若拥有的钥匙数目不同，则
	        # 视为不同的状态，这些状态需要入队;若当前状态此前已经访问过（即钥匙数与坐标位置都相同视为同一个状态），则
	        # 可跳过，无需访问。
	   # key只有6种，我们用一个int类型保存当前已经拥有的key的情况，只需要6bit。
	        # 我们从起点开始搜索，遇到钥匙就更新记录，遇到墙就跳过，遇到門若有钥匙则通过，若没有钥匙则跳过。此外，如果当前
	        # 状态已经遍历过，就跳过，否则加入队列，这些属于广度优先搜索的基本操作。
	        # 需要注意以下几点。
	 */
	static int m;	//m行n列
	static int n;
	
	static int[] dix = {0,1,0,-1};
	static int[] diy = {1,0,-1,0};
	
	static int keyState;
	static boolean[][][] isVis = null;
	
	static class State{
		int step;
		int x;
		int y;
		int keyState;
		public State(int x, int y, int keyState, int step) {
			this.x = x;
			this.y = y;
			this.keyState = keyState;
			this.step = step;
		}
	}
	
	public static int shortestPathAllKeys(String[] grid) {
		m = grid.length;
		n = grid[0].toCharArray().length;
		char[][] c = new char[m][n];
		for (int i = 0; i < grid.length; i++) {
			c[i] = grid[i].toCharArray();
		}
		//遍历一遍数组，查看钥匙的个数
		int ax = 0;//确定@坐标
		int ay = 0;
		keyState = 0;
		
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c[i].length; j++) {
				int t = c[i][j] - 'a';
				if(t>=0 && t<6) {
					keyState = keyState | (1<<t);//使用6个bit位置来保存当前的钥匙信息，例如000011表示存在'a','b'钥匙了
				}
				if(c[i][j]=='@') {
					ax = i;
					ay = j;
				}
			}
		}
		isVis = new boolean[m][n][keyState+1];//观察每个位置的m,n列k个元素值是否遍历过
		State start = new State(ax, ay, 0, 0);
		isVis[ax][ay][0] = true;
//		LinkedBlockingQueue<State> q = new LinkedBlockingQueue<>();
		Queue<State> q = new LinkedList<>();
		q.add(start);
		while(!q.isEmpty()) {
			State p = q.poll();
			int px = p.x;
			int py = p.y;
			int pState = p.keyState;
			if(pState == keyState) {
				return p.step;
			}
			for (int i = 0; i < dix.length; i++) {
				int nx = px+dix[i];
				int ny = py+diy[i];
				if(nx<0||nx>=m||ny<0||ny>=n||isVis[nx][ny][pState]||c[nx][ny]=='#')
					continue;
				if(c[nx][ny]>='A'&&c[nx][ny]<='F') {
					int tmp = c[nx][ny]-'A';
					if(((pState>>tmp)&1) != 1)
						continue;
				}
				if(c[nx][ny]>='a'&&c[nx][ny]<='f') {
					int tmp = c[nx][ny]-'a';
					isVis[nx][ny][pState|(1<<tmp)] = true;
					q.add(new State(nx, ny, pState|(1<<tmp), p.step+1));
				}else {
					isVis[nx][ny][pState] = true;
					q.add(new State(nx, ny, pState, p.step+1));
				}
			}
		}
		return -1;
    }
}

