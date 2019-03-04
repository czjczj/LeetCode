package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List<List<Integer>> a = new ArrayList<>();
		a.add(new ArrayList<>(Arrays.asList(2)));
		a.add(new ArrayList<>(Arrays.asList(3,4)));
		a.add(new ArrayList<>(Arrays.asList(6,5,7)));
		a.add(new ArrayList<>(Arrays.asList(4,1,8,3)));
		System.out.println(a.get(0).size());
		System.out.println(a.get(3).size());
		System.out.println(a.get(a.size()-1).size());
		
	}
}
