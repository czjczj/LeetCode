package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author czj
 * @date   2019��3��3��
 * ����һ�������Σ��ҳ��Զ����µ���С·���͡�ÿһ��ֻ���ƶ�����һ�������ڵĽ���ϡ�
���磬���������Σ�
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
�Զ����µ���С·����Ϊ 11������2 + 3 + 5 + 1 = 11����
 */
public class 三角形的最小路径和 {
	public static void main(String[] args) {
		List<List<Integer>> a = new ArrayList<>();
		a.add(new ArrayList<>(Arrays.asList(2)));
		a.add(new ArrayList<>(Arrays.asList(3,4)));
		a.add(new ArrayList<>(Arrays.asList(6,5,7)));
		a.add(new ArrayList<>(Arrays.asList(4,1,8,3)));
		System.out.println(minimumTotal(a));
		
	}
	/**
	 * ˼·��
	 * ����һ����triangle������ͬ������a[m][n],���α���������¼�����������֣������һ�У�a[m-1][0...n-1]����ѡȡ��С�����ּ���
	 * 1.��ʼa[i][0]+=a[i-1][0],a[i][i]+=a[i-1][i-1] ÿһ�еĵ�һ�����ֺ����һ�����ִ�����������ֻ��һ�����ֺ�������
	 * 2.a[i][j] += min(a[i-1][j],a[i-1][j-1]) ʣ�µ�����ÿ�����ֶ�Ҫ�������������ڣ�ѡȡ��С��һ����������
	 */
	public static int minimumTotal(List<List<Integer>> triangle) {
		int m = triangle.size();
		int n = triangle.get(m-1).size();
        int[][] a = new int[m][n];
        
        for(int i = 0; i<a.length; i++) {
        	for (int j = 0; j <= i; j++) {
        		a[i][j] = triangle.get(i).get(j);
			}
        }
        
        for (int i = 1; i < a.length; i++) {
			a[i][0] += a[i-1][0]; 
			a[i][i] += a[i-1][i-1];
		}
        for(int i = 2; i<a.length; i++) {
        	for (int j = 1; j < i; j++) {
				a[i][j] += (a[i-1][j]<a[i-1][j-1])?a[i-1][j]:a[i-1][j-1];
			}
        }
        
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
        	min = Math.min(a[m-1][i], min);
		}
        return min;
    }
}
