package DP;

import java.util.Stack;

/**
 * @author czj
 * @date   2019��2��22��
 * ����һ��ֻ���� '(' �� ')' ���ַ������ҳ���İ�����Ч���ŵ��Ӵ��ĳ��ȡ�
 */
public class 最长有效括号 {
	public static void main(String[] args) {
		System.out.println(longestValidParentheses(")()())()()("));
		System.out.println(longestValidParentheses("())())()()"));
//		System.out.println(test2("()()))))()()("));
	}
	//����һջ���
	/**
	 * ��())()  ��()(() ���Է��ֵ�����(������϶������꿪ʼλ�á��������ֵڶ����������ô�� (() ���������ų������⣬
	 * ����sΪһ����Ч���Ŵ��Ŀ�ʼλ�ã����嵱ǰ��Ч���ĳ���Ϊmax����ô�ڸ��µĹ��̲��ϸ���maxֵ
	 * ��ʼs,maxΪ0
	 * 1.����������(ʱ��ջ
	 * 2.������)ʱ��
	 *   2.1 ����ʱջΪ�գ�����Ч�ַ���ʼ+1, ��s+=1
	 *   2.2 ����ʱջ��Ϊ��(˵����������),��ô��վһ�Σ�
	 *   	2.2.1 ����վִ�к�ջΪ�գ���ǰmax = Math.max(max, index-s+1)
	 *      2.2.1 ����վ�Ժ�ջ��Ϊ�գ�������(()�������ô max=Math.max(max,index-��ǰջ��+1)
	 */
	public static int longestValidParentheses(String s) {
        char[] c = s.toCharArray();
        if(c.length == 0) return 0;
        Stack<Integer> ss = new Stack<>();
        int start = 0;
        int max = 0;
        for (int i = 0; i < c.length; i++) {
			if(c[i] == '(') {
				ss.add(i);//���ｫiѹ��ջ������ܹ���ջ��Ϊ����ջ�������
				continue;
			}
			//����)����
			if(ss.isEmpty()) {
				start = i+1;
			}else {
				ss.pop();
				if(ss.isEmpty()) {
					max = Math.max(max, i-start+1);
				}else {
					max = Math.max(max, i-ss.peek());
				}
			}
		}
        return max;
    }
	//������dp
	/**
	 * dp[m]��ʾ���ַ���s[0]�� s[m]�������Ч�����Ÿ���
	 */
	public static int test2(String s) {
		if(s == "") return 0;
		char[] c = s.toCharArray();
		if(c.length == 0) return 0;
		int n = s.length();
		int[] dp = new int[n];
		//��ʼ��dpΪ0
		for (int i = 0; i < dp.length; i++) {
			dp[i] = 0;
		}
		for(int i = 0; i < c.length; i++) {
			if(c[i] == ')') {
				if(i-1>=0 && i-1-dp[i-1]>=0 && c[i-1-dp[i-1]] == '(') {
					dp[i] = dp[i-1]+2;
					if(i-2>=0 && i-2-dp[i-1]>=0) {
						dp[i] += dp[i-1-dp[i-1]-1];
					}
				}
			}
		}
	
		int max = 0;
		for (int i = 0; i < dp.length; i++) {
			max = Math.max(max, dp[i]);
		}
		return max;
	}
}
