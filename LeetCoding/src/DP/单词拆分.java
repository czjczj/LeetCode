package DP;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author czj
 * @date   2019-03-04 19:36
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
	说明：	
	拆分时可以重复使用字典中的单词。
	你可以假设字典中没有重复的单词。
 */
public class 单词拆分 {
	public static void main(String[] args) {
		String[] wordDict = new String[] {"leet", "code"};
		String s = "leetcode";
		List<String> a = Arrays.asList(wordDict);
//		System.out.println(wordBreak(s, a));//true
//		System.out.println(wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));//false
		System.out.println(wordBreak2("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));//false
		System.out.println(wordBreak2(s,a));//false
	}
	
	/**
	 * 递归的方法，这种方法超时
	 */
	public static boolean wordBreak(String s, List<String> a) {
		if(s.length() == 0) return true;
		boolean res = false;
		for (int i = 0; i < a.size(); i++) {
			String tmp = a.get(i);
			if(s.startsWith(tmp)) {
				boolean b = wordBreak(s.substring(tmp.length()), a);
				if(b) {
					return true;
				}
			}
		}
		return res;
    }
	
	/**
	 * DP：
	 * dp[i]表示s[0...i]能否有wordDict构成
	 * 这个时候很显然有s[0...i]如果以wordDict中的某一个子串结尾的话，那么dp[i] = dp[i]||dp[i-子串的长度]
	 * 特别的dp[0]即i-子串的长度为0的时候返回true
	 */
	public static boolean wordBreak2(String s, List<String> a) {
		int n = s.length();
		boolean[] dp = new boolean[n];
		//找到a中的max_len, min_len;
		int max_len = 0;
		int min_len = Integer.MIN_VALUE-1;
		for (int i = 0; i < a.size(); i++) {
			max_len = Math.max(a.get(i).length(), max_len);
			min_len = Math.min(a.get(i).length(), min_len);
		}
//		System.out.println(max_len+" "+min_len);
		for (int i = min_len-1; i < n; i++) {
			for (int j = 0; j < a.size(); j++) {
				if(s.substring(0, i+1).endsWith(a.get(j))) {
					if(i+1-a.get(j).length() == 0)
						dp[i] = true;
					else
						dp[i] = dp[i] || dp[i-a.get(j).length()];
				}
			}
		}
		return dp[n-1];
	}
}
