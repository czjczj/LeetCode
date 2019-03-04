package DP;
/**
 * @author czj
 * @date   2019锟斤拷2锟斤拷25锟斤拷
 *        锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷 word1 锟斤拷 word2锟斤拷锟斤拷锟斤拷锟斤拷锟� word1 转锟斤拷锟斤拷 word2 锟斤拷使锟矫碉拷锟斤拷锟劫诧拷锟斤拷锟斤拷 锟斤拷
	锟斤拷锟斤拷远锟揭伙拷锟斤拷锟斤拷式锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷植锟斤拷锟斤拷锟�	
	1.锟斤拷锟斤拷一锟斤拷锟街凤拷
	2.删锟斤拷一锟斤拷锟街凤拷
	3.锟芥换一锟斤拷锟街凤拷
	fdas
 */
public class 编辑距离 {
	public static void main(String[] args) {
		String s1 = "intention";
		String s2 = "execution";
		System.out.println(minDistance(s1, s2));
	}
	
	/**
	 * 锟斤拷确锟斤拷锟�
	 */
	public static int True(String word1, String word2) {
		int m = word1.length();
        int n = word2.length();

        //dp[i][j] 锟斤拷锟斤拷锟斤拷小锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟借）锟斤拷锟斤拷 word1[0..i-1]转锟斤拷为 word2[0..j-1].
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for(int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }
        return dp[m][n];
	}
	
	/**
	 * 锟揭的达拷锟斤拷锟斤拷
	 */
	public static int minDistance(String word1, String word2) {
        char[] a = word1.toCharArray();
        char[] b = word2.toCharArray();
        int m = a.length;
        int n = b.length;
        if(m==0 || n==0)
        	return m>n?m:n;
        //dp[i][j] 锟斤拷示 word1[0...i]锟斤拷word2[0...j]锟斤拷锟斤拷小锟斤拷锟斤拷锟斤拷
        int[][] dp = new int[m][n];

        
        for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(i==0 && j==0) {
					dp[i][j] = (a[i]==b[j])?0:1;
				}else if(i==0) {
					dp[i][j] = (a[i]==b[j])?dp[i][j-1]:dp[i][j-1]+1;
				}else if(j==0) {
					dp[i][j] = (a[i]==b[j])?dp[i-1][j]:dp[i-1][j]+1;
				}else {
					dp[i][j] = (a[i]==b[j])?dp[i-1][j-1]:Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]))+1;
				}
			}
		} 
		return dp[m-1][n-1];
    }
}
