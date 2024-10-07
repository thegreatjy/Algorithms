package prg_42885;

// 6;22-참고7;7

import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);
        int startIdx = 0, endIdx = people.length-1;

        while(startIdx<=endIdx){
            if(people[endIdx] + people[startIdx] <= limit){
                startIdx++;
            }
            endIdx--;
            answer++;
        }


        return answer;
    }
}