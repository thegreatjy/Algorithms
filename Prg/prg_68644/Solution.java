package prg_68644;

import java.util.*;

public class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};

        int sum = 0;
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<numbers.length-1; i++){
            for(int j=i+1; j<numbers.length; j++){
                sum = numbers[i] + numbers[j];
                if(!list.contains(sum)){
                    list.add(sum);
                }
            }
        }

        Collections.sort(list);
        answer = list.stream()
                .mapToInt(Integer::intValue)
                .toArray();

        return answer;
    }

    public static void main(String[] args) {
        // int[] numbers = {2,1,3,4,1};
        int[] numbers = {5,0,2,7};

       int [] answer = new Solution().solution(numbers);
       System.out.println(Arrays.toString(answer));
    }
}