package DP;

/**
 * @author czj
 * @date   2019��2��27��
 * һ��������ĸ A-Z ����Ϣͨ�����·�ʽ�����˱��룺
'A' -> 1
'B' -> 2
...
'Z' -> 26
����һ��ֻ�������ֵķǿ��ַ������������뷽����������

ʾ�� 1:
����: "12"
���: 2
����: �����Խ���Ϊ "AB"��1 2������ "L"��12����
 */
public class 解码方法 {
	public static void main(String[] args) {
		System.out.println(numDecodings("226"));
	}
	
	public static int numDecodings(String s) {
		char[] c = s.toCharArray();
		int[] dp = new int[c.length];
		for (int i = 0; i < dp.length; i++) {
			dp[i] = -1;
		}
		int res = dfs(dp,c,0);
		return res;
    }
	/**
	 * DP˼·��
	 * dp[i]��ʾ���±�Ϊi��λ�õ������ַ����Ľ��뷽������
	 * ��ô������¥����һ����Ŀ��ֻ����������Ҫ���Ǽ�һЩ�ж���������dp
	 * 1.�����ǰ����Ϊ0,��Ȼ���������²����ˣ���ʱֱ�ӷ��ص��յ��ִ�з���Ϊ0
	 * 2.�����ǰ����Ϊ����2�������ܴ���30.40��ģ���ʱֻ�ܹ�������һ��������������
	 * 3.�����ǰ����Ϊ2����Ҫ������һ�������Ƿ�С��6,
	 * 	3.1 С�ڵĻ����ҿ�������������
	 *  3.2���ڵĻ����ҿ���������һ��
	 * 4.�����ǰ����С��2������������һ����������
	 */
	private static int dfs(int[] dp, char[] c, int i) {
		if(i == dp.length) return 1;
		if(i >= dp.length) return 0;
		if(c[i] == '0') return 0;
		if(dp[i] != -1) return dp[i];
		int ans = 0;
		if(c[i]-'0' > 2) {
				ans += dfs(dp,c,i+1);
		}else if(c[i]-'0' == 2) {
			if(i+1<dp.length && c[i+1]-'0'<=6) {
				ans += dfs(dp,c,i+2);
			}
			ans += dfs(dp,c,i+1);
		}else {
			ans += dfs(dp,c,i+1);
			ans += dfs(dp,c,i+2);
		}
		dp[i] = ans;
		return ans;
	}
	
	private static int dfs2(int[] dp, char[] c, int i) {
		if(i == dp.length) return 1;
		if(i >= dp.length) return 0;
		if(c[i] == '0') return 0;
		if(dp[i] != -1) return dp[i];
		int ans = 0;
		if(c[i]-'0' > 2) {
			ans = dfs2(dp,c,i+1)+1;
		}else {
			ans += dfs2(dp,c,i+1);
			ans += dfs2(dp,c,i+2);
		}
		dp[i] = ans;
		return ans;
	}
}
