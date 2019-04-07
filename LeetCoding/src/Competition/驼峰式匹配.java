package Competition;
import java.util.ArrayList;
import java.util.List;

/**
 * @author czj
 * @date   2019-04-07 16:10
 * 如果我们可以将小写字母插入模式串 pattern 得到待查询项 query，那么待查询项与给定模式串匹配。
 * （我们可以在任何位置插入每个字符，也可以插入 0 个字符。）
给定待查询列表 queries，和模式串 pattern，返回由布尔值组成的答案列表 answer。
只有在待查项 queries[i] 与模式串 pattern 匹配时， answer[i] 才为 true，否则为 false。
输入：queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FB"
输出：[true,false,true,true,false]
示例：
"FooBar" 可以这样生成："F" + "oo" + "B" + "ar"。
"FootBall" 可以这样生成："F" + "oot" + "B" + "all".
"FrameBuffer" 可以这样生成："F" + "rame" + "B" + "uffer".
 */
public class 驼峰式匹配 {
	public static void main(String[] args) {
		System.out.println(check("FooBar", "FB"));
		System.out.println(check("FooBarTest", "FB"));
		System.out.println(check("FooBar", "FoBaT"));
		System.out.println(check("ForceFeedBack", "FoBaT"));
	}
	public static List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ls = new ArrayList<Boolean>();
        int n = queries.length;
        for (int i = 0; i < n; i++) {
			if(check(queries[i], pattern)) {
				ls.add(true);
			}else {
				ls.add(false);
			}
		}
		return ls;
    }
	private static boolean check(String tar, String pat) {
		int j = 0;
		boolean[] b = new boolean[pat.length()];
		for(int i=0; i<pat.length(); i++) {
			char c = pat.charAt(i);
			while(j<tar.length() && tar.charAt(j)!=c && Character.isLowerCase(tar.charAt(j))) 
				j++;
			if(j>=tar.length()) {
				return false;
			}else if(tar.charAt(j) == c) {
				b[i] = true;
				j++;
				continue;
			}else {
				return false;
			}
		}
		for (; j < tar.length(); j++) {
			if(!Character.isLowerCase(tar.charAt(j)))
					return false;
		}
		return true;
	}
}
