package BS;

/**
 * @author czj
 * @date   2019-03-18 16:41
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
	你可以假设数组中无重复元素。
	输入: [1,3,5,6], 5
	输出: 2
 */
public class 搜索插入位置_简单 {
	public static void main(String[] args) {
		int[] a = {1,3,5,6};
		int t = 7;
		System.out.println(searchInsert(a, t));
	}
	public static int searchInsert(int[] a, int t) {
		int L = 0;
		int R = a.length-1;
		int ans = -1;
		while(L <= R) {
			int mid = (L+R)/2;
			if(a[mid]<t) {
				ans = mid;
				L = mid+1;
			}else {
				R = mid-1;
			}
		}
		return ans+1;
    }
}
