package BFS;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author czj
 * @date   2019-03-25 08:37
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
	每次转换只能改变一个字母。
	转换过程中的中间单词必须是字典中的单词。
	说明:
	如果不存在这样的转换序列，返回 0。
	所有单词具有相同的长度。
	所有单词只由小写字母组成。
	字典中不存在重复的单词。
	你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
	示例 1:
	输入:
	beginWord = "hit",
	endWord = "cog",
	wordList = ["hot","dot","dog","lot","log","cog"]
 */
public class 单词接龙 {
	public static void main(String[] args) {
		String beginWord = "hit";
		String endWord = "cog";
		List<String> d = Arrays.asList(new String[]{"hot","dot","dog","lot","log","cog"});
		System.out.println(ladderLength(beginWord, endWord, d));
	}
	static class State{
		String s;
		int step;
		public State(String s, int step) {
			this.s = s;
			this.step = step;
		}
	}
	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord.length() != endWord.length()) return 0;
        boolean[] isVis = new boolean[wordList.size()];
        Queue<State> q = new LinkedList<>();
        q.add(new State(beginWord, 0));
        while(!q.isEmpty()) {
        	State p = q.poll();
        	String s = p.s;
        	int step = p.step;
        	if(s.equals(endWord)) {
        		return step+1;
        	}
			for (int j = 0; j < wordList.size(); j++) {
				if(isVis[j])
					continue;
				String tmp = wordList.get(j);
				if(check(tmp,s)) {
					q.add(new State(tmp, step+1));
					isVis[j] = true;
				}
			}
        }
        return 0;
    }
	//判断两个字符串是否只有一个元素不同
	private static boolean check(String a, String b) {
		if(a.length() != b.length()) return false;
		int count = 0;
		for (int j = 0; j < a.length(); j++) {
			if(a.charAt(j)!=b.charAt(j)) {
				count++;
				if(count > 1)
					return false;
			}
		}
		return true;
	}
}
