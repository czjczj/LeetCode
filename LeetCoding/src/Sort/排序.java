package Sort;

/**
 * @author czj
 * @date   2019-03-18 08:32
 */
public class 排序 {
	public static void main(String[] args) {
		int[] a = {5,3,2,12,4};
		int[] res = bubbleSort(a);
//		int[] res = insertSort(a);
		quickSort(a,0,a.length-1);
//		int[] res = heapSort(a);
		
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}
	}

	private static int[] heapSort(int[] arr) {
		 //1.构建大顶堆
        for(int i=arr.length/2-1;i>=0;i--){
            //从第一个非叶子结点从下至上，从右至左调整结构
            createHeap(arr,i,arr.length);
        }
        //2.调整堆结构+交换堆顶元素与末尾元素
        for(int j=arr.length-1;j>0;j--){
            swap(arr,0,j);//将堆顶元素与末尾元素进行交换
            createHeap(arr,0,j);//重新对堆进行调整
        }
        return arr;
	}

	private static void swap(int[] arr, int a, int b) {
		int temp=arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
	}

	/**
	 */
	private static void createHeap(int[] arr, int i, int length) {
		int temp = arr[i];//先取出当前元素i
        for(int k=i*2+1;k<length;k=k*2+1){//从i结点的左子结点开始，也就是2i+1处开始
            if(k+1<length && arr[k]<arr[k+1]){//如果左子结点小于右子结点，k指向右子结点
                k++;
            }
            if(arr[k] >temp){//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                arr[i] = arr[k];
                i = k;
            }else{
                break;
            }
        }
        arr[i] = temp;//将temp值放到最终的位置
	}

	/**
	 * 快速排序
	 */
	private static void quickSort(int[] a, int l, int r) {
		if(l < r) {
			int i = l;
			int j = r;
			int tmp = a[i];
			while(i < j){
				while(i<j && a[j] > tmp) j--;
				if(i<j) a[i++] = a[j];
				while(i<j && a[i] < tmp) i++;
				if(i<j) a[j--] = a[i];
			}
			a[i] = tmp;
			quickSort(a, l, i-1);
			quickSort(a, i+1, r);
		}
	}

	/**
	 * 插入排序
	 */
	private static int[] insertSort(int[] a) {
		for (int i = 1; i < a.length; i++) {
			int j = i-1;
			while( j >= 0 && a[i] < a[j]) {
				j--;
			}
			if(j != i-1) {
				j++;
				int tmp = a[i];
				for (int k = i; k > j; k--) {
					a[k] = a[k-1];
				}
				a[j] = tmp;
				
			}
			for (int k = 0; k < a.length; k++) {
				System.out.print(a[k]+" ");
			}
			System.out.println();
		}
		return a;
	}

	/**冒泡排序
	 */
	private static int[] bubbleSort(int[] a) {
		for (int i = 0; i < a.length-1; i++) {
			boolean flag = false;
			for (int j = 0; j < a.length-1-i; j++) {
				if(a[j] > a[j+1]) {
					flag = true;
					int tmp = a[j];
					a[j] = a[j+1];
					a[j+1] = tmp;
				}
			}
			if(!flag) break;
		}
		return a;
	}
}
