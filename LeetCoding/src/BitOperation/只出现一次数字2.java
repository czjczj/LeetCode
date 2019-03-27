package BitOperation;

/**
 * @author czj
 * @date   2019-03-27 09:21
 */
public class 只出现一次数字2 {
	public static void main(String[] args) {
		System.out.println(singleNumber(new int[] {0,1,0,1,0,1,99}));
	}
	public static int singleNumber(int[] a) {
		int[] cnt = new int[32];
		int sum = 0;
        for (int i = 31; i >= 0; i--) {
			for (int j = 0; j < a.length; j++) {
				if(((a[j]>>i)&1) == 1)
					cnt[i]++;
			}
			if(cnt[i]%3==1) {
				sum = sum*2+1;
			}else {
				sum = sum*2;
			}
		}
		return sum;
    }
}
