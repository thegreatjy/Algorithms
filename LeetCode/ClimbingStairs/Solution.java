package ClimbingStairs;

public class Solution {

    public int climbStairs(int n) {
        int result = 0;
        int[] nums = new int[n+1];

        nums[0] = 1;
        nums[1] = 1;
        for(int i=2; i<=n; i++){
            nums[i] = nums[i-1] + nums[i-2];
        }

        result = nums[n];
        return result;
    }


    public static void main(String[] args) {
        int n = 3;
        System.out.println(new Solution().climbStairs(n));
    }
}