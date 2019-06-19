package DFS;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author czj
 * @date   2019-06-15 19:35
 * 
 * 我们给出了 N 种不同类型的贴纸。每个贴纸上都有一个小写的英文单词。
	你希望从自己的贴纸集合中裁剪单个字母并重新排列它们，从而拼写出给定的目标字符串 target。
	如果你愿意的话，你可以不止一次地使用每一张贴纸，而且每一张贴纸的数量都是无限的。
	拼出目标 target 所需的最小贴纸数量是多少？如果任务不可能，则返回 -1。
	输入：	
	["with", "example", "science"], "thehat"
	输出：
	3
 */
public class 贴纸拼词_hard {
	public static void main(String[] args) {
		String[] s1 = {"these","guess","about","garden","him"};
		String t1 = "atomher";
		String[] s = {"fly","me","charge","mind","bottom"};
		String t = "centorder";
		System.out.println(minStickers(s1,t1));
	}
	/**
	 * 思路：  首先我们想到的是dfs操作，每一次才dfs中选择一个单词，使用现在的target中的
	 * 单词去减去该单词中包含的数字就可以了，我们仔细想一想其实我们这个过程中画图可以知道有许多
	 * 的冗余存在，这个冗余是target中单词数  减去  一个dfs中 减去单词A后  剩余的单词数可能  和  减去
	 * 单词B以后的结果相同，这个时候我们相当于做了一次重复的计算，显然是没有必要的，这就是这个问题的冗余所在。
	 */
	public static int minStickers(String[] s, String t) {
		Map<String, Integer> dp = new HashMap<>();//键表示target减去单词后的target , 值：需要的最小操作数目
		//统计每一个单词的 [26]维度向量
		int[][] dictVec = new int[s.length][26];
		for(int i=0; i<dictVec.length; i++) {
			for(char c:s[i].toCharArray()) {
				dictVec[i][c-'a']++;
			}
		}
		dp.put("", 0);
		return dfs(t,dictVec,dp);
    }

	private static int dfs(String t, int[][] dict, Map<String, Integer> dp) {
		if(dp.containsKey(t))//如果已经包含该字符串直接返回值
			return dp.get(t);//当t最后的最后能够有dict得到的时候  t=""  将返回0
		int minRes = Integer.MAX_VALUE;
		int cnt = dict.length;
		//统计现有的字符个数
		int[] tchar = new int[26];
		char[] ch = t.toCharArray();
		for(char c:ch) {
			tchar[c-'a']++;
		}
		
		for(int i = 0; i < cnt; i++) {
			//如果当前字符没有 target[0] 这个字符则直接继续下一步
			if(dict[i][ch[0]-'a']==0)
				continue;
			String newTar = "";
			for(int j=0; j<26; j++) {
				tchar[j] -= dict[i][j];
				for(int k=0; k<tchar[j]; k++) {
					System.out.print((char)('a'+j)+":"+tchar[j]+" ");
					newTar += (char)('a'+j);
				} 
				tchar[j] += dict[i][j];//重点这里一定要有回溯，妈的在这里查看代码的问题画了一个多小时
			}
			System.out.println();
			int res = dfs(newTar,dict,dp);
			if(res != -1)
				minRes = Math.min(minRes, res+1);
		}
		
		dp.put(t, (minRes==Integer.MAX_VALUE)?-1:minRes);
		return dp.get(t);
	}
}

