package leetcode.PartitionLabels;

import java.util.*;

public class Solution {
    public List<Integer> partitionLabels(String s) {
        // <alphabet, the last idx>
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        // find the last index of the alphabet in the list
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            int cToInt = c-'a';

            map.put(cToInt, i);
        }

        // tail : the last idx of this partition
        int head = 0, tail = 0;
        for(int cur=0; cur<s.length(); cur++){
            // end of the partition
            // prepare for new partition
            if(cur > tail){
                result.add(tail - head + 1);
                head = cur;
                tail = cur;
            }

            char c = s.charAt(cur);
            int cToInt = c-'a';

            if(tail < map.get(cToInt)) {
                tail = map.get(cToInt);
            }
        }
        // the last partition
        result.add(tail - head + 1);

        return result;
    }
    public static void main(String[] args) {
        String s = "eaaaabaaec";
        System.out.println(new Solution().partitionLabels(s));
    }
}
