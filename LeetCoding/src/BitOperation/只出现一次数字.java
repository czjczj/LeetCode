package BitOperation;
import java.util.HashSet;
import java.util.Set;

/**
 * @author czj
 * @date   2019-03-27 08:42
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
	说明：
	你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
	示例 1:
	输入: [2,2,1]
	输出: 1
 */
public class 只出现一次数字 {
	public static void main(String[] args) {
		System.out.println(singleNumber(new int[] {4,1,2,1,2}));
	}
	//方法一
	public static int singleNumber(int[] a) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < a.length; i++) {
			if(!set.add(a[i])) {
				set.remove(a[i]);
			}
		}
		return set.iterator().next();
    }
	//正确的解
	//任何数组和0异或后是该数本身，一个数字和自己异或以后变为0（对应题目中每个元素会出现两次的情况），最终只剩下一个数字了
	private static int singleNumber2(int[] nums) {
		int num = 0;
		for (int i = 0; i < nums.length; i++) {
			num = num ^ nums[i];
		}
		return num;
	}
}
