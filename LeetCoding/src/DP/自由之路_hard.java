package DP;
import java.util.HashMap;
import java.util.Map;

/**
 * @author czj
 * @date   2019-04-09 20:32
 */
public class 自由之路_hard {
	public static void main(String[] args) {
		String ring = "xrrakuulnczywjs";
		String key = "jrlucwzakzussrlckyjjsuwkuarnaluxnyzcnrxxwruyr";
		System.out.println(findRotateSteps(ring, key));
	}
	static Map<Pair, Integer> map = null;
	public static int findRotateSteps(String ring, String key) {
		map = new HashMap<>();
        char[] ch = key.toCharArray();
        int n = ch.length;
//        int res = dfs(0,ch,ring);
        int res = dfs(new Pair(0,ring),ch);
		return res;
    }
	private static int dfs(Pair p,char[] ch) {
		if(p.idx==ch.length)
			return 0;
		if(map.containsKey(p)) return map.get(p);
		int res = Integer.MAX_VALUE;
		int start = p.ring.indexOf(ch[p.idx]+"");
		int end = p.ring.lastIndexOf(ch[p.idx]+"");
		
		res = Math.min(res,start+1+dfs(new Pair(p.idx+1,p.ring.substring(start, p.ring.length())+p.ring.substring(0,start)),ch));
		res = Math.min(res, p.ring.length()-end+1+dfs(new Pair(p.idx+1,p.ring.substring(end, p.ring.length())+p.ring.substring(0,end)),ch));
		map.put(p, res);
		return res;
	}
	static class Pair {
		int idx;
		String ring;
		public Pair(int idx, String s) {
			this.idx = idx;
			this.ring = s;
		}
		@Override
		public boolean equals(Object obj) {
            Pair p = (Pair) obj;
            return p.ring.equalsIgnoreCase(this.ring) && (p.idx==this.idx);
		}
		@Override
		public int hashCode() {
			return  ring!=null&&idx!=0?ring.hashCode()+((Integer)idx).hashCode():0;
		}
	}
//	private static int dfs2(int idx, char[] ch, String ring) {
//		if(idx==ch.length)
//			return 0;
//		if(map.containsKey()) return map.get(ring);
//		int res = Integer.MAX_VALUE;
//		int start = ring.indexOf(ch[idx]+"");
//		int end = ring.lastIndexOf(ch[idx]+"");
//		
//		res = Math.min(res,start+1+dfs(idx+1,ch,ring.substring(start, ring.length())+ring.substring(0,start)));
//		res = Math.min(res, ring.length()-end+1+dfs(idx+1,ch,ring.substring(end, ring.length())+ring.substring(0,end)));
//		map.put(new Pair(idx, ring), res);
//		return res;
//	}
//		dfs(idx+1,ch,ring.substring(start, ring.length())+ring.substring(0,start));
//		dfs(idx+1,ch,ring.substring(end, ring.length())+ring.substring(0,end));
}
