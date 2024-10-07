package prg_12953;

// 7;7-7;18
// 유클리드 방법 공부할 것
import java.util.*;

public class Solution {
    public int solution(int[] arr) {
        int answer = 0;

        Arrays.sort(arr);
        int max = arr[arr.length-1];
        int i=1;
        while(true){
            int bs= max * i;
            if(check(bs, arr)){
                answer= bs;
                break;
            }
            i++;
        }


        return answer;
    }

    public boolean check(int bs, int[] arr){
        boolean res = true;
        for(int i=0; i<arr.length; i++){
            if(bs % arr[i] != 0){
                res = false;
                break;
            }
        }
        return res;
    }
}