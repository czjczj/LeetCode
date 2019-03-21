package BS;

/**
 * @author czj
 * @date   2019-03-18 18:09
 * 	假设按照升序排序的数组在预先未知的某个点上进行了旋转。
	( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
	编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
	输入: nums = [2,5,6,0,0,1,2], target = 0
	输出: true
 */
public class 搜索旋转排序数组2 {
	public static void main(String[] args) {
		int[] a = {1,3,1,1,1};
		int target = 3;
		System.out.println(search(a, target));
	}
	/**思路：
	 * 相比于  “搜索旋转数组1” 这道题目在于当 a[mid]等于了一个a[L]或者a[R](这里我们仅需要以L或者R)
	 * 为比较的边界值，然后我们能够在等于的情况下 是的  L=L+1即可
	 */
	public static boolean search(int[] a, int t) {
        int R = a.length-1;
        int L = 0;
        while(L<=R) {
        	int mid = (L+R)/2;
        	//右边有序的话
        	if(a[mid] == t) {
        		return true;
        	}
        	if (a[mid] < a[L]){               //右侧有序
                if (a[mid] < t && a[R] >= t){
                    L = mid + 1;
                }
                else
                    R = mid - 1;
            }
            else if (a[mid] > a[L]){          //左侧有序
                if (a[mid] > t && a[L] <= t){
                    R = mid - 1;
                }
                else
                    L = mid + 1;
            }
            else                                //相等情况
                L = L + 1;
        }
		return false;
    }
}
