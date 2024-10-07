package prg_12911;

//5;11 - 17

public class Solution {
    public int solution(int n) {
        int answer = 0;

        int one = cntOne(n);
        for(int i=n+1; i<=1000000; i++){
            if(one == cntOne(i)){
                answer = i;
                break;
            }
        }

        return answer;
    }


    public int cntOne(int n){
        int cntOne = 0;

        while(n>0){
            if(n%2 == 1){
                cntOne++;
            }
            n=n/2;
        }

        return cntOne;
    }
}