package BitOperation;
import java.util.Arrays;

/**
 * @author czj
 * @date   2019-03-27 09:34
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
	你可以假设数组是非空的，并且给定的数组总是存在众数。
 */
public class 求众数 {
	public static void main(String[] args) {
		System.out.println(majorityElement(new int[] {3,2,3}));
	}
	//我的方法：  跟个傻子一样的感觉
	public static int majorityElement(int[] nums) {
		int len = nums.length;
        Arrays.sort(nums);
        int tmp = nums[0];
        int cnt = 0;
        for(int i=0; i<len; i++){
            if(nums[i] != tmp){
                if(cnt >= len/2+1)
                    return tmp;
                tmp = nums[i];
                cnt = 1;
            }else{
                cnt++;
                if(cnt >= len/2+1)
                    return tmp;
            }
        }
        return tmp;
    }
	//方法二
	public static int majorityElement2(int[] nums) {
        Arrays.sort(nums);
		return nums[nums.length / 2];
    }
	//方法三 扑克牌，相同的数字就加一，不相同的数字就减去一，因为众数一定是大于 n/2+1;
	public static int majorityElement3(int[] nums) {
		int count = 1;
		int maj = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (maj == nums[i])
				count++;
			else {
				count--;
				if (count == 0) {
					maj = nums[i + 1];
				}
			}
		}
		return maj;
	}
}
