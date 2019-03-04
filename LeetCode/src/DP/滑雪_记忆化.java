package DP;
import java.util.Arrays;
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
public class 滑雪_记忆化 {
	static int rowNum = 0;
	static int colNum = 0;
	static int[][] dp;
	static int[][] a;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		rowNum = sc.nextInt();
		colNum = sc.nextInt();
		dp = new int[rowNum][colNum];
		a = new int[rowNum][colNum];
		for(int i = 0; i < rowNum; ++i) {
			for(int j = 0; j < colNum; ++j) {
				int hei = sc.nextInt();
				dp[i][j] = -1;
				a[i][j] = hei;
			}
		}
		
		int max_s = 0;
		for(int i = 0; i < rowNum; ++i) {
			for(int j = 0; j < colNum; ++j) {
				max_s = Math.max(max_s, DP(i,j));
			}
		}
		
		for(int i = 0; i < rowNum; i++) {
			for(int j = 0; j < colNum; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println(max_s);
		
	}
	
	
	static int[] dix = {0,0,1,-1};
	static int[] diy = {1,-1,0,0};
	//�ݹ���仯����
	private static int DP(int i, int j) {
		if(dp[i][j] != -1)
			return dp[i][j];
		
		dp[i][j] = 1;
		//����Ϊ�� ���ڴ��ĸ��������������ֵ
		for(int k = 0; k < dix.length; k++) {
			int nx = i+dix[k];
			int ny = j+diy[k];
			if(nx>=0 && nx<rowNum && ny>=0 && ny<colNum) {
				if(a[i][j] < a[nx][ny]) {
					dp[i][j] = Math.max(dp[i][j], DP(nx,ny)+1);
				}
			}
		}
		
		return dp[i][j];
	}
}




//typedef long long ll;
//int a[20];
//ll dp[20][state];//��ͬ��Ŀ״̬��ͬ
//ll dfs(int pos,/*state����*/,bool lead/*ǰ����*/,bool limit/*��λ�Ͻ����*/)//����ÿ���ⶼҪ�ж�ǰ����
//{
//    //�ݹ�߽磬��Ȼ�ǰ�λö�٣����λ��0����ôpos==-1˵���������ö������
//    if(pos==-1) return 1;/*����һ�㷵��1����ʾ��ö�ٵ�������ǺϷ��ģ���ô�������Ҫ����ö��ʱ����ÿһλ��Ҫ������Ŀ������Ҳ����˵��ǰö�ٵ�posλ��һ��Ҫ��֤ǰ���Ѿ�ö�ٵ���λ�ǺϷ��ġ�����������Ŀ��ͬ����д����ͬ�Ļ���һ��Ҫ����1 */
//    //�ڶ������Ǽ��仯(�ڴ�ǰ���ܲ�ͬ��Ŀ������һЩ��֦)
//    if(!limit && !lead && dp[pos][state]!=-1) return dp[pos][state];
//    /*����д��������û�����Ƶ��������仯�������������¼״̬�Ƕ�Ӧ������Ϊʲô���������ļ��仯����ὲ*/
//    int up=limit?a[pos]:9;//����limit�ж�ö�ٵ��Ͻ�up;���������ǰ����213������
//    ll ans=0;
//    //��ʼ����
//    for(int i=0;i<=up;i++)//ö�٣�Ȼ��Ѳ�ͬ����ĸ����ӵ�ans�Ϳ�����
//    {
//        if() ...
//        else if()...
//        ans+=dfs(pos-1,/*״̬ת��*/,lead && i==0,limit && i==a[pos]) //��������������ζ�������д��
//        /*���ﻹ��Ƚ���������������;�������Ҳ����·��
//        ��ž���˵���ҵ�ǰ��λö�ٵ�����i��Ȼ�������Ŀ��Լ��������������
//        ȥ���㲻ͬ����µĸ���������Ҫ����state��������֤i�ĺϷ��ԣ�������Ŀ
//        Ҫ����λ�ϲ�����62��������,��ô����state����Ҫ����ǰһλpre,Ȼ����࣬
//        ǰһλ�����6��ô����ζ�Ͳ�����2������һ��Ҫ����ö�ٵ�������ǺϷ�*/
//    }
//    //�����꣬��¼״̬
//    if(!limit && !lead) dp[pos][state]=ans;
//    /*�����Ӧ����ļ��仯����һ��������ʱ��¼����֤һ���ԣ���Ȼ���Լ����������Ҫ����lead���������lead����ȫ���ÿ�����*/
//    return ans;
//}
//ll solve(ll x)
//{
//    int pos=0;
//    while(x)//����λ���ֽ����
//    {
//        a[pos++]=x%10;//��������ϲ�����Ϊ[0,pos),�����ߵľͰ��Լ�ϰ����������ע����λ�߽����
//        x/=10;
//    }
//    return dfs(pos-1/*�����λ��ʼö��*/,/*һϵ��״̬ */,true,true);//�տ�ʼ���λ���������Ʋ�����ǰ����ģ���Ȼ�����λ��Ҫ�ߵ�һλ��Ϊ0��
//}
//int main()
//{
//    ll le,ri;
//    while(~scanf("%lld%lld",&le,&ri))
//    {
//        //��ʼ��dp����Ϊ-1,���ﻹ�и����������Ż�,���潲
//        printf("%lld\n",solve(ri)-solve(le-1));
//    }
//}
//
