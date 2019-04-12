package DP;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.text.html.HTMLDocument.HTMLReader.SpecialAction;

/**
 * @author czj
 * @date   2019-04-11 21:44
 */
public class 大礼包 {
	public static void main(String[] args) {
		List<Integer> price = Arrays.asList(new Integer[] {2,3,4});
		List<List<Integer>> special = new ArrayList<>();
		special.add(Arrays.asList(new Integer[] {1,1,0,4}));
		special.add(Arrays.asList(new Integer[] {2,2,1,9}));
		List<Integer> needs = Arrays.asList(new Integer[] {1,2,1});
		System.out.println(shoppingOffers(price, special, needs));
	}
	static List<List<Integer>> s;
	static List<Integer> p;
	static Map<String, Integer> map = new HashMap<>();
	public static int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
		s = special;
		p = price;
		int[] need = new int[needs.size()];
		map.clear();
		for (int i = 0; i < need.length; i++) {
			need[i] = needs.get(i);
		}
        int res = f(need);
		return res;
    }
	private static int f(int[] need) {
		boolean isReturn = true;
		for(int i=0; i<need.length; i++) {
			if(need[i] > 0) {
				isReturn = false;
				break;
			}
		}
		if(isReturn)
			return 0;
		
		//need数组拼接成为字符串
		String ss = "";
		for (int i = 0; i < need.length; i++) {
			ss += need[i];
		}
		if(map.containsKey(ss))
			return map.get(ss);
			
			
		int res = Integer.MAX_VALUE;
		for (int i = 0; i < s.size(); i++) {
			List<Integer> ls = s.get(i);
			boolean flag = true;
			for (int j = 0; j < ls.size()-1; j++) {
				if(ls.get(j) > need[j]) {
					flag = false;
					break;
				}
			}
			//减去对应的值大小
			if(flag) {
				int[] a = new int[need.length];
				for (int j = 0; j < ls.size()-1; j++) {
					a[j] = need[j] - ls.get(j);
				}
				res = Math.min(res, ls.get(ls.size()-1)+f(a));
			}
		}
		
		int sum = 0;
		for (int i = 0; i < p.size(); i++) {
			sum += p.get(i) * need[i];
		}
		res = Math.min(res, sum);
		
		map.put(ss, res);
		return res;
	}
	
	/*
	 *
	 *正确的解
	public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        // 暴力回溯法
        return dp(price, special, needs, 0);       
    }
    
    private int dp(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int pos){
        int localMin = directBuy(price, needs); // 计算直接按单价购买的支出
        for(int i = pos; i < special.size(); ++i){  // 依次判断每个礼包是否可以选用
            List<Integer> offer = special.get(i); // 选择一个礼包开始判断
            boolean pick = true;
            for(int j = 0; j < needs.size(); ++j){ // 依次判断每个商品是否会溢出
                int remain = needs.get(j) - offer.get(j); 
                needs.set(j, remain); // 减去礼包内相应商品的数量添加到剩余需求里
                if(pick && remain < 0)
                    pick = false;
            }
            if(pick){
                // 判断选择该礼包是否会有更小支出(offer里的最后一个数字是礼包价格)
                localMin = Math.min(localMin, offer.get(offer.size()-1) + dp(price, special, needs, i));
            }
            for(int j = 0; j < needs.size(); j++) { // 回溯到之前的需求状态
                int remain = needs.get(j) + offer.get(j);
                needs.set(j, remain);
            }
        }
        return localMin;
    }
    
    private int directBuy(List<Integer> price, List<Integer> needs){ 
        int ret = 0;
        for(int i = 0; i < needs.size(); ++i){
            ret += needs.get(i)*price.get(i);
        }
        return ret;
    }
    */
}
