package LongestStrictlyIncreasingorStrictlyDecreasingSubarray;

public class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int result = 1, si = 1, sd = 1;

        for(int cur=1; cur<nums.length; cur++){
            if(nums[cur-1] < nums[cur]){
                ++si;
                sd = 1;
            }else if(nums[cur-1] > nums[cur]){
                ++sd;
                si = 1;
            }else {
                si = 1;
                sd = 1;
            }

            result = Math.max(result, Math.max(si, sd));
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1};
        int result = new Solution().longestMonotonicSubarray(nums);

        System.out.println(result);
    }
}
