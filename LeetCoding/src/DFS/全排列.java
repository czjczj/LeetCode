package DFS;
import java.util.ArrayList;
import java.util.List;

/**
 * @author czj
 * @date   2019-03-14 13:55
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * 输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 */
public class 全排列 {
	public static void main(String[] args) {
		int[] a = {1,2,3};
		List<List<Integer>> res = permute(a);
		for (int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i));
		}
	}
	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		dfs(0, new ArrayList<Integer>(), list, nums);
		return list;
    }
	/**
	 * dfs
	 */
	static boolean[] isUsed = new boolean[1000];
	private static void dfs(int idx, ArrayList<Integer> a, List<List<Integer>> list, int[] nums) {
		if(idx == nums.length) {
			list.add(new ArrayList<>(a));
		}
		if(idx > nums.length) return;
		for (int i = 0; i < nums.length; i++) {
			if(!isUsed[i]) {
				isUsed[i] = true;
				a.add(nums[i]);
				dfs(idx+1,a,list,nums);
				a.remove(a.size()-1);
				isUsed[i] = false;
			}
		}
	}
}
