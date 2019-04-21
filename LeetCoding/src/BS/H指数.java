package BS;
import java.util.Arrays;

/**
 * @author czj
 * @date   2019-04-21 09:20
 */
public class H指数 {
	public static void main(String[] args) {
		int[] a = {100};
		System.out.println(hIndex(a));
	}
	
	/**
	 * 思路：一个二分搜索的问题，时间复杂度nlog(n)
	 */
	public static int hIndex(int[] a) {
		int n = a.length;
        if(n==0)
            return 0;
        Arrays.sort(a);
        
        int L = 0;
        int R = a[n-1];
        int ans = 0;
        while(L<=R) {
        	int mid = (L+R)/2;
        	if(check(mid,a)) {
        		ans = mid;
        		L = mid+1;
        	}else {
        		R = mid-1;
        	}
        }
		return ans;
    }
	
	private static boolean check(int mid, int[] a) {
		int idx = 0;
		for (int i = 0; i < a.length; i++) {
			if(a[i] >= mid) {
				idx = i;
				break;
			}
		}
		
		return a.length-idx >= mid;
	}
}
