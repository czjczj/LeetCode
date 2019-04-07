package DP;
import java.util.Arrays;

/**
 * @author czj
 * @date   2019-03-19 11:25
 * 给定正整数 N，返回小于等于 N 且具有至少 1 位重复数字的正整数。
 * 输入：20
输出：1
解释：具有至少 1 位重复数字的正数（<= 20）只有 11 。
 */
public class 仍然思考_至少有1位重复的数字 {
	public static void main(String[] args) {
		System.out.println(numDupDigitsAtMostN(210062));
	}
	/**
	 * 目测数位DP: 数位dp特点，给定求解对于数字区间为 A....B之间的数字，满足f(i)条件的个数
	 * 通常f(i)与数字的大小没有关系，只有数字的组成有关。
	 */
	static int[] a = new int[10];
	static boolean[] isUsed = new boolean[10]; //标记0...9是否已经使用过
	static int[] dp = new int[10];//表示dp[i]都没有重复的元素的个数
	static int[] save = new int[10];
	static int K = 0;
	public static int numDupDigitsAtMostN(int N) {
        Arrays.fill(a, -1);
        Arrays.fill(dp, -1);
        Arrays.fill(save, -1);
        Arrays.fill(isUsed, false);
        int b = N;
        int k = 0;
        while(N != 0) {
        	a[k++] = N%10;
        	N /= 10;
        }
        K = k-1;//a[]的最后一个数字
		return b+1-dfs(k-1,true,true,true);//从最高一个位置向下遍历
    }
	 
	private static int dfs(int pos, boolean flag, boolean head, boolean limit) {
		if(pos == -1) {
			for (int i = K; i >= 0; i--) {
				System.out.print(save[i]);
			}
			System.out.println();
			return 1;
		};//说明已经遍历到低端了
//		if(!limit && !head && dp[pos] != -1) return dp[pos];
		int up = limit?a[pos]:9;
		int tmp = 0;
		for (int i = 0; i <= up; i++) {
			if(i==0 && flag) {
				save[pos] = i;
				tmp += dfs(pos-1,true,head&&i==0,limit&&i==a[pos]);
				save[pos] = -1;
			}else {
				if(!isUsed[i]) {
					isUsed[i] = true;
					save[pos] = i;
					tmp += dfs(pos-1,false,head&&i==0,limit&&i==a[pos]);
					save[pos] = -1;
					isUsed[i] = false;
				}
			}
		}
//		if(!limit && !head) dp[pos] = tmp;
		return tmp;
	}
}
