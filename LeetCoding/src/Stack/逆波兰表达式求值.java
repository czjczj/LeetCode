package Stack;
import java.util.Stack;
import java.util.regex.Pattern;

/**
 * @author czj
 * @date   2019-04-19 10:11
 */
public class 逆波兰表达式求值 {
	public static void main(String[] args) {
		String[] str = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
		System.out.println(evalRPN(str));
	}
	public static int evalRPN(String[] a) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < a.length; i++) {
        	char c = a[i].toCharArray()[0];
			if(a[i].length()>1 || (c>='0'&&c<='9')) {
				stack.push(Integer.parseInt(a[i]));
			}else {
				int n2 = stack.pop();
				int n1 = stack.pop();
				if(c == '+') {
					stack.push(n1+n2);
				}
				if(c == '-') {
					stack.push(n1-n2);
				}
				if(c == '*') {
					stack.push(n1*n2);
				}
				if(c == '/') {
					stack.push(n1/n2);
				}
			}
		}
        return stack.pop();
    }
	public static boolean isInteger(String str) {  
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]+$");  
        return pattern.matcher(str).matches();  
	}
}
