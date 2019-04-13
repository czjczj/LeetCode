package OJ;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author czj
 * @date   2019-04-13 11:58
 */
public class HDOJ_1226超级密码 {
	static int N;
	static int C;
	static int M;
	static char[] a = null;
	public static void main(String[] args) {
		N = 25;
		C = 16;
		M = 3;
		a = new char[]{'A','B','C'};
		
		Queue<Status> q = new PriorityQueue<>(new Comparator<Status>() {
			@Override
			public int compare(Status s1, Status s2) {
				return s1.num-s2.num;
			}
		});
		q.add(new Status("", 0));
		boolean flag = false;
		while(!q.isEmpty()) {
			Status p = q.poll();
			String s = p.s;
			int num = p.num;
			if(num%N==0 && num !=0) {
				flag = true;
				System.out.println(s);
				break;
			}
			if(s.length() > 500)
				break;
			
			for (int i = 0; i < M; i++) {
				int tmpNum = num*C;
				if(a[i]>='0' && a[i]<='9') {
					tmpNum += (a[i]-'0');
				}
				if(a[i]>='A' && a[i]<='F') {
					tmpNum += (a[i]-'A'+10);
				}
				if(s.startsWith("0"))
					continue;
				q.add(new Status(s+a[i], tmpNum));
			}
		}
		if(!flag) {
			System.out.println("give me the bomb please");
		}
	}
	static class Status{
		String s;
		int num;
		public Status(String s, int num) {
			this.s = s;
			this.num = num;
		}
	}
}
