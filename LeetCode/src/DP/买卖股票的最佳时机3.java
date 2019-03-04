package DP;

/**
 * @author czj
 * @date   2019��3��3��
   *    ����һ�����飬���ĵ� i ��Ԫ����һ֧�����Ĺ�Ʊ�ڵ� i ��ļ۸�	
	���һ���㷨�����������ܻ�ȡ�������������������� ���� ���ס�
	ע��: �㲻��ͬʱ�����ʽ��ף���������ٴι���ǰ���۵�֮ǰ�Ĺ�Ʊ����
����: [3,3,5,0,0,3,1,4]
���: 6
����: �ڵ� 4 �죨��Ʊ�۸� = 0����ʱ�����룬�ڵ� 6 �죨��Ʊ�۸� = 3����ʱ����������ʽ������ܻ������ = 3-0 = 3 ��
����ڵ� 7 �죨��Ʊ�۸� = 1����ʱ�����룬�ڵ� 8 �� ����Ʊ�۸� = 4����ʱ����������ʽ������ܻ������ = 4-1 = 3 ��
 */
public class 买卖股票的最佳时机3 {
	public static void main(String[] args) {
		int[] a = {3,3,5,0,0,3,1,4};
		int[] b = {1,2,3,4,5};
		int[] c = {6,1,3,2,4,7};
		System.out.println(maxProfit(b));
		System.out.println(maxProfit(a));
		System.out.println(maxProfit(c));
		System.out.println(maxProfit(new int[]{1}));
	}
	public static int maxProfit(int[] a) {
		/**
	        ��������һ�쿼���ĸ�����:
	        fstBuy: �ڸ����һ�������Ʊ�ɻ�õ�������� 
	        fstSell: �ڸ����һ��������Ʊ�ɻ�õ��������
	        secBuy: �ڸ���ڶ��������Ʊ�ɻ�õ��������
	        secSell: �ڸ���ڶ���������Ʊ�ɻ�õ��������
	        �ֱ���ĸ�����������Ӧ�ĸ���, ���secSell�������
	        ����ֵ(secSell >= fstSell)  �����Ŀ���㡣�����鿴���˵Ľ��ⷽ��
	        **/
        int fstBuy = Integer.MIN_VALUE, fstSell = 0;
        int secBuy = Integer.MIN_VALUE, secSell = 0;
        for(int p : a) {
            fstBuy = Math.max(fstBuy, -p);
            fstSell = Math.max(fstSell, fstBuy + p);
            secBuy = Math.max(secBuy, fstSell - p);
            secSell = Math.max(secSell, secBuy + p); 
        }
        return secSell;
    }
}
