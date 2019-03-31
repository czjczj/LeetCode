package Stack;

/**
 * @author czj
 * @date   2019-03-31 16:46
 */
/*给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
求在该柱状图中，能够勾勒出来的矩形的最大面积。
以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]
图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
示例:
输入: [2,1,5,6,2,3]
输出: 10
*/
public class 柱状图中最大的矩形_hard {
	//思路：对于每一个下边i，能够以a[i]作为低的矩形是，(left[i]-right[i]+1)，其中
	//left[i]表示下标i左边第一个小于a[i]的下标+1，  right[i]表示下标i右边第一小于a[i]的下标-1；
	//优化：这里优化的地方主要是在，对于i, 计算a[i-1]如果大于a[i], left[i]=i-1,  这样在此判断left[i-1]-1和left[i-1]的高度
	//这样可以优化left,right数组的求解过程、
	public static void main(String[] args) {
		int[] a = {4,2,0,3,2,4,3,4};
		int n = a.length;
		int[] left = new int[n];
		left[0] = 0;
		
		for(int i=1; i<n; i++) {
			int A = i;
			while(A-1>=0 && a[A-1]>a[i]) {
				A = left[A-1];
			}
			left[i] = A;
		}
		
		int[] right = new int[n];
		right[n-1] = n-1;
		for(int i=n-2; i>=0; i--) {
			int A = i;
			while(A+1<n && a[A+1]>a[i]) {
				A = right[A+1];
			}
			right[i] = A;
		}
		
		int ans = 0;
		for(int i=0; i<a.length; i++) {
			ans = Math.max(ans, (right[i]-left[i]+1)*a[i]);
		}
		System.out.println(ans);
	}
}
