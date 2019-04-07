package GameTheory;
import java.util.HashMap;
import java.util.Map;

/**
 * @author czj
 * @date   2019-03-28 18:14
 * 在 "100 game" 这个游戏中，两名玩家轮流选择从 1 到 10 的任意整数，累计整数和，先使得累计整数和达到 100 的玩家，即为胜者。
	如果我们将游戏规则改为 “玩家不能重复使用整数” 呢？
	例如，两个玩家可以轮流从公共整数池中抽取从 1 到 15 的整数（不放回），直到累计整数和 >= 100。
	给定一个整数 maxChoosableInteger （整数池中可选择的最大数）和另一个整数 desiredTotal（累计和），判断先出手的玩家是否能稳赢（假设两位玩家游戏时都表现最佳）？
	你可以假设 maxChoosableInteger 不会大于 20， desiredTotal 不会大于 300。
 */
public class 我能赢吗 {
	public static void main(String[] args) {
		System.out.println(canIWin(18,79));
	}
	public static boolean canIWin(int maxChoosableInteger, int desiredTotal) {
		if(desiredTotal == 0) return true;
		int[] a = new int[maxChoosableInteger];
		boolean[] vis = new boolean[maxChoosableInteger];
		for (int i = 0; i < a.length; i++) {
			a[i] = i+1;
		}
		int[][] d = new int[1<<maxChoosableInteger+1][desiredTotal+1];
		Map<Integer, Boolean> b = new HashMap<>();
		boolean res = f(a,desiredTotal,0,b);
		return res;
    }
	//思路：递归，默认情况下我是会输的，如果我找到一种方式我可以赢，那么我就赢了
	//递归进去以后，就是对手，对手的选择方式如果找到了一种方式可以赢，那么就可以赢看，否则他就是输了。
	private static boolean f(int[] a, int t, int vis,Map<Integer, Boolean> b) {
		if(t <= 0)
			return false;
		if(b.containsKey(vis)) return b.get(vis);
		boolean res = false;
		for (int i = 0; i < a.length; i++) {
			if(((vis>>i)&1) != 1) {
				vis = vis | (1<<i);
				res = res || !f(a,t-a[i],vis,b);
				vis = vis ^ (1<<i);
			}
		}
		b.put(vis, res);
		return res;
	}
}
