package DP;

/**
 * @author czj
 * @date   2019��2��25��
 */
public class 不同路径2 {
	public static void main(String[] args) {
		int[][] a = {
		             {0,1,0},
		             {0,1,0},
		             {0,0,0}
		};
		System.out.println(uniquePathsWithObstacles(a));
	}
	public static int uniquePathsWithObstacles(int[][] a) {
		int m = a.length;
		int n = a[0].length;
		int[][] dp = new int[m][n];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				if(a[i][j] == 1)
					dp[i][j] = -2;
				else
					dp[i][j] = -1;
			}
		}
		
		int res = dfs(dp,0,0);
		return res;
    }
	
	/**
	 * DP˼�룺dp[i][j] ��Ȼ�� �����ǰ���λ��Ϊ��(i,j)��ʱ���ҵ��յ��λ��·���߷�����
	 * ��Ȼ ����dpλ��Ϊ dp[m][n] ,m,n�ֱ�������������
	 * �������ڳ�ʼ����ʱ�����ϰ��ĵط�����dp[][]Ϊ-2�������ʼ��Ϊ-1
	 * 1.�����"��ͬ·��1"���ǲ��ܱ�֤��i==m��j==nʱ�����ǾͿ��Ե��յ㣬��Ϊ����·���п������ϰ�  ֻ�������������ʱ��ſ���
	 * 2.�����ǵ� i �� j����Ŀ���λ�õ�ʱ�����ֱ�ӷ���0
	 * 3 �������ϰ���ʱ������Ҳ��Ҫ���� 0
	 * ������ʽ�������ڡ���ͬ·��1��
	 * 
	 */
	private static int dfs(int[][] dp, int i, int j) {
		if(i==dp.length-1 && j==dp[0].length-1 && dp[i][j] != -2) return 1;
		if(i>=dp.length || j>=dp[0].length) return 0;
		if(dp[i][j] == -2) return 0;
		if(dp[i][j] != -1) return dp[i][j];
		int ans = 0;
		ans += dfs(dp,i+1,j);
		ans += dfs(dp,i,j+1);
		dp[i][j] = ans;
		return ans;
	}
}
