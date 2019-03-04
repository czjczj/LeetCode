package DP;

/**
 * @author czj
 * @date   2019��2��25��
 * ����һ�������Ǹ������� m x n �������ҳ�һ�������Ͻǵ����½ǵ�·����ʹ��·���ϵ������ܺ�Ϊ��С��
	˵����ÿ��ֻ�����»��������ƶ�һ����
	
	dp[i][j]��ʾ�� (0,0)�㵽(i,j)���·�������ֺ���С��·��ֵ
	
	��Ϊ���˵�˼�룬��ô dp[i][j]��ȷ���󾡿��Ը���d[i+1][j],dp[i][j+1]
 */
public class 最小路径和 {
	public static void main(String[] args) {
		int[][] a = {
				  {1,3,1},
				  {1,5,1},
				  {4,2,1}
		};
		System.out.println(minPathSum(a));
	}
	public static int minPathSum(int[][] a) {
        int[][] dp = new int[a.length][a[0].length];
        for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				if(i==0 && j==0) {
					dp[i][j] = a[i][j];
					continue;
				}
				if(i==0) {
					dp[i][j] = dp[i][j-1] + a[i][j];
				}else if(j==0) {
					dp[i][j] = dp[i-1][j] + a[i][j];
				}else {
					dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + a[i][j];
				}
			}
		}
		return dp[dp.length-1][dp[0].length-1];
    }
}
