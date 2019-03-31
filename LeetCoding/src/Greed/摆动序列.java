package Greed;

/**
 * @author czj
 * @date   2019-03-31 17:18
 */
public class 摆动序列 {
	public static void main(String[] args) throws InterruptedException {
		int[] a = {33,53,12,64,50,41,45,21,97,35,47,92,39,0,93,55,40,46,69,42,6,
				95,51,68,72,9,32,84,34,64,6,2,26,98,3,43,30,60,3,68,82,9,97,19,27
				,98,99,4,30,96,37,9,78,43,64,4,65,30,84,90,87,64,18,50,60,1,40,32,
				48,50,76,100,57,29,63,53,46,57,93,98,42,80,82,9,41,55,69,84,82,79,
				30,79,18,97,67,23,52,38,74,15};
		System.out.println(a);
	}		
	//思路：弹性的求梯度为0的位置，也就是原数组上升最高的位置和原数组下降到最低的位置
	public static int wiggleMaxLength(int[] a) {
		if(a.length == 0)
            return 0;
        int cnt = 1;
        int j = 0;
        int i = 1;
        for(;i<a.length;i++){
            if(i+1<a.length && !((a[i]-a[j])*(a[i+1]-a[i])<0)){//判断这个时候的额梯度
                continue;
            } 
            if(a[j] != a[i])
                cnt++;
            j = i;
        }
        return cnt;
    }
}
