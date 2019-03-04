package Stack;
import java.util.Stack;
/**
 * @author czj
 * @date   2019��2��26��
 * 
 *	 ���� n ���Ǹ�������������ʾ��״ͼ�и������ӵĸ߶ȡ�ÿ�����ӱ˴����ڣ��ҿ��Ϊ 1 ��
	���ڸ���״ͼ�У��ܹ����ճ����ľ��ε���������
	����: [2,1,5,6,2,3]
	���: 10	
	Test
 */
public class 柱状图中最大的矩形 {
	public static void main(String[] args) {
		int[] a = {2,1,5,6,2,3};
		int[] b = {0};
		int[] c = {2,1,2};
		System.out.println(f(a));
		System.out.println(ff(c));
	}

	//�����ƽ� ʱ�临�Ӷ�O(n^2)
	/**
	 * ����˼·������ÿһ����״������ֻ��Ҫ�����
		����ߵ�һ��С����߶ȵĵ���±� --> i 
		���ұߵ�һ��С����߶ȵĵ���±� --> j
		��ô��ʱ�����������Ϊ   ����״�ĸ߶�h*(j-i)
		��ʱ��ʱ�临�Ӷ�Ϊ O(n^2)
	 */
	private static int f(int[] a) {
		int[] b = new int[a.length+2];
		for (int i = 0; i < a.length; i++) {
			b[i+1] = a[i];
		}
		int max = 0;
		for (int index = 1; index < b.length-1; index++) {
			int l = index;
			int r = index;
			while(b[l] >= b[index] && b[l] != 0) l--;
			while(b[r] >= b[index] && b[r] != 0) r++;
			max = Math.max(max, b[index]*(r-l-1));
		}
		return max;
	}
	
	//��������ջ
	/**
	 *�� ��ǰ ����Ϊ�� ����  ��ǰԪ�ش���ջ��Ԫ��ʱ��ջ����
	 *�� ��ջ��Ϊ�յ�ʱ��Ҳ����˵���ʱ��ǰ�����Ԫ�صĸ߶���ҪС��ջ����Ԫ�صĸ߶ȵ�
	 *  ��ô��ջ��ǰ��ջ��Ԫ�أ�����ʱ���¹��̵ĸ߶��Ѿ�֪���ˣ����ұߵ�һ��С����߶ȵ��±�Ҳ�Ѿ�֪����
	 *  ��.�� �����ʱջΪ������ô����ߵĵ�һ���߶�С������±�λ��Ҳ���Ǹ�Ԫ�صı����ˣ�����ʱ��  ���Ϊ i-index
	 *  ��.�� �����ʱջ��Ϊ���ˣ���ô��ʵ����ߵĵ�һ���߶�С������±��λ��Ҳ���ǵ�ǰ��ջ��ѹ���Ԫ���ˣ���Ϊ i-ss.peek()
	 */
	public static int ff(int[] b) {
		int[] a = new int[b.length+2];
		for (int i = 0; i < b.length; i++) {
			a[i+1] = b[i];
		} 
		Stack<Integer> ss = new Stack<>();
		int max = 0;
		for (int i = 0; i < a.length; i++) {
			if(ss.isEmpty() || a[i]>a[ss.peek()]) {
				ss.push(i);
			}else { //��ʱ��ջ����Ԫ�ز��ҵ�ǰ�����Ԫ����С��ջ����Ԫ��ֵ��
				while(!ss.isEmpty() && a[i]<a[ss.peek()]) {
					//ִ��һ�γ�ջ�����������浱ǰ�ĸ߶�
					int index = ss.pop();
					int h = a[index];
					if(ss.isEmpty()) {
						max = Math.max(max, h*(i-index));
					}else {
						max = Math.max(max, h*(i-ss.peek()-1));
					}
				}
				ss.push(i);
			}
		}
		return max;
	}
}
