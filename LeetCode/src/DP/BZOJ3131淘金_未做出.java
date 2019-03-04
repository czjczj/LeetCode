package DP;

/**
 * @author czj
 * @date   2019年2月21日
 * 
 * 小Z在玩一个叫做《淘金者》的游戏。游戏的世界是一个二维坐标。X轴、Y轴坐标范围均为1..N。初始的时候，所有的整数坐标点上均有一块金子，共N*N块。
    一阵风吹过，金子的位置发生了一些变化。细心的小Z发现，初始在(i，j)坐标处的金子会变到(f(i)，fIj))坐标处。其中f(x)表示x各位数字的乘积，例如f(99)=81，
    f(12)=2，f(10)=0。如果金子变化后的坐标不在1..N的范围内，我们认为这块金子已经被移出游戏。同时可以发现，对于变化之后的游戏局面，某些坐标上的金子数量可能不止一块，
         而另外一些坐标上可能已经没有金子。这次变化之后，游戏将不会再对金子的位置和数量进行改变，玩家可以开始进行采集工作。
    小Z很懒，打算只进行K次采集。每次采集可以得到某一个坐标上的所有金子，采集之后，该坐标上的金子数变为0。
    现在小Z希望知道，对于变化之后的游戏局面，在采集次数为K的前提下，最多可以采集到多少块金子？
    答案可能很大，小Z希望得到对1000000007(10^9+7)取模之后的答案。

 */
public class BZOJ3131淘金_未做出 {
	public static void main(String[] args) {
		System.out.println(longestPalindrome("asfd"));
		System.out.println("".toCharArray().length);
		System.out.println("fda");
	}
	public static String longestPalindrome(String s) {
        char[] ch = s.toCharArray();
        int len = s.length();
        int[][] dp = new int[len][len];
        //初始化dp
        for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				dp[i][j] = -1;
			}
		}
        
        for (int i = 0; i < len; i++) {
			dp[i][i] = 1;
		}
        for (int i = len-2; i >= 0; i--) {
			for (int j = i+1; j < len; j++) {
				if(j-i == 1) {
					if(ch[i] == ch[j])
						dp[i][j] = 2;
					else
						dp[i][j] = 0;
				}
				if(j-i >= 2) {
					if(ch[i] == ch[j]) 
						dp[i][j] = dp[i+1][j-1]>0?dp[i+1][j-1]+2:0;
					else
						dp[i][j] = 0;
				}
			}
		}
        
        int max = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				if(max < dp[i][j]) {
					start = i;
					end = j;
				}
				max = Math.max(max, dp[i][j]);
			}
		}
		return s.substring(start, end+1);
    }
}
