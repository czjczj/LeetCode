package Stack;
import java.util.Stack;

/**
 * @author czj
 * @date   2019-06-28 10:06
	 给定一个经过编码的字符串，返回它解码后的字符串。
	编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
	你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
	此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
	示例:
	s = "3[a]2[bc]", 返回 "aaabcbc".
	s = "3[a2[c]]", 返回 "accaccacc".
	s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
	链接：https://leetcode-cn.com/problems/decode-string
 */
public class 字符串解码 {
	public static void main(String[] args) {
		String s = "3[a]2[bc]";
		String b = "3[z]2[2[y]pq4[2[jk]e1[f]]]ef";
		System.out.println(decodeString(s));
		System.out.println(decodeString(b));
	}
	/*
	 * 思路：这是一道堆栈的题目，
	 * 1.对于非 ' ] ' 符号都压入栈中
	 * 2. 对于 ' ] ' 符号的时候，一直压出栈到  'numbernumber..[charchar' 
	 * 计算出现在的  'numbernumber..[charchar' --> 对应的字符串，  然后将这个
	 * 字符串重新压入当前栈中，  
	 * 注意的地方：  
	 * 1.java  stack类的 pop(), 出栈以后，对应的元素后，元素将不存在，因此需要保存好对应的元素。
	 * 2.对于 numbernumbernumber这样的元素要计算对应的值
	 * 3. 对于  <--numbernumbernumber  前面的计算部分  压出栈以后要记得保存，重新压入栈中，防止出错。
	 */
	public static String decodeString(String s) {
		int n = s.length();
		if(n==0)
			return "";
        char[] sc = s.toCharArray();
        Stack<Character> st = new Stack<>();
        String rtn = "";
        for(char c:sc) {
        	if(c==']') {
        		String tmp = "";
        		char cc = st.pop();
        		while(cc != '[') {
        			tmp = cc+tmp;
        			cc = st.pop();
        		}
        		cc = st.pop();//得到数字
        		int sum = 0;
        		int idx = 0;
        		while(true) {
        			sum += (cc-'0')*Math.pow(10, idx);
        			idx += 1;
        			if(st.isEmpty()) {
        				break;
        			}
        			cc = st.pop();
        			if(cc=='[' || cc<'0'|| cc>'9') {
        				st.push(cc);
        				break;
        			}
        		}
        		String res = "";
        		for(int i=0; i<sum; i++)
        			res = res+tmp;
        		char[] tch = res.toCharArray();
        		for(char ccc:tch)
        			st.push(ccc);
        	}else {
        		st.push(c);
        	}
        	
        }
    	while(!st.isEmpty())
    		rtn = st.pop()+rtn;
		return rtn;
    }
}
