package DP;

/**
 * @author czj
 * @date   2019-06-15 16:26
 */
public class 只有两个键的键盘 {
	/**
	 * 思路：动态规划
	 * 对于  当前 数字的操作有两种
	 * dp[i] = min(dp[i], dp[j]+i/j)  其中 j为小于i的数字，dp[j]+i/j表示  复制
	 * 当前j数量的字符 (i/j)次  
	 * 初始化 dp[1] = 0;
	 * 
	 * 举一个栗子：
	 * 假设当前 n = 4 
	 * 则  可以为  d[2]+4/2(copy+paster d[2])
	 * 也可以为    d[1]+4/1(copy+paster+paster d[1])
	 */
	public static void main(String[] args) {
		System.out.println(minSteps(3));
	}
	public static int minSteps(int n) {
		int[] d = new int[n+1];
		for(int i = 1; i < n+1; i++) {
			d[i] = n+1;
		}
		d[1] = 0;
		for(int i = 1; i < n+1; i++) {
			for(int j = 1; j < i; j++) {
				if(i%j == 0)
					d[i] = Math.min(d[i], d[j]+i/j);
			}
		}
		return d[n];
    }
}	
