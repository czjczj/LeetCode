package Else;

/**
 * @author czj
 * @date   2019-03-25 11:44
 */
public class LanQiao_平方和_easy {
	public static void main(String[] args) {
		long sum = 0;
		for (int i = 1; i <= 2019
				; i++) {
			if(check(i)) {
				sum += i*i;
			}
		}
		System.out.println(sum);
	}
	private static boolean check(int i) {
		while(i != 0) {
			int tmp = i%10;
			if(tmp==1 || tmp==2 || tmp==0 || tmp==9) {
				return true;
			}
			i /= 10;
		}
		return false;
	}
	
}
