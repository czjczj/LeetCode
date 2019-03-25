package Easy;

/**
 * @author czj
 * @date   2019-03-25 11:51
 */
public class LanQiao_数列求值_easy {
	public static void main(String[] args) {
		int a = 1;
		int b = 1;
		int c = 1;
		for (int i = 4; i <= 20190324; i++) {
			int tmp = a+b+c;
			a = b;
			b = c;
			c = tmp;
		}
		System.out.println(c);
		System.out.println(c%10000);
	}
}
