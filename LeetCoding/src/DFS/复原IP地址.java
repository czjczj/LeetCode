package DFS;
import java.util.ArrayList;
import java.util.List;

/**
 * @author czj
 * @date   2019-04-18 20:56
 */
public class 复原IP地址 {
	public static void main(String[] args) {
//		String s = "25525511135";
//		String s = "0000";
		String s = "010010";
		List<String> res = restoreIpAddresses(s);
		for (int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i));
		}
	}
	static List<String> ls = null;
	static String s = null;
	public static List<String> restoreIpAddresses(String a) {
		if(a.length() == 0)
            return new ArrayList<>();
		ls = new ArrayList<>();
		s = a;
        StringBuffer sb = new StringBuffer();
        int n = s.length();
        dfs(0,-1,0,sb);//idx,sum,cnt(点的个数)
		return ls;
    }
	private static void dfs(int idx, int sum, int cnt, StringBuffer sb) {
		if(cnt>=4)
			return;

		if(idx==s.length()) {
			ls.add(new String(sb));
			return;
		}
		double d = (s.length()-idx)/(4-cnt);
		if(((s.length()-idx)<=(3-cnt)) || d>3.0) {
			return;
		}
		
		
		
		char ch = s.charAt(idx);
		if(sum==0)
			return;
		if(sum == -1)
			sum += 1;
		int tmp = sum*10+Integer.parseInt(ch+"");
		//该字符后面加点
		if(tmp <= 255) {
			sb.append(ch);
			sb.append('.');
			dfs(idx+1,-1,cnt+1,sb);
			sb.delete(sb.length()-1, sb.length());
			
			dfs(idx+1,tmp,cnt,sb);
			sb.delete(sb.length()-1, sb.length());
		}
	}
}
