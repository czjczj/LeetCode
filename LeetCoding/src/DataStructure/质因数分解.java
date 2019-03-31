package DataStructure;
import java.util.HashSet;
import java.util.Set;

/**
 * @author czj
 * @date   2019-03-29 14:55
 */
public class 质因数分解 {
	public static void main(String[] args) {
		int n = 12;
		String s = solve(n);
		int res = gcd(4,100);
//		最小公倍数a,b a*b/gcd(a,b)
		//筛发 求 2-n所有的质因数
		shaifa(100);//(时间复杂度:NlnlnN, 空间复杂度：O(n ))
		System.out.println(res);
		System.out.println(s);
	}
	private static void shaifa(int n) {
		Set<Integer> set = new HashSet<>();
		for (int i = 2; i <= n; i++) {
			set.add(i);
		}
		int k = 2;
		while(!set.isEmpty()) {
			if(set.contains(k)) {
				System.out.print(k + " ");
				for (int i = 2; i <= n; i++) {
					if(i%k==0) {
						set.remove(i);
					}
				}
			}
			k++;
		}
		System.out.println();
	}
	private static int gcd(int a, int b) {
		if(b%a==0)
			return a;
		return gcd(b%a,a);
	}
	// 步驟：
	//1.从【2，sqrt(n)】从小到大查找到的第一个因数为质因数 p，
	//2.n = n/p 并回到1
	//质因数：一个数的因数只有1和其本身
	//从小到大，如果一个因数m不是质因数，那么在他前面一定可以找到质因数，否则其没质因数，因此找到的第一个因数一定值质因数
	private static String solve(int n) {
		if(n==0 || n==1)
			return "";
		int t = n;
		String s = "";
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if(n%i == 0) {
				t = i;
				break;
			}
		}
		s += (t + solve(n/t));
		return s;
	}
}
