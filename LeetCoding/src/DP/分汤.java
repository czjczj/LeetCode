package DP;

/**
 * @author czj
 * @date   2019-04-11 15:03
 * 有 A 和 B 两种类型的汤。一开始每种类型的汤有 N 毫升。有四种分配操作：
	提供 100ml 的汤A 和 0ml 的汤B。
	提供 75ml 的汤A 和 25ml 的汤B。
	提供 50ml 的汤A 和 50ml 的汤B。
	提供 25ml 的汤A 和 75ml 的汤B。
	当我们把汤分配给某人之后，汤就没有了。每个回合，我们将从四种概率同为0.25的操作中进行分配选择。如果汤的剩余量不足以完成某次操作，我们将尽可能分配。当两种类型的汤都分配完时，停止操作。
	注意不存在先分配100 ml汤B的操作。
	需要返回的值： 汤A先分配完的概率 + 汤A和汤B同时分配完的概率 / 2。
 */
public class 分汤 {
	public static void main(String[] args) {
		System.out.println(soupServings(50));
	}
	static double[][] dp = null;
	public static double soupServings(int N) {
		if(N>=4800) 
        	return 1.0;
		dp = new double[(N+1)][(N+1)];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp.length; j++) {
				dp[i][j] = -1;
			}
		}
        double res = f(N,N);
		return res;
    }
	private static double f(int a, int b) {
		if(a==0 && b==0)
			return 1.0/2;
		if(a==0)
			return 1;
		if(b==0)
			return 0;
		if(dp[a][b] != -1)
			return dp[a][b];
		double res = 0;
		double r1 =  f(a-4*25>=0?a-4*25:0, b);
		double r2 =  f(a-3*25>=0?a-3*25:0, b-25>=0?b-25:0);
		double r3 =  f(a-2*25>=0?a-2*25:0, b-50>=0?b-50:0);
		double r4 =  f(a-25>=0?a-25:0, b-75>=0?b-75:0);
		res = 0.25*(r1+r2+r3+r4);
		dp[a][b] = res;
		return res;
	}
}
