package Graph;
import org.omg.CORBA.UnionMember;

/**
 * @author czj
 * @date   2019-03-25 09:15
 *	 现在你总共有 n 门课需要选，记为 0 到 n-1。
	在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
	给定课程总量以及它们的先决条件，判断是否可能完成所有课程的学习？
	示例 1:
	输入: 2, [[1,0]] 
	输出: true
	解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
	示例 2:
 */
public class 课程表 {
	public static void main(String[] args) {
		int a = 4;
		int[][] b = {
				{2,0},
				{1,0},
				{3,1},
				{3,2},
				{1,3}
				
		};
		System.out.println(canFinish(a, b));
	}
	//判断一个图中是否存在环即可， 这里采用拓扑排序
	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		int n = prerequisites.length;
		//记录每个节点的入度  
		int[] a = new int[numCourses];
		for (int i = 0; i < numCourses; i++) {
			a[i] = 0;//初始化每个节点的度为0
		}
		for (int i = 0; i < n; i++) {
			a[prerequisites[i][0]]++;
		}
		
		
		boolean[] isVis = new boolean[numCourses];
		//找到一个度为0的节点
		while(true) {
			int i=0;
			for (; i < numCourses; i++) {
				if(!isVis[i] && a[i]==0)
					break;
			}
			if(i==numCourses)
				break;
			isVis[i] = true;
			//更新与之连接的边的节点
			for(int k=0; k<n; k++) {
				int x = prerequisites[k][0];
				int y = prerequisites[k][1];
				if(y==i)
					a[x]--;
			}
		}
		for (int k = 0; k < numCourses; k++) {
			if(a[k] != 0)
				return false;
		}
		return true;
    }
}
