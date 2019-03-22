package DFS;
import java.util.List;

/**
 * @author czj
 * @date   2019-03-21 16:42
 *	有 N 个房间，开始时你位于 0 号房间。每个房间有不同的号码：0，1，2，...，N-1，并且房间里可能有一些钥匙能使你进入下一个房间。
	在形式上，对于每个房间 i 都有一个钥匙列表 rooms[i]，每个钥匙 rooms[i][j] 由 [0,1，...，N-1] 中的一个整数表示，
	其中 N = rooms.length。 钥匙 rooms[i][j] = v 可以打开编号为 v 的房间。
	最初，除 0 号房间外的其余所有房间都被锁住。
	你可以自由地在房间之间来回走动。
	如果能进入每个房间返回 true，否则返回 false。
 */
public class 钥匙和房间 {
	public static void main(String[] args) {
	}
	static boolean[] isV = null;
	/**
	 * 思路：dfs对于每一个集合遍历一遍，然后判断最后每一个位置是否遍历到了即可
	 */
	public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
		isV = new boolean[rooms.size()];
		isV[0] = true;
        dfs(0,rooms);
        for (int i = 0; i < isV.length; i++) {
			if(!isV[i])
				return false;
		}
		return true;
    }
	private static void dfs(int idx, List<List<Integer>> r) {
		List<Integer> ls = r.get(idx);
		for (int i = 0; i < ls.size(); i++) {
			if(!isV[ls.get(i)]) {
				isV[ls.get(i)] = true;
				dfs(ls.get(i), r);
			}
		}
	}
}
