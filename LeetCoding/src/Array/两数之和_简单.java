package Array;

/**
 * @author czj
 * @date   2019-03-12 12:19
 */
public class 两数之和_简单 {
	public static void main(String[] args) {
		int[] a = {2,7,11,15};
		int[] res = twoSum(a, 9);
		System.out.println(res[0]+" "+ res[1]);
	}
	public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
			int r2 = target-nums[i];
			for (int j = i+1; j < nums.length; j++) {
				if(nums[j] == r2) {
					res[0] = i;
					res[1] = j;
					return res;
				}
			}
		}
		return res;
    }
}
