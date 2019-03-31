package BFS;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author czj
 * @date   2019-03-31 09:03
 * 八数码并不是对于所有的给定状态都是有解的
 */
public class 八数码 {
	static int cnt = 0;
	public static void main(String[] args) {
		int n = 3;
		String s = "235106487";
		String t = "123405678";
		
		Queue<State> q = new LinkedList<>();
		boolean[] isVis = new boolean[1000000000];
		q.add(new State(s.indexOf('0')/3, s.indexOf('0')%3, s, 0, ""));
		isVis[Integer.parseInt(s)] = true;
		while(!q.isEmpty()) {
			cnt++;
			State p = q.poll();
			int i = p.i;
			int j = p.j;
			int step = p.step; 
			String path = p.s;
//			System.out.println(cnt+" "+p.c+" "+t+" ");
			if((p.c).equals(t)) {
				System.out.println(p.s);
				System.out.println(p.step);
				break;
			}
			
			for (int k = 0; k < dix.length; k++) {
				int ni = dix[k]+i;
				int nj = diy[k]+j;
				if(ni<0||ni>=3||
						nj<0||nj>=3)
					continue;
				char[] c = p.c.toCharArray();
				char tmp = c[3*i+j];
				c[3*i+j] = c[3*ni+nj];
				c[3*ni+nj] = tmp; 
				String ns = new String(c);
				if(isVis[Integer.parseInt(ns)]) 
					continue;
				if(k == 0) {
					q.add(new State(ni, nj, ns, step+1, path+"U"));
				}else if(k==1) {
					q.add(new State(ni, nj, ns, step+1, path+"R"));
				}else if(k==2) {
					q.add(new State(ni, nj, ns, step+1, path+"D"));
				}else{
					q.add(new State(ni, nj, ns, step+1, path+"L"));
				}
				isVis[Integer.parseInt(ns)] = true;
			}
		}
	}
	static int[] dix = {-1,0,1,0};
	static int[] diy = {0,1,0,-1};
	static class State{
		int i;
		int j;
		String c = null;
		int step;
		String s = null;
		public State(int i, int j, String c, int step, String s) {
			this.i = i;
			this.j = j;
			this.c = c;
			this.step = step;
			this.s = s;
		}
	}
}
