package BS;

/**
 * @author czj
 * @date   2019-03-19 09:34
 * 	峰值元素是指其值大于左右相邻值的元素。
	给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
	数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
	你可以假设 nums[-1] = nums[n] = -∞。
 */
public class 寻找峰值 {
	public static void main(String[] args) {
		int[] a = {2,1};
		System.out.println(findPeakElement(a));
	}
	/**
	 * 这道题目看了答案不太理解：
	 * 答案给出的解释：如果中间元素大于其相邻的后续元素，则中间元素左侧（包括中间元素）必然包含一个局部最大值，
	 * 如果中间元素小于其相邻的后续元素，则中间元素右侧必然包含一个局部最大值。
	 * 直到最后左边沿和右边沿相遇，我们找到所求峰值。
	 */
	public static int findPeakElement(int[] nums) {
		if(nums.length == 1){
	        return 0;
	    }
	    if(nums[1] < nums[0]){
	        return 0;
	    }
	    if(nums[nums.length-2] < nums[nums.length-1]){
	        return nums.length-1;
	    }
	    int start = 0;
	    int end = nums.length - 1;
	    while(start <= end){
	        int middle = (start+end)/2;
	        if(nums[middle] > nums[middle-1] && nums[middle] > nums[middle+1]){
	            return middle;
	        }
	        if(nums[middle] > nums[middle-1]){
	            start = middle + 1;
	        }else{
	            end = middle;
	        }
	    }
	    return -1;
    }
}
