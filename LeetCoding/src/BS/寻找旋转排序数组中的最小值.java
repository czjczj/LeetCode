package BS;

/**
 * @author czj
 * @date   2019-03-19 08:57
	假设按照升序排序的数组在预先未知的某个点上进行了旋转。
	( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
	请找出其中最小的元素。
	你可以假设数组中不存在重复元素。
 */
public class 寻找旋转排序数组中的最小值 {
	public static void main(String[] args) {
		int[] a = {2,1};
		System.out.println(findMin(a));
	}
	/**
	 * 思路：很显然的对于中间元素 a[mid]>a[L]则a[L...mid]有序，否则右边有序，对于有序的部分
	 * 我们能够直接得到在该有序段落中的最小值（为a[L]或者a[mid]），至此，我们对于费有序段落继续使用相同的
	 * 求解方式即可得到结果
	 */
	public static int findMin(int[] a) {
		int L = 0;
		int R = a.length-1;
		int ans = 1000;
		while(L<=R) {
			int mid = (L+R)/2;
			if(a[mid]>=a[L]) {//左侧有序
				ans = Math.min(ans, a[L]);
				L = mid+1;
			}else {//右侧有序
				ans = Math.min(ans, a[mid]);
				R = mid-1;
			}
		}
		return ans;
    }
}
