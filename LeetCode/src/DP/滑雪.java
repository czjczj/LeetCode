package DP;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
 * ��һ����������Ļ��¡�������һ����ά��������������ÿ�����ִ����ĸ߶�
4 5
1   2  3  4 5
14 15 16 17 6
13 20 19 18 7
12 11 10  9 8
*
 */
public class 滑雪 {
	static int rowNum = 0;
	static int colNum = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		rowNum = sc.nextInt();
		colNum = sc.nextInt();
		int[][] dp = new int[rowNum][colNum];
		int[][] a = new int[rowNum][colNum];
		Node[] nodes = new Node[rowNum*colNum];
		for(int i = 0; i < rowNum; ++i) {
			for(int j = 0; j < colNum; ++j) {
				int hei = sc.nextInt();
				dp[i][j] = 1;
				a[i][j] = hei;
				nodes[i*colNum+j] = new Node(i, j, hei);
			}
		}
		
		Arrays.sort(nodes);
		//����Ϊ��
		for(int k = 0; k < nodes.length; k++) {
			Node n = nodes[k];
			int i = n.i; int j = n.j; int h = n.height;
			System.out.println(h);
			if(i+1<rowNum && h<a[i+1][j]) {
				dp[i+1][j] = Math.max(dp[i][j]+1, dp[i+1][j]);
			}
			if(i-1>=0 && h<a[i-1][j]) {
				dp[i-1][j] = Math.max(dp[i][j]+1, dp[i-1][j]);
			}
			if(j+1<colNum && h<a[i][j+1]) {
				dp[i][j+1] = Math.max(dp[i][j]+1, dp[i][j+1]);
			}
			if(j-1>=0 && h<a[i][j-1]) {
				dp[i][j-1] = Math.max(dp[i][j]+1, dp[i][j-1]);
			}
		}
		
		int a1 = -1;
		for(int i = 0; i < rowNum; i++) {
			for(int j = 0; j < colNum; j++) {
				a1 = Math.max(a1, dp[i][j]);
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println(a1);
	}
}

class Node implements Comparable<Node>{
	int i;
	int j; 
	int height;

	public Node(int i, int j, int height) {
		super();
		this.i = i;
		this.j = j;
		this.height = height;
	}
	@Override
	public int compareTo(Node o) {
		if(this.height == o.height)
			return 0;
		else
			return this.height > o.height?1:-1;
	};			
}
