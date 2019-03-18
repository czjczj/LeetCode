package DFS;
import java.util.ArrayList;
import java.util.List;

/**
 * @author czj
 * @date   2019-03-14 14:39
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 输入: n = 4, k = 2
输出:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
 */
public class 组合 {
	public static void main(String[] args) {
		int n = 4;
		int k = 2;
		List<List<Integer>> res = combine(n, k);
		for (int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i));
		}
	}
	
	static List<List<Integer>> a = new ArrayList<>();
	static boolean[] isUsed = new boolean[1000];
	public static List<List<Integer>> combine(int n, int k) {
		a.clear();
		dfs(0,new ArrayList<Integer>(),n,k);
		return a;
    }
	/**
	 * dfs
	 */
	private static void dfs(int idx, ArrayList<Integer> arrList, int n, int k) {
		if(idx >= k) {
			a.add(new ArrayList<>(arrList));
			return;
		}
		for (int i = 1; i <= n; i++) {
			if(!isUsed[i]) {
				isUsed[i] = true;
				if(arrList.isEmpty() || arrList.get(arrList.size()-1) < i) {
					arrList.add(i);
					dfs(idx+1, arrList, n, k);
					arrList.remove(arrList.size()-1);
				}
				isUsed[i] = false;
			}
		}
	}
}
