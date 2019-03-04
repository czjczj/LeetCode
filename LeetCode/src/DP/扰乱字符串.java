package DP;

import java.util.Arrays;

/**
 * @author czj
 * @date   2019��2��27��
 */
public class 扰乱字符串 {
	static int[][][][] dp = null;
	public static void main(String[] args) {	
		System.out.println(isScramble2("great", "rgeat"));//true
		System.out.println(isScramble2("abc", "cba"));//true
		System.out.println(isScramble2("ccabcbabcbabbbbcbb", "bbbbabccccbbbabcba"));//false
	}
	/**
	 *DP��̬�� dp[i][j][len]��ʾ��s1�±�i��ʼ��s2�±�j��ʼ������Ϊlen���Ӵ��Ƿ��໥���ҵģ�����true,����false
	 *��ʼ�� �� ��Ȼdp[i][j][1]=(s1[i]==s2[j])
	 *���ƹ�ʽ�� dp[i][j][len]��ʵ��ʾ����s1[i,i+len-1]����һ�����䣬s2[j,j+len-1]��ôһ�������Ӵ��Ƿ��໥
	 *scramble,�����ѡ��һ������k�����������Ӵ����и�һ�Σ����s1�����������и�ֵ����s2���������(���ȱ�֤������ͬ)
	 *scramble������scramble����������������scramble��dp[i][j][len]��Ϊtrue
	 *
	 *��ʼ���Ƕ���ʼdp[][][]Ϊfalse
	 *���� dp[i][j][len] = dp[i][j][len] || (dp[i][j][k]&&dp[i+k][j+k][len-k]) || (dp[i][j+len-k][k]&&dp[i+k][j][len-k])
	 *ֻҪ��1<k<len�ķ�Χ�ڲ��ҵ�һ�������
	 */
	private static boolean isScramble2(String s1, String s2) {
		int n = s1.length();
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		boolean[][][] dp = new boolean[n][n][n+1];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				dp[i][j][1] = (c1[i] == c2[j]);
			}
		}
		
		for (int len = 2; len <= n; len++) {
			for (int i = 0; i <= n-len; i++) {
				for (int j = 0; j <= n-len; j++) {
					for (int k = 1; k <= len-1; k++) {
						if((dp[i][j][k]&&dp[i+k][j+k][len-k])||(dp[i][j+len-k][k]&&dp[i+k][j][len-k])) {
							dp[i][j][len] = true;
							break;
						}
					}
				}
			}
		}
		return dp[0][0][n];
	}

	/**
	 */
	private static boolean dfs(int[][][] dp2, String s1, String s2) {
		if(s1.length() != s2.length()) return false;
        if(s1.equals(s2)) return true;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        
        Arrays.sort(c1);
        Arrays.sort(c2);
        for (int i = 0; i < c2.length; i++) {
			if(c1[i] != c2[i])
				return false;
		}
		for(int i=1; i<s1.length(); i++) {
			String s11 = s1.substring(0,i);
			String s12 = s1.substring(i);
			String s21 = s2.substring(0, i);
			String s22 = s2.substring(i);
			if(isScramble(s11, s21) && isScramble(s12, s22))
				return true;
			s21 = s2.substring(s1.length()-i);
			s22 = s2.substring(0,s1.length()-i);
			if(isScramble(s11, s21) && isScramble(s12, s22))
				return true;
		}
		return false;
	}




	/**����һ��
	 * �ݹ�+��֦
	 * �����˼·��s1�����s2��Ϊ�����ַ������Ƕ��������s1���±�i���ָ�Ϊs11,s12�������֣���Ӧ��s2�д���ĳ���ָ�λ��
	 * j��s2�ָ�Ϊs21,s22����ʱ��Ȼ����s11��s21������s12��s22���ƣ�������s11��s22��s12��s21���ƣ� ��һ��Ҫ��֤�������ֵ�
	 * �ַ���������ͬ��
	 * 
	 * ��֦������1.���s1==s2��ֱ�ӷ���true
	 * 		   2.����s1��s2�д���ĳ���ַ���ͬ���϶����ܹ�����  ����false
	 * ����������s1��i��ʼ�ضϣ�s2�Ľ�ȡλ��j���⣬��Ҫ��֤��ȡ��ĳ���s21,s22����s1�Ĳ��֣�ֻ��һ��forѭ�����ɡ�
	 */
	public static boolean isScramble(String s1, String s2) {
		if(s1.length() != s2.length()) return false;
        if(s1.equals(s2)) return true;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        
        Arrays.sort(c1);
        Arrays.sort(c2);
        for (int i = 0; i < c2.length; i++) {
			if(c1[i] != c2[i])
				return false;
		}
		for(int i=1; i<s1.length(); i++) {
			String s11 = s1.substring(0,i);
			String s12 = s1.substring(i);
			String s21 = s2.substring(0, i);
			String s22 = s2.substring(i);
			if(isScramble(s11, s21) && isScramble(s12, s22))
				return true;
			s21 = s2.substring(s1.length()-i);
			s22 = s2.substring(0,s1.length()-i);
			if(isScramble(s11, s21) && isScramble(s12, s22))
				return true;
		}
		return false;
    }
}
