package BS;

/**
 * @author czj
 * @date   2019-03-18 16:51
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 */
public class powXN {
	public static void main(String[] args) {
		System.out.println(myPow(2.00000, -2147483648));
	}
	
	/**
	 * 思路：
	 */
	public static double myPow(double x, int n) {
		double res = 0;
		long a = (long)n;
		if(a<0) {
			res = f(x,-a);
		}else {
			res = f(x,a);
		}
		return a<0?1.0/res:res;
    }
	private static double f(double x, long n) {
		if(n==0)
			return 1;
		if(n == 1) {
			return x;
		}
		double ans = 0;
		double a = f(x,n/2);
		if(n%2 == 1) {
			ans = a*a*x;
		}else {
			ans = a*a;
		}
		return ans;
	}
}
