package Competition;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author czj
 * @date   2019-04-07 15:12
 */
public class 删除最外层的括号 {
	public static void main(String[] args) {
		System.out.println(removeOuterParentheses("(()())(())(()(()))"));
	}
	public static String removeOuterParentheses(String a) {
		char[] ch = a.toCharArray();
	    StringBuffer ss = new StringBuffer();
	    Stack<Character> s = new Stack<>();
	    boolean flag = true;
	    for (int i = 0; i < ch.length; i++) {
			if(ch[i]=='(' && flag) {
				flag = false;
				continue;
			}
			if(ch[i]=='(') {
				ss.append(ch[i]);
				s.push(ch[i]);
			}
			if(ch[i]==')'&&s.isEmpty()) {
				flag = true;
				continue;
			}
			if(ch[i]==')') {
				ss.append(ch[i]);
				s.pop();
			}
		}
		return new String(ss);
	}
}
