package DP;

/**
 * @author czj
 * @date   2019��3��3��
 * 	����һ�����飬���ĵ� i ��Ԫ����һ֧������Ʊ�� i ��ļ۸�
	��������ֻ�������һ�ʽ��ף������������һ֧��Ʊ�������һ���㷨�����������ܻ�ȡ���������
	ע���㲻���������Ʊǰ������Ʊ��
	����: [7,1,5,3,6,4]
	���: 5
	����: �ڵ� 2 �죨��Ʊ�۸� = 1����ʱ�����룬�ڵ� 5 �죨��Ʊ�۸� = 6����ʱ��������������� = 6-1 = 5 ��
          ע���������� 7-1 = 6, ��Ϊ�����۸���Ҫ��������۸�
 */
public class 买卖股票的最佳时机 {
	public static void main(String[] args) {
		int[] a = {7,1,5,3,6,4};
		int[] b = {7,6,4,3,1};
		System.out.println(maxProfit(a));
		System.out.println(maxProfit(b));
		
		System.out.println(maxProfit2(a));
		System.out.println(maxProfit2(b));
	}
	/**
	 * ������
	 * DP:
	 * dp[i]��ʾǰi���������棬��ôǰi������������� ��ǰi-1������棩�ͣ���i�������-ǰi-1�����Сֵ�� �����е����ֵ
	 * ���� dp[i] = max(dp[i-1],a[i]-min(a[0...i-1]))
	 */
	private static int maxProfit2(int[] a) {
		if(a.length == 0) return 0;
		int min = a[0];
		int[] dp = new int[a.length];
		for (int i = 1; i < dp.length; i++) {
			dp[i] = Math.max(dp[i-1], a[i]-min);
			if(a[i]<min)
				min = a[i];
		}
		return dp[a.length-1];
	}
	/**
	 * ����1������ѭ��
	 * @param a
	 * @return
	 */
	public static int maxProfit(int[] a) {
		int max = 0;
        for (int i = 0; i < a.length; i++) {
			for (int j = i+1; j < a.length; j++) {
				if(a[j]>a[i]){
					max = Math.max(max, a[j]-a[i]);
				}
			}
		}
		return max;
    }
	
}
