package DP;

/**
 * @author czj
 * @date   2019锟斤拷2锟斤拷27锟斤拷
 */
public class 不同的二叉搜索树 {
	public static void main(String[] args) {
		System.out.println(5);
	}
	
	/**
	 * DP锟斤拷思锟诫：
	 * 1.锟斤拷锟斤拷锟节碉拷为x锟斤拷锟斤拷么锟斤拷锟叫碉拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟街碉拷锟斤拷锟�  <=x ; 锟揭憋拷锟斤拷锟斤拷锟斤拷锟斤拷值锟斤拷锟斤拷 >=x
	 * 	锟斤拷锟斤拷锟节碉拷为1锟斤拷时锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷为0锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷为n-1,锟斤拷锟斤拷锟节碉拷为2锟斤拷时锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷为1锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷为n-2
	 * 2.锟斤拷同锟斤拷态锟侥讹拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷为   锟斤拷锟节碉拷锟�  锟斤拷锟斤拷锟斤拷锟侥革拷锟斤拷*锟斤拷锟斤拷锟斤拷锟侥革拷锟斤拷
	 * nums[i] += nums[j] * nums[i-1-j]
	 */
	public static int numTrees(int n) {
		if (n == 0)return 0;
        if (n == 1) return 1;
 
        int[] nums = new int[n+1];
        nums[0] = 1; nums[1] = 1;
 
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                nums[i] = nums[i] + nums[j] * nums[i-1-j];
            }
        }
        return nums[n];
    }
}
