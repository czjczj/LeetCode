package DP;

/**
 * 
 * @author czj
 * @date   2019��2��20��
 * 
 * ��λDP
 * ��������[A,B]��Χ�ڵ����֣������������f(i)��Ԫ��i�ĸ���������f(i)��i�Ĵ�Сû��̫��Ĺ�ϵ��������
 */
public class 数位DP_HDU2089 {
	static int[] a = new int[20];
	static int[][] dp = new int[20][2];
	public static void main(String[] args) {
		for(int i=0; i<dp.length; i++) {
			for(int j=0; j<dp[i].length; j++) {
				dp[i][j] = -1;
			}
		}
		int le = 520;
		int ri = 526;
		System.out.println(solve(ri) - solve(le-1));
		System.out.println(solve(ri));
	}
	public static int solve(int x) {
		//��ȡ������ֵ�ûһλ����
		int p = 0;
		while(x != 0) {
			a[p++] = x%10;
			x /= 10;
		}
		return dfs(p-1, -1, 0, true, true);
	}
	
	public static int dfs(int pos, int pre, int state, boolean bead, boolean limit) {
		if(pos == -1) return 1;
		if(!limit && !bead && dp[pos][state] != -1) return dp[pos][state];
		int up = limit?a[pos]:9;
		int tmp = 0;
		for(int i = 0; i <= up; i++) {
			if(i == 4) continue;
			if(i==2 && pre==6) continue;
			tmp += dfs(pos-1,i,i!=6?0:1,bead && i==0, limit && i==a[pos]);
		}
		
		if(!limit && !bead) dp[pos][state] = tmp;
		
		return tmp;
	}
}
