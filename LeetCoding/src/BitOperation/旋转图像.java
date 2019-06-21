package BitOperation;

/**
 * @author czj
 * @date   2019-04-17 21:56
 * 
 * 给定一个 n × n 的二维矩阵表示一个图像。
	将图像顺时针旋转 90 度。
	说明：
	你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
	示例 1:
	给定 matrix = 
	[
	  [1,2,3],
	  [4,5,6],
	  [7,8,9]
	],
	原地旋转输入矩阵，使其变为:
	[
	  [7,4,1],
	  [8,5,2],
	  [9,6,3]
	]
 */
public class 旋转图像 {
	public static void main(String[] args){
		int[][] a = {
				  {1,2,3,4},
				  {5,6,7,8},
				  {9,10,11,12},
				  {13,14,15,16}
		};
		rotate(a);
		int m = a.length;
		for(int i=0; i<m; i++) {
			for(int j=0; j<m; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}	
	/*
	 * 对于每一个点（i,j） 递推坐标变换
	 * a[i,j] --> a[j][m-i] --> a[m-i][m-j] --> a[m-j][i]
	 * 这里需要注意一下循环的次数，外循环是 m-1次  以后最后一个 m 相当于已经遍历到了
	 * 内循环  是从 j=i 开始，因为我们外边的一个环 已经在上一次遍历的时候进行了旋转，
	 * 内循环终止的时候是 m-i-1,因为我们只需要遍历到对半减少的位置就可以了
	 */
	public static void rotate(int[][] a) {
		int m = a.length-1;
		for(int i=0; i<=m-1; i++) {
			for(int j=i; j<=m-1-i; j++) {
				int tmp = a[m-j][i];
				a[m-j][i] = a[m-i][m-j];
				a[m-i][m-j] = a[j][m-i];
				a[j][m-i] = a[i][j];
				a[i][j] = tmp;
			}
		}
	}
}
