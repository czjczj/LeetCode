package DataStructure;
import java.util.Stack;

/**
 * @author czj
 * @date   2019-04-01 10:48
 */
public class 快速排序_人工栈和系统栈 {
	public static void main(String[] args) throws InterruptedException {
		int[] a = {3,2,1,5,4,34,21,342,123};
//		quickSort(0,a.length-1,a);
		quickSort2(0,a.length-1,a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
	}
	//递归版
	private static void quickSort(int l, int r, int[] a) {
		if(l>r)
			return;
		int i = l;
		int j = r;
		int tmp =  a[l];
		while(i<j) {
			while(i<j && a[j]>tmp) {
				j--;
			}
			if(i<j)
				a[i++] = a[j];
			while(i<j && a[i]<tmp) {
				i++;
			}
			if(i<j)
				a[j--] = a[i];
		}
		a[i] = tmp;
		quickSort(l, i-1, a);
		quickSort(i+1, r, a);
	}	
	//将quickSort改为非递归版本， 人工栈代替系统栈
	private static void quickSort2(int l, int r, int[] a) {
		Stack<Integer> s = new Stack<>();
		s.push(r);
		s.push(l);
		do {
			l = s.pop();
			r = s.pop();
			int i = l;
			int j = r;
			int tmp =  a[l];
			while(i<j) {
				while(i<j && a[j]>tmp) {
					j--;
				}
				if(i<j)
					a[i++] = a[j];
				while(i<j && a[i]<tmp) {
					i++;
				}
				if(i<j)
					a[j--] = a[i];
			}
			a[i] = tmp;
			if(r>i+1) {
				s.push(r);
				s.push(i+1);
			}
			if(i-1>l) {
				s.push(i-1);
				s.push(l);
			}
		}while(!s.isEmpty());
	}
}
