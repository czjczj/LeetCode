package BS;

/**
 * @author czj
 * @date   2019-03-15 14:07
 */
public class x的平方根 {
	public static void main(String[] args) {
		System.out.println(mySqrt(2147483647));
	}
	public static int mySqrt(int y) {
		long L=0;
		long R = (long)y+1; //[0,y)左臂右开
		long ans = 0;
		while(L<R) {
			long mid = (L+R)/2;
			if(guess(mid,y)) {
				ans = mid;
				L = mid+1;
			}else {
				R = mid;
			}
		}
		return (int)ans;
    }
	/**
	 */
	private static boolean guess(long mid,long y) {
		return (long)mid*mid <= y;
	}
}
