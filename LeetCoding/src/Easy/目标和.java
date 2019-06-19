package Easy;

/**
 * @author czj
 * @date   2019-06-15 19:02
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。
 * 对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
	返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
	示例 1:
	输入: nums: [1, 1, 1, 1, 1], S: 3
	输出: 5
	解释: 
 */
public class 目标和 {
	public static void main(String[] args) {
		int[] nums = {8,48,11,47,26,12,16,39,38,50,21,12,34,1,28,1,3,9,17,50};
		int S = 3;
		System.out.println(findTargetSumWays(nums,S));
	}
	
	//方法二，没有使用什么剪枝操作  时复：O(2^n)
	static int cnt = 0;
	public static int findTargetSumWays(int[] nums, int S) {
		cnt = 0;
		f(0,S,nums);//idx,剩余的和
		return cnt;
    }
	private static void f(int idx, int S, int[] nums) {
		if(idx==nums.length && S==0) {
			cnt++;
			return;
		}
		if(idx>=nums.length)
			return;
		//加上当前值
		f(idx+1, S+nums[idx], nums);
		//减去当前值
		f(idx+1, S-nums[idx], nums);
	}

	//状态压缩方法  O(2^n*n) 当n=20的时候会超时，这种方法没有剪枝操作
	public static int findTargetSumWays1(int[] nums, int S) {
		int len = nums.length;
		int cnt = 0;
        for(int i = 0; i < (1<<(len-1)+1); i++) {
        	int sum = 0;
        	for(int k = 0; k < len; k++) {
        		if(((i>>k)&1)==1) {
        			sum += nums[len-k-1]; 
        		}else {
        			sum -= nums[len-k-1];	
        		}
        	}
        	if(sum == S)
        		cnt += 1;
        }
        return cnt;
    }
}
