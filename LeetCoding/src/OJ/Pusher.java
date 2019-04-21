package OJ;
import java.util.Scanner;

/**
 * @author czj
 * @date   2019-04-20 12:26
 */
public class Pusher {
	static int M = 0;
	static int N = 0;
	static char[][] map = null;
	static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	static String p = null;
	public static void main(String[] args) {
		input();
		
	}
	
	private static boolean dfs(int x, int y, char[][] m, int cnt, String path) {
		if(cnt == 0) {
			p = path;
			return true;
		}
		
		boolean res = false;
		//上
		if(x-1>=0 && m[x-1][y] == '.') {
			int tureX = x;
			while(x>=0 && m[x][y]=='.')
				x--;
			if(x>=0 && m[x][y] != '.') {
				char tmp = m[x][y];
				int i = x;
				if(x==0) {
					m[x][y] = '.';
					res = res || dfs(x,y,m, cnt-(tmp-'a'+1),path+"U");
					m[i][y] = tmp;
				}else {
					char t2 = m[x-1][y];
					m[x][y] = '.';
					if(t2=='.') {
						m[x-1][y] = tmp=='a'?t2:((char)(tmp-1));
					}else {
						m[x-1][y] = tmp=='a'?t2:(char)(t2+tmp-'a');
					}
					res = res || dfs(x,y,m,cnt-1,path+"U");
					m[x-1][y] = t2;
					m[x][y] = tmp;
				}
			}
			x = tureX;
		}
		
		if(x+1<M && m[x+1][y]=='.') {
			//下
			int tureX = x;
			while(x<M && m[x][y]=='.')
				x++;
			if(x<M && m[x][y] != '.') {
				char tmp = m[x][y];
				int i = x;
				if(x==M-1) {
					m[x][y] = '.';
					res = res || dfs(x,y,m,cnt-(tmp-'a'+1),path+"D");
					m[i][y] = tmp;
				}else {
					char t2 = m[x+1][y];
					m[x][y] = '.';
					if(t2=='.') {
						m[x+1][y] = tmp=='a'?t2:((char)(tmp-1));
					}else {
						m[x+1][y] = tmp=='a'?t2:(char)(t2+tmp-'a');
					}
					res = res || dfs(x,y,m,cnt-1,path+"D");
					m[x+1][y] = t2;
					m[x][y] = tmp;
				}
			}
			x = tureX;
		}
		
		if(y-1>=0 && m[x][y-1]=='.') {
			int trueY = y;
			//左
			while(y>=0 && m[x][y]=='.')
				y--;
			if(y>=0 && m[x][y] != '.') {
				char tmp = m[x][y];
				int i = y;
				if(y==0) {
					m[x][y] = '.';
					res = res || dfs(x,y,m,cnt-(tmp-'a'+1),path+'L');
					m[x][i] = tmp;
				}else {
					char t2 = m[x][y-1];
					m[x][y] = '.';
					if(t2=='.') {
						m[x][y-1] = tmp=='a'?t2:((char)(tmp-1));
					}else {
						m[x][y-1] = tmp=='a'?t2:(char)(t2+tmp-'a');
					}
					res = res || dfs(x,y,m,cnt-1,path+'L');
					m[x][y-1] = t2;
					m[x][y] = tmp;
				}
			}
			y = trueY;
		}
		
		if(y+1<N && m[x][y+1]=='.') {
			int trueY = y;
			//右
			while(y<N && m[x][y]=='.')
				y++;
			if(y<N && m[x][y] != '.') {
				char tmp = m[x][y];
				int i = y;
				if(y==N-1) {
					m[x][y] = '.';
					res = res || dfs(x,y,m,cnt-(tmp-'a'+1),path+'R');
					m[x][i] = tmp;
				}else {
					char t2 = m[x][y+1];
					m[x][y] = '.';
					if(t2=='.') {
						m[x][y+1] = tmp=='a'?t2:((char)(tmp-1));
					}else {
						m[x][y+1] = tmp=='a'?t2:(char)(t2+tmp-'a');
					}
					res = res || dfs(x,y,m,cnt-1,path+'R');
					m[x][y+1] = t2;
					m[x][y] = tmp;
				}
			}
			y = trueY;
		}
		return res;
	}

	private static void test() {
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
	private static void input() {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			N = sc.nextInt();
			M = sc.nextInt();
			map = new char[M][N];
			for (int i = 0; i < M; i++) {
				String s = sc.next();
				map[i] = s.toCharArray();
			}
			
			int sum = 0;
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] != '.')
						sum += (map[i][j]-'a'+1);
				}
			}
			
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] == '.') {
						if(dfs(i,j,map,sum,"")) {
							System.out.println(i);
							System.out.println(j);
							System.out.println(p);
						}
					}
				}
			}
		}
	}
}
