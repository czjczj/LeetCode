package BS;

/**
 * @author czj
 * @date   2019-03-19 10:46
 * 	传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
	传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
	返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。
	输入：weights = [1,2,3,4,5,6,7,8,9,10], D = 5
	输出：15
	解释：
	船舶最低载重 15 就能够在 5 天内送达所有包裹，如下所示：
	第 1 天：1, 2, 3, 4, 5
	第 2 天：6, 7
	第 3 天：8
	第 4 天：9
	第 5 天：10
	请注意，货物必须按照给定的顺序装运，因此使用载重能力为 14 的船舶并将包装分成 (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) 是不允许的。 
	第一眼二分搜索
 */
public class 在D天内送达包裹的能力 {
	public static void main(String[] args) {
		int[] w = {147,73,265,305,191,152,192,293,309,292,182,157,381,287,73,162,313,366,346,47};
		int t = 10;
		System.out.println(shipWithinDays(w, t));
	}
	/**
	 * 二分搜索题目：对于给定的天数D，我们很难求解船舶的载重，但是，当我们给定了船舶的载重的情况下，
	 * 我们可以快速的求解出至少需要多少天的才可以完成运载，f(D)=y 其中D表示天数，y表示船舶的载重，
	 * 在这种情况下，随着天数的增多，y是减少的，也就是呈现负相关，注意边界值的更新方法
	 */
	public static int shipWithinDays(int[] weights, int D) {
		int R = 0;
		for (int i = 0; i < weights.length; i++) {
			R += weights[i];
		}
		int L = 0;
		int ans = -1;
		while(L<=R) {
			int mid = (L+R)/2;
//			System.out.println(" "+L+" "+R+" "+mid);
			if(guess(mid,weights,D)) {
				R = mid-1;//二分搜索注意，只有这里才可以ans=mid，否则在guess为错误的值的情况下页完成了更新
				ans = mid;
			}else {
				L = mid+1;
			}
		}
		return ans;
    }
	private static boolean guess(int mid, int[] weights, int d) {
		int dayNums = 0;
		for (int i = 0; i < weights.length; i++) {
			if(dayNums+weights[i] > mid) {
				dayNums = 0;
				d--;
				dayNums += weights[i];
				if(weights[i] > mid) {
					return false;
				}
			}else {
				dayNums += weights[i];
			}
		}
//		System.out.println(""+mid+" "+d);
		return d>=1;
	}
}
