package prg_42584;

// 7;54-8;10
// 스택으로 푸는 방법 공부할 것
public class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        int n = prices.length;
        int cnt = 0;
        for(int start=0; start<n; start++){
            cnt = 0;
            for(int end=start+1; end<n; end++){
                if(prices[start] > prices[end]){
                    // 멈춤
                    cnt = end-start;
                    break;
                }
            }
            // 중간에 멈춤
            if(cnt!=0){
                answer[start] = cnt;
                continue;
            }
            // 계속 오름
            answer[start] = (n-1)-start;
        }

        return answer;
    }
}