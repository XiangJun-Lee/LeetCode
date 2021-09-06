package com.LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
    	Map<List<Integer>, Integer> tempResults = new HashMap<List<Integer>, Integer>();
    	ArrayList<Integer> pos = new ArrayList<Integer>();
    	ArrayList<Integer> neg = new ArrayList<Integer>();
    	int zero = 0;
    	for(int i : nums) {
    		if(i>0) {
    			pos.add(i);
    		}else if(i<0) {
    			neg.add(i);
    		}else {
    			zero++;
    		}
    	}
    	if(zero>=3) {
    		List<Integer> result = new ArrayList<Integer>();
			result.add(0);
			result.add(0);
			result.add(0);
			tempResults.put(result,0);
    	}
    	if(zero>0) {
    		for(int i:neg) {
    			if(pos.contains(-i)) {
    				List<Integer> result = new ArrayList<Integer>();
    				result.add(i);
    				result.add(0);
    				result.add(-i);
    				tempResults.put(result,0);
    			}
    		}
    	}
    	
    	if(pos.size()>1) {
    		Map<List<Integer>, Integer> temp = check(pos,neg);
    		tempResults.putAll(temp);
    	}
    	
    	if(neg.size()>1) {
    		Map<List<Integer>, Integer> temp = check(neg,pos);
    		tempResults.putAll(temp);
    	}
    	List<List<Integer>> result = new ArrayList<List<Integer>>(tempResults.keySet());
    	return result;
    	
    }

	private Map<List<Integer>, Integer> check(ArrayList<Integer> pos, ArrayList<Integer> neg) {
		// TODO Auto-generated method stub
		Map<List<Integer>, Integer> results = new HashMap<List<Integer>, Integer>();
		for(int i=0;i<pos.size()-1;i++) {
			for(int j=i+1;j<pos.size();j++) {
				int key = -(pos.get(i)+pos.get(j));
				if(neg.contains(key)) {
					System.out.println(pos.get(i)+"+"+pos.get(j)+"="+-key);
					List<Integer> result = new ArrayList<Integer>();
    				result.add(pos.get(i));
    				result.add(pos.get(j));
    				result.add(key);
    				Collections.sort(result);
    				results.put(result,0);
				}
			}
		}
		System.out.println(results);
		return results;
	}
	
	public static void main(String[] args) {
		int[] nums = new int[] {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
		System.out.println(new ThreeSum().threeSum(nums));
	}
}
