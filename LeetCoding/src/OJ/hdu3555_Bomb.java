package OJ;
import java.util.Scanner;

/**
 * @author czj
 * @date   2019-04-24 11:57
 */
public class hdu3555_Bomb {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		long[] res = new long[num];
		for (int i = 0; i < num; i++) {
			long aa = sc.nextLong();
			res[i] = aa;
		}
		for (int i = 0; i < res.length; i++) {
			long aa = res[i];
			System.out.println(aa-(solve(aa)-solve(1)+1));
		}
//		long aa = Long.MAX_VALUE;
//		System.out.println(solve(aa));
//		System.out.println(aa-(solve(aa)-solve(1)+1));
	}
	static int[] a = null;
	private static long solve(long num) {
		if(num < 0)
			return 0;
		a = new int[30];
		int p = 0;
		while(num != 0) {
			a[p++] = (int)(num%10);
			num /= 10;
		}
		
		long[][] dp = new long[p][2];
		return f(p-1,false,true,true,dp);
	}
	private static long f(int idx, boolean is4, boolean startZero, boolean limit, long[][] dp) {
		if(idx==-1)
			return 1;
		if(!startZero && !limit && dp[idx][is4?0:1] != 0)
			return dp[idx][is4?0:1];
		
		long res = 0;
		int u = limit?a[idx]:9;
		for (int i = 0; i <= u; i++) {
			if(i==9 && is4)
				continue;
			res += f(idx-1,i==4,startZero&&i==0,limit&&i==a[idx], dp);
		}
		
		if(!startZero && !limit) 
			dp[idx][is4?0:1] = res;
		return res;
	}
}
