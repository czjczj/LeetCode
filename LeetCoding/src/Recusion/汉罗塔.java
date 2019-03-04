package Stack;
/**
 * @author czj
 * @date   2019-03-04 15:24
 */

public class 汉罗塔 {
	static int count = 0;
	public static void main(String[] args) {
		int n = 3;
		f(n,'A','B','C');
		System.out.println(count);
	}

	private static void f(int n, char a, char b, char c) {
		if(n == 1) {
			System.out.println(a+"-->"+b);
			count++;
		}
		else {
			f(n-1,a,c,b);
			System.out.println(a+"-->"+b);
			count++;
			f(n-1,c,b,a);
		}
	}
}
