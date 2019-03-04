package DP;

/**
 * @author czj
 * @date   2019��2��25��
 * 
 */
public class 最大子序和 {
	public static void main(String[] args) {
		int[] a = {-2,1,-3,4,-1,2,1,-5,4};
		int[] b = {-2,-1};
		System.out.println(maxSubArray(b));
	}
	public static int maxSubArray(int[] nums) {
		int current=nums[0];
        int sum=nums[0];
        for(int i=1;i<nums.length;i++) {
            if(current<0)current=nums[i];
            else current+=nums[i];
            if(current>sum)sum=current;
        }
        return sum;
    }
}
