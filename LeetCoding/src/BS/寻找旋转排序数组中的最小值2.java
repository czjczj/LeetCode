package BS;

/**
 * @author czj
 * @date   2019-03-19 09:17
 * 	假设按照升序排序的数组在预先未知的某个点上进行了旋转。
	( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
	请找出其中最小的元素。
	注意数组中可能存在重复的元素。
	输入: [1,3,5]
	输出: 1
 */
public class 寻找旋转排序数组中的最小值2 {
	public static void main(String[] args) {
		int[] a = {1};
		System.out.println(findMin(a));
	}
	/**
	 * 思路：采用的方式当 a[mid]=a[L]，则更新此次ans，并且使L=L+1
	 */
	public static int findMin(int[] a) {
		int L = 0;
		int R = a.length-1;
		int ans = 1000;
		while(L<=R) {
			int mid = (L+R)/2;
			if(a[mid]>a[L]) {//左侧有序
				ans = Math.min(ans, a[L]);
				L = mid+1;
			}else if(a[mid]<a[L]){//右侧有序
				ans = Math.min(ans, a[mid]);
				R = mid-1;
			}else {//a[mid]=a[L]
				ans = Math.min(ans, a[mid]);
				L = L+1;
			}
		}
		return ans;
    }
}
