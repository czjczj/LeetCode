package OJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author czj
 * @date   2019-04-13 10:06
 */
public class HDOJ_1429胜利大逃亡 {
	public static void main(String[] args) {
		input();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(map[i][j] == '@') {
					sx = i;
					sy = j;
				}
				if(map[i][j] == '^') {
					ex = i;
					ey = j;
				}
			}
		}
		
		System.out.println(""+sx+sy+ex+ey);
		boolean[][][] vis = new boolean[m][n][(int) (Math.pow(2, (int)('j'-'a'+1))+1)];
		Queue<Status> q = new LinkedList<>();
		q.add(new Status(sx, sy, 0, 0));
		
		boolean flag = false;
		while(!q.isEmpty()) {
			Status status = q.poll();
			int x = status.x;
			int y = status.y;
			int keys = status.keys;
			int step = status.step;
			if(x==ex && y==ey) {
				if(step < t) {
					flag = true;
				}
				System.out.println(step);
				break;
			}
			//判断当前状态是否到达过，到达过则跳过
			if(vis[x][y][keys])
				continue;
			vis[x][y][keys] = true;
			for (int i = 0; i < dir.length; i++) {
				int nx = x+dir[i][0];
				int ny = y+dir[i][1];
				if(nx<0||nx>=m||ny<0||ny>=n||map[nx][ny]=='*')
					continue;
				if(map[nx][ny]>='A' && map[nx][ny]<='J') {
					int cnt = map[nx][ny] - 'A';
					if(((keys>>cnt)&1) == 1) {
						Status ts = new Status(nx, ny, keys, step+1);
						q.add(ts);
					}
				}else if(map[nx][ny]>='a' && map[nx][ny]<='j') {
					int cnt = map[nx][ny] - 'a';
					Status ts = new Status(nx, ny, (1<<cnt)|keys, step+1);
					q.add(ts);
				}else {
					Status ts = new Status(nx, ny, keys, step+1);
					q.add(ts);
				}
			}
		}
		if(!flag)
			System.out.println(-1);
	}
	static int m;
	static int n;//m行n列
	static int t;//时间
	
	static int sx, sy;
	static int ex, ey;

	static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	
	static char[][] map = null;
	private static void input() {
		Scanner sc = new Scanner(System.in);
		String mnt = sc.nextLine();
		String[] res = mnt.split(" ");
		m = Integer.parseInt(res[0]);
		n = Integer.parseInt(res[1]);
		t = Integer.parseInt(res[2]);
		map = new char[m][n];
		for (int i = 0; i < m; i++) {
			String s = sc.nextLine();
			map[i] = s.toCharArray();
		}
	}
	
	//状态的定义特别的重要，保证每一个状态的唯一性
	static class Status{
		int x;
		int y;
		int keys;//本来的应该是一个数组  boolean[a...j]表示是否以及得到了对应的钥匙，如果得到了vis[i]为出，  皆可以看程一个数组，每个地方只能够取0,1
		int step;
		public Status(int x, int y, int keys, int step) {
			this.x = x;
			this.y = y;
			this.keys = keys;
			this.step = step;
		}
	}
}
