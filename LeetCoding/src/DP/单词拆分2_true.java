package DP;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author czj
 * @date   2019-03-05 10:49
 */

//算法的整体思路，首先判断给出的字符串能否由wordDict进行拆分，
//如果可以拆分的话，那么剩下的字符串则dfs，过程寻找子串的大小，如果已经知道了dp[i]表示s[0...i]串可以有
//wordDict拆分，那么下一次移动的位置，只能够是min_len到wordDict之间，避免了每次移动一大步产生的时间浪费
public class 单词拆分2_true {
	static List<String> ans = new ArrayList<>();
    static Set<String> set = new HashSet<>();
    static int maxLen = 0;
    static boolean[] dp;
    static String s;
    
    public static void main(String[] args) {
    	String s = "pineapplepenapple";
		List<String> wordDict = Arrays.asList(new String[]{"apple", "pen", "applepen", "pine", "pineapple"}) ;
//		List<String> res = wordBreak(s, wordDict);
		List<String> res = wordBreak("catsanddog",
				Arrays.asList(new String[] {"cat","cats","and","sand","dog"}));
		for (int i = 0; i < res.size(); i++) {
			System.out.println("-->"+res.get(i)+"<--");
		}
	}
    
    public static List<String> wordBreak(String ss, List<String> wordDict) {
    	s = ss;
        dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (String word : wordDict) {
            set.add(word);
            maxLen = Math.max(maxLen, word.length());
        }            
        
        for (int i = 0; i < s.length(); i++) {
            if (dp[i]) {
                for (int j = i + 1; j <= Math.min(i + maxLen, s.length()); j++) {
                    if (set.contains(s.substring(i, j)))
                        dp[j] = true;
                }                
            }
        }
        if (dp[dp.length - 1]) split(new StringBuilder(), 0);
        return ans;
    }
    
    private static void split(StringBuilder sb, int start) {
        if (start >= s.length()) {
            ans.add(sb.substring(0, sb.length() - 1));
            return;
        }        
        if (dp[start]) {
            System.out.println(start);
            for (int i = start + 1; i <= Math.min(start + maxLen, s.length()); i++) {
                String word = s.substring(start, i);
                if (set.contains(word)) {
                    sb.append(word + " ");
                    split(sb, i);
                    sb.delete(sb.length() - 1 - word.length(), sb.length());
                }
            }
        }
    }
}
