package sortColors;

import java.util.Arrays;

public class Solution {
	public void sortColors(int[] nums) {
		int[] counts = new int[3];
		for(int num : nums) {
			++counts[num];
		}
		if(counts[0]!=0)	Arrays.fill(nums, 0, counts[0], 0);
		if(counts[1]!=0)	Arrays.fill(nums, counts[0], counts[0]+counts[1], 1);
		if(counts[2]!=0)	Arrays.fill(nums, counts[0]+counts[1], nums.length, 2);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,2,0};
		new Solution().sortColors(nums);
		for(int n:nums) {
			System.out.print(n+" ");
		}
	}

}
