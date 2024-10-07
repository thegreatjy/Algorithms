package prg_12924;
//4;54-5;10

public class Solution {
    static int num = 0, cnt = 0;
    public int solution(int n) {
        int answer = 0;
        int[] dp = new int[n+1];
        dp[0] = 0;
        for(int i=1; i<=n; i++){
            dp[i] = dp[i-1] + i;
        }

        int diff = 0;
        for(int start=1; start<=n; start++){
            for(int end=start; end<=n; end++){
                diff = dp[end] - dp[start-1];

                if(diff == n){
                    answer++;
                    break;
                }else if(diff > n){
                    break;
                }
            }
        }

        return answer;
    }
}