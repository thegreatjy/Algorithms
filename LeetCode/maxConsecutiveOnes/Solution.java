package maxConsecutiveOnes;

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        int startIdx = -1;
        boolean oneExists = false;

        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0 && oneExists){
                oneExists = false;
                result = Math.max(i - startIdx, result);
                startIdx = -1;
            }else if(nums[i] == 1) {
                oneExists = true;
                if(startIdx == -1) startIdx = i;
            }
            //System.out.println(result);
        }
        //마지막에 연속 1이 나올 경우
        if(oneExists){
            result = Math.max(nums.length - startIdx, result);
        }
        
        return result;        
    }

    public static void main(String[] args) {
        int[] nums = {0};
        int res = new Solution().findMaxConsecutiveOnes(nums);
        System.out.println(res);
    }
}