package DataStructure;

/**
 * @author czj
 * @date   2019-03-30 10:22
 */
public class 并查集数据结构 {
	static int[] pre = new int[1000];
	static int[] rank = new int[1000];
	public static void main(String[] args) {
		
		init(20);//初始化操作
		int p = find(2);//查找某个元素的父节点
		boolean b = isSame(2,3);//查看两个元素是否是同一个连通分支
		union(2,3);//合并两个节点的联通分支
	}
	private static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x==y)
			return;
		if(rank[x]>rank[y]) {//x的树的深度大于y的树的深度
			pre[y] = x;
		}else {
			if(rank[x] == rank[y]) {
				rank[y]++;
			}
			pre[x] = y;
		}
	}

	private static boolean isSame(int x, int y) {
		return find(x)==find(y);
	}

	private static int find(int k) {
		if(pre[k] == k)
			return k;
		return pre[k] = find(pre[k]);
	}
	public static void init(int k) {
		for (int i = 0; i <= k; i++) {
			pre[i] = i;
			rank[i] = 1;
		}
	}
}
