package Easy;
import java.util.Arrays;

/**
 * @author czj
 * @date   2019-03-19 14:37
 * 给定一个整数数组 A，我们只能用以下方法修改该数组：我们选择某个个索引 i 并将 A[i] 替换为 -A[i]，然后总共重复这个过程 K 次。（我们可以多次选择同一个索引 i。）
	以这种方式修改数组后，返回数组可能的最大和。
	输入：A = [4,2,3], K = 1
	输出：5
	解释：选择索引 (1,) ，然后 A 变为 [4,-2,3]。
 */
public class K次取反后最大化的数组和 {
	public static void main(String[] args) {
		int[] A = {2,-3,-1,5,-4};
		int K = 2;
		System.out.println(largestSumAfterKNegations(A, K));
	}
	public static int largestSumAfterKNegations(int[] a, int k) {
	    Arrays.sort(a);    
	    int negNum = 0;
	    for (int i = 0; i < a.length; i++) {
			if(a[i]<0) {
				negNum++;
			}else {
				break;
			}
		}
	    int sum = 0;
	    if(negNum>k) {
	    	for (int i = 0; i < a.length; i++) {
				if(k>0) {
					sum += -a[i];
					k--;
				}else {
					sum += a[i];
				}
			}
	    }else{
	    	for (int i = 0; i < a.length; i++) {
				a[i] = Math.abs(a[i]);
				sum += a[i];
			}
	    	k = k-negNum;
	    	Arrays.sort(a);
	    	if(k%2==1) {
	    		sum -= 2*a[0];
	    	}
	    }
		return sum;
	}
}
