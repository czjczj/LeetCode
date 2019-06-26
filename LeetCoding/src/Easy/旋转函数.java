package Easy;

/**
 * @author czj
 * @date   2019-06-24 09:57
	给定一个长度为 n 的整数数组 A 。
	假设 Bk 是数组 A 顺时针旋转 k 个位置后的数组，我们定义 A 的“旋转函数” F 为：
	F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1]。
	计算F(0), F(1), ..., F(n-1)中的最大值。
	注意:
	可以认为 n 的值小于 105。
	示例:
	A = [4, 3, 2, 6]
	F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
	F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
	F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
	F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26
	所以 F(0), F(1), F(2), F(3) 中的最大值是 F(3) = 26 。
	链接：https://leetcode-cn.com/problems/rotate-function
 */
public class 旋转函数 {
	public static void main(String[] args) {
		int[] a = {4,3,2,6};
		System.out.print(maxRotateFunction(a));
	}
	/*
	 * 思路： 因为n可能为10^5,两个循环一定会超时，
	 * 这道题目可以找下规律，可以发现最后的记过是是
	 * 1.初始化f(0)
	 * 2.f(i)=f(i-1)+sum[a0...an-1]-n*a[n-1-i]
	 */
	public static int maxRotateFunction(int[] a) {
        int N = a.length;
        if(N==0)
            return 0;
        int max = Integer.MIN_VALUE;
        
        int sumAll = 0;
        int f0 = 0;
        for(int i=0; i<N; i++) {
        	sumAll += a[i];
        	f0 += i*a[i];
        }
        int tmp = f0;
        max = Math.max(tmp,max);
        for(int i=1; i<N; i++){
        	System.out.println(tmp);
            tmp = tmp+sumAll-N*a[N-i];
            max = Math.max(tmp,max);
        }
        return max;
    }
}
