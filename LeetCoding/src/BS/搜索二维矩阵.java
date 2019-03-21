package BS;

/**
 * @author czj
 * @date   2019-03-18 17:26
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
	每行中的整数从左到右按升序排列。
	每行的第一个整数大于前一行的最后一个整数。
 */
public class 搜索二维矩阵 {
	public static void main(String[] args) {
		int[][] a = {
				{1,   3,  5,  7},
				{10, 11, 16, 20},
				{23, 30, 34, 50}
		};
		int t = 3;
		System.out.println(searchMatrix(a, t));
	}
	/**
	 * 对于每一行进行一次二分查找，时间复杂度nlog(n)
	 */
	public static boolean searchMatrix(int[][] a, int t) {
        int m = a.length;
        if(m==0)
        	return false;
        int n = a[0].length;
        if(n==0)
        	return false;
        for (int i = 0; i < m; i++) {
			int L = 0;
			int R = n-1;
			while(L<=R) {
				int mid = (L+R)/2;
				if(a[i][mid] == t)
					return true;
				else if(a[i][mid] < t)
					L = mid+1;
				else
					R = mid-1;
			}
		}
		return false;
    }
}
