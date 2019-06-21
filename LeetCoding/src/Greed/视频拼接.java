package Greed;
import java.util.Arrays;

/**
 * @author czj
 * @date   2019-04-07 17:29
你将会获得一系列视频片段，这些片段来自于一项持续时长为 T 秒的体育赛事。这些片段可能有所重叠，也可能长度不一。
视频片段 clips[i] 都用区间进行表示：开始于 clips[i][0] 并于 clips[i][1] 结束。我们甚至
可以对这些片段自由地再剪辑，例如片段 [0, 7] 可以剪切成 [0, 1] + [1, 3] + [3, 7] 三部分。
我们需要将这些片段进行再剪辑，并将剪辑后的内容拼接成覆盖整个运动过程的片段（[0, T]）。
返回所需片段的最小数目，如果无法完成该任务，则返回 -1 。
输入：clips = [[0,2],[4,6],[8,10],[1,9],[1,5],[5,9]], T = 10
输出：3
解释：
我们选中 [0,2], [8,10], [1,9] 这三个片段。
然后，按下面的方案重制比赛片段：
将 [1,9] 再剪辑为 [1,2] + [2,8] + [8,9] 。
现在我们手上有 [0,2] + [2,8] + [8,10]，而这些涵盖了整场比赛 [0, 10]。
 */
public class 视频拼接 {
	public static void main(String[] args) {
		int[][] clips = {{0,2},{4,6},{8,10},{1,9},{1,5},{5,9}};
		int t = 10;
		int[][] clips1 = {{0,1},{1,2}};
		int t1 = 5;
		System.out.println(videoStitching(clips1,t1));
		System.out.println(videoStitching(clips,t));
	}
	/*
	 * 思路：贪心算法：
	 * 在每一次循环中，在没有观察的clips中 寻找满足下列条件的clips[i],  假设当前的视频包含的区间为   [left, right]
	 * 1.clips[i]的第一个元素 <= right。   更新当前的maxRight = max(clips[i][1], maxRight)
	 * 循环结束后更新  right = maxRight  进行下一次循环
	 * 结束操作的终止条件为  left==0  && rigth>=T
	 */
	static int T = 0;
	public static int videoStitching(int[][] clips, int t) {
		T = t;
		boolean[] isVis = new boolean[clips.length];
		int res = dfs(0,0,clips,isVis);
		return res;
    }

	private static int dfs(int s, int e, int[][] a, boolean[] isVis) {
		if(s==0 && e>=T)
			return 0;
		int maxe = e;
		int idx = -1;
		for(int i=0; i<a.length; i++) {
			if(isVis[i])
				continue;
			int cs = a[i][0];
			int ce = a[i][1];
			if(cs <= e) {
				idx = i;
				maxe = Math.max(maxe, ce);
			}	
		}
		if(idx == -1)
			return -1;
		else
			isVis[idx] = true;
		int val = dfs(s,maxe,a,isVis);
		if(val == -1)
			return -1;
		return val+1;
	}
}
