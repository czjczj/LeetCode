package Easy;

/**
 * @author czj
 * @date   2019-03-19 10:24
 */
public class 十进制整数的反码 {
	public static void main(String[] args) {
		System.out.println(bitwiseComplement(10000));
	}
	public static int bitwiseComplement(int N) {
        String s = f(N);
        char[] c = s.toCharArray();
        int sum = 0;
        for (int i = 0; i < c.length; i++) {
			if(c[i]=='1') {
				sum = sum*2+0;
			}else {
				sum = sum*2+1;
			}
		}
        return sum;
	}
	private static String f(int n) {
		if(n==0)
			return ""+0;
		if(n==1)
			return ""+1;
		return f(n/2)+n%2;
	}
}	
