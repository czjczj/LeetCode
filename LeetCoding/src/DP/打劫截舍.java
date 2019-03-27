package DP;

/**
 * @author czj
 * @date   2019-03-27 10:31
 */
public class 打劫截舍 {
	public static void main(String[] args) {
		System.out.println(rob(new int[] {2,7,9,3,1}));
	}
	public static int rob(int[] nums) {
        int[][] dp = new int[nums.length][2];
        for(int i=0; i<nums.length; i++){
            for(int j=0; j<2; j++){
                dp[i][j] = -1;
            }
        }
        
        dp[nums.length-1][0] = 0;
        dp[nums.length-1][1] = nums[nums.length-1];
        for(int idx=nums.length-2; idx>=0 ; idx--) {
        	for (int flag = 0; flag < 2; flag++) {
        		if(dp[idx][flag] != -1) return dp[idx][flag];
                int res = 0;
                if(flag==0){
                    int tmp = dp[idx+1][1];
                    res = Math.max(res, tmp);
                }else{
                    res = Math.max(res, dp[idx+1][0]+nums[idx]);
                    res = Math.max(res, dp[idx+1][1]);
                }
                dp[idx][flag] = res;
			}
        }
        
        return dp[0][1];
    }
	
	//这个是递归的方式
    public int solve(int idx, int[] nums, int flag, int[][] dp){
        if(idx == nums.length)
            return 0;
        if(dp[idx][flag] != -1) return dp[idx][flag];
        int res = 0;
        if(flag==0){
            int tmp = solve(idx+1, nums, 1,dp);
            res = Math.max(res, tmp);
        }else{
            res = Math.max(res, solve(idx+1,nums,0,dp)+nums[idx]);
            res = Math.max(res, solve(idx+1,nums,1,dp));
        }
        dp[idx][flag] = res;
        return res;
    }
}
