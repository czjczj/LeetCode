package Easy;
import java.util.Scanner;

/**
 * @author czj
 * @date   2019-06-17 08:23
 * 
 * 牛客网： 网易算法工程师招聘题目
 * 
 * 小易为了向他的父母表现他已经长大独立了,
 * 他决定搬出去自己居住一段时间。一个人生活增加了许多花费: 
 * 小易每天必须吃一个水果并且需要每天支付x元的房屋租金。当前小易手中已经有f个水果
 * 和d元钱,小易也能去商店购买一些水果,商店每个水果售卖p元。小易为了表现他独立生活的能力
希望能独立生活的时间越长越好,小易希望你来帮他计算一下他最多能独立生活多少天。
 */
public class 独立的小易 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long x = sc.nextLong();
		long f = sc.nextLong();
		long d = sc.nextLong();
		long p = sc.nextLong();
		long res = solve(x,f,d,p);
		System.out.println(res);		
	}
	
	private static long solve(long x, long f, long d, long p) {
		//1.如果一开始水果数就多余金钱数目， 直接返回金钱的结果
		//2. 金钱可以存活的时间比水果长，那么我们就可以将水果先转化为金钱
		//然后再去看这些金钱可以存活的时间长（这里其实就是将金钱每存活一天需要多少
		//等额的水果钱和生活钱）
		long res = 0;
		if(d/x < f)
			res = d/x;
		else
			res = (d+f*p)/(x+p);//每存活一天需要 x钱 和  p水果钱
		return res;
	}

	//方法二： 这是刚开始的额傻逼想法，脑子太笨了
	private static long solve1(long x, long f, long d, long p) {
		long max = 0;
		if(Math.floor(d/x) <= f)
			return (long)(d/x);
		else {
			while(d-p > 0) {
				d = d-p;
				f += 1;
				max = Math.max(max, Math.min((long)(d/x), f));
			}
//			max = Math.max(max, Math.min((int)(d/x), f))
		}
		return max;
	}
}
