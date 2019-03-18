package DFS;
import java.util.ArrayList;
import java.util.List;

/**
 * @author czj
 * @date   2019-03-14 16:34
 */
public class 组合总和3 {
	public static void main(String[] args) {
		int k = 3;
		int n = 2;
		List<List<Integer>> res = combinationSum3(k, n);
		for (int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i));
		}
	}
	static boolean[] isUsed = new boolean[10];
	static List<List<Integer>> list = new ArrayList<>();
	public static List<List<Integer>> combinationSum3(int k, int n) {
        list.clear();
		dfs(new ArrayList<Integer>(),1,k,n);
		return list;
    }
	/**
	 */
	private static void dfs(List<Integer> arr, int idx, int k, int n) {
		if(k <= 1) {
			if(0<n && n<=9 && n>=idx && !isUsed[n]) {
				arr.add(n);
				list.add(new ArrayList<>(arr));
				arr.remove(arr.size()-1);
			}
			return;
		}
		for (int i = idx; i <= 9; i++) {
			if(!isUsed[i]) {
				isUsed[i] = true;
				arr.add(i);
				dfs(arr, i+1, k-1,n-i);
				arr.remove(arr.size()-1);
				isUsed[i] = false;
			}
		}
	}
}
