package prg_92342;

class Solution {
    static int maxDiff = 0; // 점수 격차의 최대값
    static private int[] result = {-1}; // 최종 정답 배열

    public static int[] solution(int n, int[] info) {
        int[] ryan = new int[11];

        func(0, 0, n, info, ryan, 0);

        if(maxDiff == 0) {  // 라이언이 한 번도 이기지 못할 경우
            result = new int[1];
            result[0] = -1;
        }
        return result;
    }

    // cnt: 현재 쏜 화살 개수(cnt <= n)
    // score: ryan 점수
    public static void func(int current, int cnt, int n, int[] appeach, int[] ryan, int score) {
        // 종료: 위치가 마지막
        // 어차피 0점이어서 이기나 지나 상관이 없다.
        if(current >= 10) {
            if(score <= 0)  return; // 라이언이 비기거나 패배

            if (score == maxDiff){ // 점수 격차가 동일할 경우
                ryan[10] = n - cnt; // 사용 후 남은 화살 개수를 0점에 넣는다. 모두 소진일 경우 0이 들어간다.

                for(int i = 10; i>=0; i--) {
                    if(result[i] < ryan[i]) {
                        result = ryan.clone();
                        return;
                    }else if(result[i] > ryan[i]) return;   // 기존 result 유지
                }
            }else if(score > maxDiff){ // 점수 격차가 가장 클 경우
                ryan[10] = n - cnt; // 사용 후 남은 화살 개수를 0점에 넣는다. 모두 소진일 경우 0이 들어간다.
                maxDiff = score;
                result = ryan.clone();
            }

            return;
        }

        // 라이언이 이김
        if(cnt < n){
            int left = n - cnt;
            if(left >= appeach[current] + 1){
                ryan[current] = appeach[current] + 1;
                func(current + 1, cnt + ryan[current], n, appeach, ryan, score + (10 - current));
                ryan[current] = 0;
            }
        }

        // 라이언이 짐
        if(appeach[current] > 0){   // 어피치가 점수를 획득
            func(current + 1, cnt, n, appeach, ryan, score - (10 - current));
        } else {    // 어피치 점수 획득 X
            func(current + 1, cnt, n, appeach, ryan, score);
        }
    }

    public static void main(String[] args) {
        int n = 9;
        int[] info = {0,0,1,2,0,1,1,1,1,1,1};

        int[] result = new Solution().solution(n, info);

        System.out.println("정답");
        for(int r: result){
            System.out.print(r + " ");
        }
    }
}