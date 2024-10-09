package SingleNumber;

import java.util.*;

// 참고 - XOR 연산
public class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int i=0; i<nums.length; i++){
            result = result ^ nums[i];
        }
        return result;
    }

    public int singleNumber2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        int val = 0;
        for(int i=0; i<nums.length; i++){
            val = map.getOrDefault(nums[i], 0);
            map.put(nums[i], val+1);
        }

        int result = 0;
        for(Integer i: map.keySet()){
            if(map.get(i)%2==1){
                result = i;
                break;
            }
        }

        return result;
    }
}