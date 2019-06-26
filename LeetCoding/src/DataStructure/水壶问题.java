package DataStructure;

/**
 * @author czj
 * @date   2019-06-23 19:04
 */
public class 水壶问题 {
	public static void main(String[] args) {
		System.out.println(canMeasureWater(4,6,8));
	}
	public static boolean canMeasureWater(int x, int y, int z) {
        if(x==0 || y==0)
        	return x==z || y==z;
        int t = gcd(x,y);
        return z%t==0 && x+y>=z;
    }
	private static int gcd(int x, int y) {
		if(x==0)
			return y;
		return gcd(y%x,x);
	}
}
