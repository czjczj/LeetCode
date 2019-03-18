package BS;

/**
 * @author czj
 * @date   2019-03-15 15:30
 */
public class 分割数组的最大值 {
	public static void main(String[] args) {
		int[] nums = {1,2147483647};
		int m = 2;
		System.out.println(splitArray(nums, m));
	}
	/**
	 * 思路：Binary Search
	 * 例子[1,2,3,4,5]当m=2时产生的最大值为9，可以看出f(m)与y的关系是单调递减的，即
	 * 随着m的增大， 产生的最大值可以越小。
	 * 且该题的一个求解特点是，当m确定是求解最大值最小的方法比较难，但是相反的，当我们已经知道最大值可以
	 * 为多少的时候，我们能够求解的m是可以快速求解出来的，其实这是非常相似于二分搜索的解题方法。
	 * 在确定最大值大左右边界的情况下，最大右界为sum(数组),左界限为0；
	 */
	public static int splitArray(int[] nums, int m) {
        long L=0;
        long R=1;
        for (int i = 0; i < nums.length; i++) {
			R += (long)nums[i];
		}
        long ans = 0;
        while(L < R) {
        	long mid = (L+R)/2;
        	if(guess(mid, nums, m)) {
        		ans = mid;
        		R = mid;
        	}else {
        		L = mid+1;
        	}
        }
		
		return (int)ans;
    }
	private static boolean guess(long mid, int[] nums, int m) {
		long sum = 0;
		for (int i = 0; i < nums.length; i++) {
			if(sum + nums[i] > mid) {
				m--;
				sum = nums[i];
				if(nums[i] > mid) {
					return false;
				}
			}else {
				sum += nums[i];
			}
		}
		return m>=1;
	}
}
