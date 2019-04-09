package DP;

/**
 * @author czj
 * @date   2019-04-09 08:27
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
	上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
	示例:
	输入: [0,1,0,2,1,0,1,3,2,1,2,1]
	输出: 6
 */
public class 接雨水_hard {
	public static void main(String[] args) {
		int[] a = {2,0,2};
		System.out.println(trap(a));
	}
	public static int trap(int[] h) {
		int n = h.length;
        int sum = 0;
        int[] l = new int[n];//l[i] 表示h[0...i]中的最大值
        int[] r = new int[n];//r[i] 表示h[i...n-1]中的最大值
        
        //那么l[i] = max(l[i-1],h[i]), r[i]=max(r[i+1],h[i])
        l[0] = h[0];
        r[n-1] = h[n-1];
        for (int i = 1; i < n; i++) {
			l[i] = Math.max(l[i-1], h[i]);
		}
        for (int i = n-2; i >= 0; i--) {
			r[i] = Math.max(r[i+1], h[i]);
		}
        
//        for (int i = 0; i < r.length; i++) {
//			System.out.println(l[i] + " " + r[i]);
//		}
        for (int i = 1; i < n-1; i++) {
			int leftM = l[i];
			int rightM = r[i];
			
			int tmp = (leftM<rightM?leftM:rightM);
			sum += tmp-h[i];
//			System.out.println(tmp-h[i]);
		}
		return sum;
    }
}
