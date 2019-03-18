package DFS;
import java.lang.Character.Subset;
import java.util.ArrayList;
import java.util.List;

/**
 * @author czj
 * @date   2019-03-14 15:55
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
说明：解集不能包含重复的子集。
 */
public class 子集2 {
	public static void main(String[] args) {
		int[] a = {1,1};
		List<List<Integer>> res = subsetsWithDup(a);
		for (int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i));
		}
	}
	static List<List<Integer>> list = new ArrayList<>();
	static boolean[] isUsed = new boolean[1000];
	public static List<List<Integer>> subsetsWithDup(int[] a) {
		list.clear();
        //首先对于该数组进行排序
		for (int i = 0; i < a.length; i++) {
			for (int j = i+1; j < a.length; j++) {
				if(a[i] > a[j]) {
					int tmp = a[i];
					a[i] = a[j];
					a[j] = tmp;
				}
			}
		}
		dfs(0,a);
		return list;
    }
	/**
	 *思路：对于需要使用的数组需要向进行一次排序操作，例如此例子 变成1,2,2
	 *对于每一个位置我们最后可以 取或者不取，   我们要判断不取的情况，例如当出现  1,2后    在此出现的2，我们可以选择取或者不取，但是  当我们为 1 不取后，  对于下一个
	 *2我们不能再取，因为此时取后则可能出现与1,2  和  1,2的重复
	 */
	private static void dfs(int idx, int[] a) {
		if(idx >= a.length) {
			List<Integer> res = new ArrayList<>();
			for (int i = 0; i < a.length; i++) {
				if(isUsed[i]) {
					res.add(a[i]);
				}
			}
			list.add(res);
			return;
		}

		if(!(idx>=1 && a[idx-1]==a[idx] && !isUsed[idx-1])) {
			//取当前元素
			isUsed[idx] = true;
			dfs(idx+1,a);
			isUsed[idx] = false;
		}
		//不取当前元素
		dfs(idx+1,a);
	}
}
