package OJ;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

/**
 * @author czj
 * @date   2019-04-15 13:44
 */
public class 未_HDOJ_1664DifferentDigits {
	public static void main(String[] args) {
		System.out.println(solve(15));
	}
	private static char[] solve(int n) {
		int[] a = get(n);
		
		//判断这个由一种数字组成结果的情况
		for (int i = 0; i < a.length; i++) {
			//初始化对于n取模的结果的-
			for (int j = 0; j < a.length; j++) {
				
			}
		}
		
		return null;
	}
	private static int[] get(int n) {
		Set<Integer> s = new HashSet<>();
		while(n != 0) {
			s.add(n%10);
			n = n/10;
		}
		
		int[] a = new int[s.size()];
		int i = 0;
		Iterator<Integer> iterator = s.iterator();
		while(iterator.hasNext()) {
			a[i++] = iterator.next();
		}
		return a;
	}
}
