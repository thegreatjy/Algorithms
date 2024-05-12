package ThreeSum;

import java.util.*;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        // nums 정렬
        Arrays.sort(nums);

        // triplets 구하기
        int j = 0, k = 0, sum = 0;
        for(int i=0; i<nums.length-2; i++){
            j = i + 1;
            k = nums.length - 1;

            while(j < k) {
                sum = nums[i] + nums[j] + nums[k];

                if (sum == 0) {
                    set.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    ++j;
                    --k;
                } else if (sum < 0) {
                    ++j;
                } else {  // sum > 0
                    --k;
                }
            }
        }

        result.addAll(set);
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> result = new Solution().threeSum(nums);
        for(List<Integer> l: result) {
            l.stream().forEach(integer -> System.out.print(integer + " "));
            System.out.println();
        }
    }
}
