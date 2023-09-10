package frogJump;

import java.util.*;

public class Solution {
	public boolean canCross(int[] stones) {
		boolean result = false;
		// key : stoneIdx, value : lastUnits
		HashMap <Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();
		for(int i = 0; i < stones.length; i++) {
			map.put(stones[i], new HashSet<Integer>());
		}
		map.get(0).add(0);
		
		int[] nextIndices = {0, 0, 0};
		for(int curIdx = 0; curIdx < stones.length; curIdx++) {			
			if(!map.containsKey(stones[curIdx]))	continue;
			System.out.println(curIdx);
			for(int lastUnits : map.get(stones[curIdx])) { 
				nextIndices[0] = stones[curIdx] + (lastUnits - 1);
				nextIndices[1] = stones[curIdx] + lastUnits;
				nextIndices[2] = stones[curIdx] + (lastUnits + 1);
				for(int nextIdx : nextIndices) {
					if(nextIdx <= stones[curIdx])	continue;	//overflow || lastUnit == 1
					if(!map.containsKey(nextIdx))	continue;	//no stone
					if(nextIdx == stones[stones.length-1]) {	//able to cross
						return true;
					}
					map.get(nextIdx).add(nextIdx - stones[curIdx]);
				}
			}
		}
		
		return result;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] stones = {0,1,2,3,4,8,9,11};
		boolean res = new Solution().canCross(stones);
		System.out.println(res);
	}

}
