package continuousSubarraySum;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * 길이가 2 이상
     * 합은 언제나 k의 배수
     * 연속적인 요소를 잘라낸 것이 subarray가 된다.
     * 0은 k의 배수
     * @param nums
     * @param k
     * @return
     */
    public boolean checkSubarraySum(int[] nums, int k) {
        boolean result = false;

        Map<Integer, Integer> map = new HashMap<>();    // <누적합의 나머지: 처음 나타난 위치 인덱스>
        map.put(0, -1); // {0, 0} 을 true로 만들어 줌

        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum = sum + nums[i];
            sum = sum % k;

            if(map.containsKey(sum)){
                int lastIndex = map.get(sum);
                if(i - lastIndex >= 2){ // (현재 위치 값 ~ 마지막 위치 이후(lastIdx + 1)부터 값)의 누적합 % k가 0이다.
                    result = true;
                    break;
                }
            }else{
                map.put(sum, i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {23,2,6,4,7};
        int k = 13;
        new Solution().checkSubarraySum(nums, k);
    }
}
