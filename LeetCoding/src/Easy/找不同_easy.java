package Easy;

/**
 * @author czj
 * @date   2019-06-28 09:58
	  给定两个字符串 s 和 t，它们只包含小写字母。
	字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
	请找出在 t 中被添加的字母。
	示例:
	输入：
	s = "abcd"
	t = "abcde"
	输出：
	e
	解释：
	'e' 是那个被添加的字母。
	链接：https://leetcode-cn.com/problems/find-the-difference
 */
public class 找不同_easy {
	public static void main(String[] args) {

	}
	public char findTheDifference(String s, String t) {
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        int[] ss = new int[26];
        int[] tt = new int[26];
        for(char c:sc){
            ss[c-'a']++;
        }
        for(char c:tc){
            tt[c-'a']++;
        }
        char a='a';
        for(int i=0; i<26; i++){
            tt[i] -= ss[i];
            if(tt[i] != 0){
                a = (char)(a+i);
                break;
            }
        }
        return a;
    }
}
