package BFS;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author czj
 * @date   2019-04-10 09:42
 * 你的赛车起始停留在位置 0，速度为 +1，正行驶在一个无限长的数轴上。（车也可以向负数方向行驶。）
	你的车会根据一系列由 A（加速）和 R（倒车）组成的指令进行自动驾驶 。
	当车得到指令 "A" 时, 将会做出以下操作： position += speed, speed *= 2。
	当车得到指令 "R" 时, 将会做出以下操作：如果当前速度是正数，则将车速调整为 speed = -1 ；否则将车速调整为 speed = 1。  (当前所处位置不变。)
	例如，当得到一系列指令 "AAR" 后, 你的车将会走过位置 0->1->3->3，并且速度变化为 1->2->4->-1。
	现在给定一个目标位置，请给出能够到达目标位置的最短指令列表的长度。
	示例 1:
	输入: 
	target = 3
	输出: 2
	解释: 
	最短指令列表为 "AA"
	位置变化为 0->1->3
 */
public class 赛车_hard {
	public static void main(String[] args) {
		System.out.println(racecar(5617));	
	}
	static int T = 0;
	static int min = Integer.MAX_VALUE;
	//方法三（看了解答以后的正确解方法）
	//在第二种方法中我犯下的错误，在备忘录记忆中我将每次的（位置，速度，步数）存储
	//下来，其实这是没有必要的，因为如果我们在某个（位置，速度）下存储的不是最小的步数，那么这个
	//备忘录的记忆相当于是无效的。
	
	//该正确解答的方式：  使用 广度优先遍历（BFS）+ 层级搜索  这样我在每一层仅仅会有一个步数
	//在每一层中，如果我之前已经保存过一次（位置，速度）那么这个时候，该层次下，我没有必要再去访问了
	//因为显然这一次达到这个（位置，速度）的步数已经比上一次多了，没有意义，达到剪枝的效果
	public static int racecar(int target) {
		T = target;
		Map<String, Boolean> m = new HashMap<>();
		Queue<String> q = new LinkedList<>();
		q.add("0,1");
		int stepCount = 0; //记录已经走了多少步
		while (!q.isEmpty()) {
			for(int i = q.size(); i > 0; i--) {
				String p = q.poll();
				String[] posAndSpeed = p.split(",");
				int pos = Integer.parseInt(posAndSpeed[0]);
				int speed = Integer.parseInt(posAndSpeed[1]);
				if(pos == T) {
					return stepCount;
				}
				if(pos<0 || pos>2*T)
					continue;
				if(m.containsKey(p+","+pos))
					continue;
				m.put(p+","+pos, true);
				
				//执行"A"操作
				q.add((pos+speed)+","+(speed*2));
				//执行"R"操作
				q.add(pos+","+(speed>0?-1:1));
			}
			stepCount++;
		}
		return 0;
    }
	//最开始我写的方法
	public static int racecar1(int target) {
		T = target;
		Queue<Pair> q = new PriorityQueue<>(new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				return o1.s.length() - o2.s.length();
			}
		});
		Map<String, Boolean> m = new HashMap<>();
		q.add(new Pair(0, 1, ""));
		while (!q.isEmpty()) {
			Pair p = q.poll();
			int pos = p.pos;
			int speed = p.speed;
			
			if(pos<0 || pos>2*T)
				continue;
			if(m.containsKey(""+p+pos))
				continue;
			m.put(""+p+pos, true);
			String s = p.s;
			if(pos == T) {
//				System.out.println(s+" "+s.length());
				return s.length();
			}
			q.add(new Pair(pos+speed, speed*2, s+"A"));
			q.add(new Pair(pos, speed>0?-1:1, s+"R"));
		}
		return 0;
    }
	static class Pair{
		int pos;
		int speed;
		String s;
		public Pair(int pos, int speed, String s) {
			this.pos = pos;
			this.speed = speed;
			this.s = s;
		}
	
		@Override
		public boolean equals(Object obj) {
			Pair p = (Pair)obj;
			return p.pos==pos && p.speed==speed;
		}
	
		@Override
		public int hashCode() {
			return ((Integer)pos).hashCode()+((Integer)speed).hashCode();
		}
	}
	//方法二：  这种方法几乎和上面一样，是TLE的
	public static int racecar2(int target) {
		T = target;
		Map<String, Integer> m = new HashMap<>();
		Queue<String> q = new LinkedList<>();
		q.add("0,1,0");
		while (!q.isEmpty()) {
			String p = q.poll();
			String[] posAndSpeed = p.split(",");
			int pos = Integer.parseInt(posAndSpeed[0]);
			int speed = Integer.parseInt(posAndSpeed[1]);
			int step = Integer.parseInt(posAndSpeed[2]);
			if(pos<0 || pos>2*T)
				continue;
			if(m.containsKey(p+","+pos+","+step))
				continue;
			m.put(p+","+pos+","+step, step);
			if(pos == T) {
				return step;
			}
			//执行"A"操作
			q.add((pos+speed)+","+(speed*2)+","+(step+1));
			//执行"R"操作
			q.add(pos+","+(speed>0?-1:1)+","+(step+1));
		}
		return 0;
    }
}
