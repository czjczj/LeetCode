package DP;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author czj
 * @date   2019-03-05 09:34
 */
public class 单词拆分2_my {
	public static void main(String[] args) {
		String s = "pineapplepenapple";
		List<String> wordDict = Arrays.asList(new String[]{"apple", "pen", "applepen", "pine", "pineapple"}) ;
//		List<String> res = wordBreak2(s, wordDict);
		List<String> res = wordBreak2("catsanddog",
				Arrays.asList(new String[] {"cat","cats","and","sand","dog"}));
		for (int i = 0; i < res.size(); i++) {
			System.out.println("-->"+res.get(i)+"<--");
		}
	}
	/**
	 * DP(仍然超时，？？？？)
	 * dp[i]为一个List<String>，保存的是s[0....i]这个子串可以拆分的String的集合，
	 * 那么 当我们要求dp[i]时，此时dp[i]以字典中的str1结尾的时候，那么dp[i] = dp[i-str1.length]中的每一个元素+str1,
	 * 组成新的dp[i]
	 */
	public static List<String> wordBreak2(String s, List<String> a) {
		int max_len = 0;
		int min_len = Integer.MAX_VALUE-1;
		int n = s.length();
		for (int i = 0; i < a.size(); i++) {
			max_len = Math.max(max_len, a.get(i).length());
			min_len = Math.min(min_len, a.get(i).length());
		}
		List<String>[] dp = new ArrayList[n];
		for (int i = 0; i < dp.length; i++) {
			dp[i] = new ArrayList<>();
		}
		for (int i = min_len-1; i < n; i++) {
			for (int j = 0; j < a.size(); j++) {
				String tmp = a.get(j);
				String stmp = s.substring(0, i+1);
				if(stmp.endsWith(tmp)) {
					if(stmp.length() == tmp.length()) {
						dp[i].add(tmp);
					}else {
						dp[i] = combine(dp[i], dp[i-tmp.length()], tmp);
					}
				}
			}
		}
		return dp[n-1];
    }
	
	/**
	 */
	private static List<String> combine(List<String> t, List<String> s, String tmp) {
		if(s.size()==0) return t;
		for (int i = 0; i < s.size(); i++) {
			t.add(s.get(i)+" "+tmp);
		}
		return t;
	}
	
	/**
	 * 方法一
	 * 暴力破解出现timeout
	 */
	public static List<String> wordBreak(String s, List<String> a) {
        List<String> arr = new ArrayList<>();
        String tmp = "";
        dfs(arr, tmp, s, a);
		return arr;
    }
	/**
	 */
	private static void dfs(List<String> arr, String sb, String s, List<String> a) {
		if(s.length() == 0) {
			arr.add(sb.trim());
			return;
		}
		for (int i = 0; i < a.size(); i++) {
			String t = a.get(i);
			if(s.startsWith(t)) {
				dfs(arr,sb+" "+t, s.substring(t.length()), a);
			}
		}
	}
}
