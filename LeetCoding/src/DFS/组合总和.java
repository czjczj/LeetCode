package DFS;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author czj
 * @date   2019-03-14 20:01
 */
public class 组合总和 {
	public static void main(String[] args) {
		int[] c = {2,3,5};
		int t = 8;
		List<List<Integer>> res = combinationSum(c, t);
		for (int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i));
		}
	}
	
	static List<List<Integer>> list = new ArrayList<>();
	public static List<List<Integer>> combinationSum(int[] a, int t){
		list.clear();
		Arrays.sort(a);
		dfs(0, new ArrayList<Integer>(), a,t);
		return list;
    }
	
	/**
	 */
	private static void dfs(int idx, ArrayList<Integer> arr, int[] a, int t) {
		if(t == 0) {
			list.add(new ArrayList<>(arr));
			return;
		}
		if(t < 0 || idx >= a.length) return;
//		for (int i = idx; i < a.length; i++) {
//			arr.add(a[i]);
//			dfs(i,arr,a,t-a[i]);
//			arr.remove(arr.size()-1);
//		}
		
		arr.add(a[idx]);
		dfs(idx,arr,a,t-a[idx]);
		arr.remove(arr.size()-1);
		
		dfs(idx+1,arr,a,t);
	}
}
