package PartitionEqualSubsetSum;

public class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for(int n: nums){
            totalSum += n;
        }

        // totalSum이 홀수이면 불가능
        if(totalSum%2 == 1){
            return false;
        }


        int halfSum = totalSum / 2;
        boolean[][] dp = new boolean[halfSum + 1][nums.length + 1]; // nums[0~idx-1]으로 sum을 만들 수 있는지 여부

        // dp[s][0] => {} => 언제나 false
        for(int s=0; s<=halfSum; s++){
            dp[s][0] = false;
        }
        // num[0][0 ~ idx] => 언제나 true
        for(int idx=0; idx<=nums.length; idx++){
            dp[0][idx] = true;
        }

        for(int i=1; i<=halfSum; i++){
            for(int j=1; j<=nums.length; j++){ // nums[0 ~ j-1]
                int curIdx = j-1;

                if(nums[curIdx] > i){
                    // nums[curIdx]을 정답 배열에 포함하지 않음
                    dp[i][j] = dp[i][j-1];
                }else{
                    // currentNum을 정답 배열에 포함
                    boolean include = dp[i - nums[curIdx]][j-1]; // i-nums[curIdx]값을 nums[0 ~ curIdx-1] 요소들로 만들 수 있는지 여부
                    // nums[curIdx]를 정답 배열에 미포함
                    boolean exclude = dp[i][j-1];
                    dp[i][j] = include || exclude;
                }
            }
        }

        return dp[halfSum][nums.length];
    }

    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
        // int[] nums = {1,2,3,5};
        boolean result = new Solution().canPartition(nums);
        System.out.println(result);
    }
}
