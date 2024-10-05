package prg_70129;

import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];

        int zero = 0, length = 0, totalZero = 0, cnt = 0;
        while(true){
            ++cnt;
            zero = removeZero(s);

            length = s.length() - zero;
            totalZero += zero;

            if(length == 1) break;

            s = convert(length);
        }

        answer[0] = cnt;
        answer[1] = totalZero;

        return answer;
    }

    public int removeZero(String s){
        int cnt = 0;

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '0'){
                ++cnt;
            }
        }

        return cnt;
    }

    public String convert(int num){
        StringBuilder str = new StringBuilder();

        while(true){
            str.append(String.valueOf(num%2));
            num = num/2;

            if(num<=0)  break;
        }

        return str.reverse().toString();
    }
}