package Else;

/**
 * @author czj
 * @date   2019-03-19 14:51
 * 通常，正整数 n 的阶乘是所有小于或等于 n 的正整数的乘积。例如，factorial(10) = 10 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1。
	相反，我们设计了一个笨阶乘 clumsy：在整数的递减序列中，我们以一个固定顺序的操作符序列来依次替换原有的乘法操作符：乘法(*)，除法(/)，加法(+)和减法(-)。
	例如，clumsy(10) = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1。然而，这些运算仍然使用通常的算术运算顺序：我们在任何加、减步骤之前执行所有的乘法和除法步骤，并且按从左到右处理乘法和除法步骤。
	另外，我们使用的除法是地板除法（floor division），所以 10 * 9 / 8 等于 11。这保证结果是一个整数。
	实现上面定义的笨函数：给定一个整数 N，它返回 N 的笨阶乘。
	输入：4
	输出：7
	解释：7 = 4 * 3 / 2 + 1
 */
public class 笨阶乘_看答案后做出 {
	public static void main(String[] args) {
		System.out.println(clumsy(10));
	}
	/**
	 * 这道题目需要判断按照什么循环节来进行循环
	 * 乘循环：乘循环就是这样的10*(9/8+7-6)*(5/4+3-2)*1  不对
	 * 减循环：10*9/8+7)-(6*5/4+3)-2*1 不对
	 * 加循环：(10*9/8)+(7-6*5/4)+(3-2*1)对哦
	 * 1: 1;
	 * 2: 2*1;
	 * 3: 3*2/1;
	 * 4: 4*3/2 + 1;
	 * 5: 5*4/3 + 2-1;
	 * 6: 6*5/4 + 3-2*1;
	 * 7: 7*6/5 + 4-3*2/1;
	 * 8: 8*7/6 + 5-4*3/2 + 1;
	 */
	public static int clumsy(int N) {
		if(N==0) return 1;
		if(N==1) return N;
		if(N==2) return N*(N-1);
		if(N==3) return N*(N-1)/(N-2);
		return (int)(N*(N-1)/(N-2)+cal(N-3));
    }
    private static double cal(int x) {
    	 if(x==0) return 1;
    	 if(x==1) return 1;
    	 if(x==2) return x-(x-1);
    	 if(x==3) return x-(x-1)*(x-2);
    	 if(x==4) return x-(x-1)*(x-2)/(x-3);
    	 return x-(x-1)*(x-2)/(x-3) + cal(x-4);
    }

}
