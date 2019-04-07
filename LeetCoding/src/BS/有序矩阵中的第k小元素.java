package BS;

/**
 * @author czj
 * @date   2019-03-15 20:44
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第k小的元素。
	请注意，它是排序后的第k小元素，而不是第k个元素。
	matrix = [
	   [ 1,  5,  9],
	   [10, 11, 13],
	   [12, 13, 15]
	],
	k = 8,
	返回 13。
	说明: 
	你可以假设 k 的值永远是有效的, 1 ≤ k ≤ n2 。
 */
public class 有序矩阵中的第k小元素 {
	public static void main(String[] args) {
		int[][] a = {
				{1,  5,  9},
				{10, 11, 13},
				{12, 13, 15}
		};
		int k = 6;
		int[][] aa = {
				{2000000000}
		};
		int kk = 1;
		System.out.println(kthSmallest(aa, kk));
	}
	/**
	 * 思路bs：
	 * 对于第寻找第k小的元素y,显然有随着k的增大，y的值也将增大，即存在正相关性
	 * 符合二分搜索的特点，在给定k的情况下很难求出y，相反的在给出y的情况下因为
	 * 数组是一个递增的数组所以很好求出k值
	 */
	public static int kthSmallest(int[][] a, int k) {
		int n = a.length;
        long L=(long)a[0][0];
        long R=(long)a[n-1][n-1];
        long ans = 0;
        while(L<=R) {
        	long mid = (L+R)/2;
        	if(guess(mid, a, k, n)) {
        		ans = mid;
        		L = mid+1;
        	}else {
        		R = mid-1;
        	}
        }
		return (int)ans;
    }
	/**
	 */
	private static boolean guess(long y, int[][] a, int k, int n) {
		int sum = 0;
		//对于每一行进行二分搜索寻找改行中大于y的元素的个数
		for (int i = 0; i < n; i++) {
			int L=0;
			int R=n-1;
			int ans = -1;
			while(L<=R) {
				int mid = (L+R)/2;
				if(a[i][mid]<y) {
					ans = mid;
					L = mid+1;
				}else {
					R = mid-1;
				}
			}
			sum += (ans+1);
		}
		return sum < k;
	}
}
