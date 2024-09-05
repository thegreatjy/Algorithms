package prg_214289;

/* 오답 84.0 / 100.0 */

public class Solution2 {
    public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
        temperature += 10; t1 += 10; t2 += 10;
        int dpMax = 100 * 1000;

        int timeMax = onboard.length;
        int[][] dp = new int[timeMax][51];   // 시각 i에 온도 j도(0~50)를 만들기 위해 최소 소비 전력
        for(int i=0; i<onboard.length; i++){
            for(int j=0; j<=50; j++){
                dp[i][j] = dpMax;
            }
        }
        dp[0][temperature] = 0;

        int minTemp = 0, maxTemp = 0;   // 현재 시각 i에 가능한 최소, 최대 온도
        for(int i=1; i<timeMax; i++){
            // i: 현재시각
            // j: 온도
            if(onboard[i] == 0){
                minTemp = Math.min(t1, temperature);
                maxTemp = Math.max(t2, temperature);
            }else if(onboard[i] == 1){
                minTemp = t1;
                maxTemp = t2;
            }

            for(int j=0; j<=50; j++){
                if(minTemp <= j && j <= maxTemp){
                    // j-1 -> j
                    int dpM1 = dpMax;
                    if(j-1 <= 0){
                        dpM1 = dpMax;
                    }else if(j-1 >= temperature){
                        dpM1 = dp[i-1][j-1] + a;
                    } else {
                        dpM1 = dp[i-1][j-1] + 0;
                    }

                    // j -> j
                    int dpZero = dpMax;
                    if(j == temperature){
                        dpZero = dp[i-1][j] + 0;
                    }else{
                        dpZero = dp[i-1][j] + b;
                    }

                    // j+1 -> j
                    int dpP1 = dpMax;
                    if(j+1 >= 51){
                        dpP1 = dpMax;
                    }else if(j+1 <= temperature){
                        dpP1 = dp[i-1][j+1] + a;
                    } else{
                        dpP1 = dp[i-1][j+1] + 0;
                    }


                    dp[i][j] = Math.min(dp[i][j], Math.min(dpM1, Math.min(dpZero, dpP1)));

                }else{
                    dp[i][j] = dpMax;
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int j = 0; j <= 50; j++) {
            answer = Math.min(answer, dp[timeMax-1][j]);
        }

        return answer;
    }

    public static void main(String[] args) {
        int temperature = 28;
        int t1 = 18;
        int t2 = 26;
        int a = 10;
        int b = 8;
        int[] onboard = {0, 0, 1, 1, 1, 1, 1};

        int res = new Solution2().solution(temperature, t1, t2, a, b, onboard);
        System.out.println(res);
    }
}
