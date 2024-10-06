package prg_42586;

// 7;09 - 7;44 정답 100.0 주의 숫자 자료형 주의하자
import java.util.*;

public class Solution {
    public int[] solution(int[] progresses, int[] speeds) {

        Queue<Integer> days = new LinkedList<>();
        for(int i=0; i<progresses.length; i++){
            days.add((int)Math.ceil(((100.0 - progresses[i]) / speeds[i])));
        }

        List<Integer> result = new ArrayList<>();
        int last = days.peek(), cnt = 0;
        for(Integer current: days){
            if(current <= last){
                cnt++;
            }else{
                if(cnt>0){
                    result.add(cnt);
                }
                last = current;
                cnt = 1;
            }
        }

        if(cnt>0)   result.add(cnt);

        // list<Integer> -> int[]
        int[] answer = new int[result.size()];
        int a=0;
        for(int r: result){
            answer[a++] = r;
        }
        //answer = result.toArray();
        return answer;
    }
}