package prg_131701;

import java.util.*;

public class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        int n = elements.length;
        int[] dp = new int[n+1];
        dp[0] = 0;
        for(int i=1; i<=n; i++){
            dp[i] = dp[i-1] + elements[i-1];
        }

        Set<Integer> set = new HashSet<>();

        int finish = 0, sum = 0;
        for(int i=1; i<=n; i++){
            // 길이가 i인 부분 수열
            // 시작 인덱스가 start
            for(int start=0; start<n; start++){
                finish = start + i - 1;

                if(finish < n){
                    sum = dp[finish+1] - dp[start];
                }else{
                    finish = finish % n;
                    sum = dp[n] - dp[start] + dp[finish+1];
                }
                set.add(sum);
            }
        }

        answer = set.size();

        return answer;
    }
}