package houseRobber;

public class Solution {
	public int rob(int[] nums) {     
        int[][] result = new int[nums.length][2];
        
        for(int i=0; i<nums.length; i++) {
        	if(i==0) {
        		result[i][0] = 0;
        		result[i][1] = nums[i];
        		continue;
        	}
        	result[i][0] = Math.max(result[i-1][0], result[i-1][1]);
        	result[i][1] = result[i-1][0] + nums[i];
        }
        
        return Math.max(result[nums.length-1][0], result[nums.length-1][1]);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,7,9,3,1};
		
		System.out.println(new Solution().rob(nums));	
	}

}
