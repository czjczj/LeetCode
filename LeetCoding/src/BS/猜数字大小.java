package BS;

/**
 * @author czj
 * @date   2019-06-27 09:35
 */
public class 猜数字大小 {
	static int a = 1702766719;
	public static void main(String[] args) {
		int n = 2126753390;
		System.out.println(guessNumber(n));
	}
	/*
	 * 这道题目注意数组的越界处理
	 */
	public static int guessNumber(int n) {
        long L=1;
        long R = n;
        long ans = 0;
        while(L<=R){
            int mid = (int)((L+R)/2);
            System.out.println(mid);
            if(guess((int)mid)==0){
                ans = mid;
                break;
            }else if((int)guess(mid)==-1){
                R = mid-1;
            }else{
                L= mid+1;
            }  
        }
        return (int)ans;
    }
	
	private static int guess(int mid) {
		if(a > mid)
			return 1;
		if(a == mid)
			return 0;
		return -1;
	}
}

    
