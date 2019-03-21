package Easy;

/**
 * @author czj
 * @date   2019-03-19 10:35
 */
public class 简单_总持续时间可被60整除的歌曲 {
	public static void main(String[] args) {
		int[] time = {30,20,150,100,40};
		System.out.println(numPairsDivisibleBy60(time));
	}
	public static int numPairsDivisibleBy60(int[] time) {
		int sum = 0;
        for (int i = 0; i < time.length; i++) {
			for (int j = i+1; j < time.length; j++) {
				if((time[i]+time[j])%60 == 0)
					sum++;
			}
		}
		return sum;
    }
}
