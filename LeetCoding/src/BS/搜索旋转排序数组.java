package BS;

/**
 * @author czj
 * @date   2019-03-18 14:58
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
	( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
	搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
	你可以假设数组中不存在重复的元素。
	你的算法时间复杂度必须是 O(log n) 级别。
 */
public class 搜索旋转排序数组 {
	public static void main(String[] args) {
		int[] a = {1,3};
		int target = 3;
		System.out.println(search(a, target));
	}
	/**
	 * 思路：题目要求在logn的是时间范围内求解，那么想到的当然是二分搜索
	 * 通过观察可以发现，在 a[left]<a[mid]的情况下，旋转后的左部分是有序的，否则右部分是有序的
	 * 这样的话，当我们通过比较target与a[left],a[mid],a[right]的值可以快速知道L,R移动的位置，
	 * 从而求解
	 */
	public static int search(int[] a, int target) {
        int R = a.length-1;
        int L = 0;
        int ans = -1;
        while(L<=R) {
        	int mid = (L+R)/2;
        	//右边有序的话
        	if(a[mid] == target) {
        		return mid;
        	}else if(a[mid]<=a[R]) {
        		if(target>=a[mid] && target <= a[R]) {
        			L = mid+1;
        		}else {
        			R = mid-1;
        		}
        	}else {
        		if(target<=a[mid] && target >= a[L]) {
        			R = mid-1;
        		}else {
        			L = mid+1;
        		}
        	}
        }
		return ans;
    }
}
