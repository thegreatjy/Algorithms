package minimizeTheMaximumDifferenceOfPairs;

import java.util.Arrays;

public class Solution {
	public int minimizeMax(int[] nums, int p) {
		int result = 0;
		
		Arrays.sort(nums);
		
		int minDiff = 0, maxDiff = nums[nums.length-1] - nums[0], midDiff = 0;
		while(minDiff < maxDiff) {
			midDiff = (minDiff + maxDiff) / 2;
			if(cntPairs(nums, midDiff) >= p) {
				maxDiff = midDiff;
			}else {
				minDiff = midDiff + 1;
			}
		}
		
		result = minDiff;
		return result;
    }
	
	// count the numbers of the pairs whose difference is less than diff
	public int cntPairs (int[] nums, int diff) {
		int pairs = 0;
		
		for(int i = 1; i < nums.length; ) {
			if(nums[i] - nums[i-1] <= diff) {	//make these numbers to be a pair
				i += 2;
				pairs++;
			}else {
				i++;
			}
		}
		
		return pairs;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {10,1,2,7,1,3};
		int p = 2;
		int res = new Solution().minimizeMax(nums, p);
		System.out.println(res);
	}

}
