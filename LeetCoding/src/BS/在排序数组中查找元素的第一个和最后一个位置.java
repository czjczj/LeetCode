package BS;

/**
 * @author czj
 * @date   2019-03-18 15:55
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
	你的算法时间复杂度必须是 O(log n) 级别。	
	如果数组中不存在目标值，返回 [-1, -1]。
	输入: nums = [5,7,7,8,8,10], target = 8
	输出: [3,4]
 */
public class 在排序数组中查找元素的第一个和最后一个位置 {
	public static void main(String[] args) {
		int[] nums = {5,7,7,8,8,10};
		int t = 10;
		int[] res = searchRange(nums, t);
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i]+" ");
		}
	}
	/**
	 * 思路：
	 * 分别按照a[mid]<target, 和 a[mid]<=target 能够取到左边最后一个小于目标值的元素下边
	 * 和右边最后一个等于目标值的元素，因为至少有一个目标元素值的存在，当left+1>right元素，说明不存在
	 * 目标元素值，此时返回[-1,-1]，否则返回[left+1, right]
	 */
	public static int[] searchRange(int[] a, int t) {
		int L = 0;
		int R = a.length-1;
		int left = -1;
		int right = -1;
		while(L <= R) {
			int mid = (L+R)/2;
			if(guess(mid, a, t)) {
				left = mid;
				L = mid+1;
			}else {
				R = mid-1;
			}
		}
		L = 0;
		R = a.length-1;
		while(L <= R) {
			int mid = (L+R)/2;
			if(guess2(mid, a, t)) {
				right = mid;
				L = mid+1;
			}else {
				R = mid-1;
			}
		}
		
//		System.out.println(""+left+" "+right);
		if(left+1>right)
			return new int[] {-1,-1};
		return new int[] {left+1, right};
	}
	private static boolean guess2(int mid, int[] a, int t) {
		return a[mid] <= t;
	}
	private static boolean guess(int mid, int[] a, int t) {
		return a[mid] < t;
	}
}
