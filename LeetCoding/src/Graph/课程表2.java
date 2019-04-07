package Graph;

/**
 * @author czj
 * @date   2019-04-02 16:30
 * 现在你总共有 n 门课需要选，记为 0 到 n-1。
	在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
	给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
	可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
 */
public class 课程表2 {
	public static void main(String[] args) {
		int a = 2;
		int[][] b = {
				{1,0},
				{0,1}
		};
		int[] res = findOrder(a, b);
		if(res != null) {
			for (int i = 0; i < res.length; i++) {
				System.out.print(res[i]+"-");
			}
		}
	}
	//拓扑排序
	public static int[] findOrder(int numN, int[][] a) {
		int numEdge = a.length;
        //得到每个节点的入度个数
		int[] degree = new int[numN];
		for (int i = 0; i < numEdge; i++) {
			degree[a[i][0]]++;
		}
		
		boolean[] isVis = new boolean[numN];
		int[] res = new int[numN];
		int k=0;
		while(true) {
			int i=0;
			for(; i<numN; i++) {
				if(!isVis[i] && degree[i]==0)
					break;
			}
			
			if(i==numN)
				break;
			res[k++] = i;
			isVis[i] = true;
			//更新与i节点相连接的边的度
			for (int j = 0; j < numEdge; j++) {
				int x = a[j][0];
				int y = a[j][1];
				if(y==i)
					degree[x]--;
			}
		}
		for (int i = 0; i < numN; i++) {
			if(degree[i] != 0)
				return new int[] {};
		}
		return res;
    }
}
