package BitOperation;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @author czj
 * @date   2019-03-26 08:42
 */
public class 子集 {
	public static void main(String[] args) {
		
	}
	//方法一 位运算定义状态
	public static List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        //定义位运算的状态  对于3个元素，那么将有，每个元素取或者不取 2^3一种8种状态。
        List<List<Integer>> ls = new ArrayList<>();
        for (int i = 0; i < Math.pow(2, len); i++) {
        	List<Integer> arr = new ArrayList<>();
			for (int j = 0; j < len; j++) {
				if(((i>>j)&1)==1)
					arr.add(nums[j]);
			}
			ls.add(arr);
		}
		return ls;
    }
	
	//方法二 dfs每个元素取或者不取
	static List<List<Integer>> ls = new ArrayList<>();
	public static List<List<Integer>> subsets2(int[] nums) {
        ls.clear();
        f(nums,0,new ArrayList<Integer>());
        return ls;
    }
    public static void f(int[] nums, int idx, List<Integer> a){
        if(idx==nums.length){
            List<Integer> tmp = new ArrayList<>(a);
            ls.add(tmp);
            return;
        }
        a.add(nums[idx]);
        f(nums,idx+1,a);
        a.remove(a.size()-1);
        
        f(nums,idx+1,a);
    }
}
