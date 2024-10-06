package prg_43238;

// 5;50 - 6:16 참고
import java.util.*;

public class Solution2 {
    public long solution(int n, int[] times) {
        long answer = 0;

        Arrays.sort(times);
        long min = 0;
        long max = 1000000000 * 1000000000;

        long mid = 0;
        while(min < max){
            mid = (min+max)/2;

            if(func(mid, times, n)){
                // min~mid 사이에 있을 가능성
                max = mid;
            }else{
                // mid+1 ~ max
                min = mid + 1;
            }
        }

        return min;
    }

    public boolean func(long mid, int[] times, int n){
        long peopleCnt = 0;

        for(int t: times){
            peopleCnt += mid/t;
        }

        if(peopleCnt >= n){
            return true;
        }else{
            return false;
        }
    }
}