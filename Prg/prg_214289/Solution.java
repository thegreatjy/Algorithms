package prg_214289;

import java.util.Arrays;

public class Solution {
    public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
        temperature += 10;
        t1 += 10;
        t2 += 10;
        int dpMax = 100 * 1000;

        int timeMax = onboard.length;
        int[][] dp = new int[timeMax][51];   // 시각 i에 온도 j도(0~50)를 만들기 위해 최소 소비 전력
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], dpMax);
        }
        dp[0][temperature] = 0;

        int minTemp = 0, maxTemp = 0;   // 현재 시각 i에 가능한 최소, 최대 온도
        for (int i = 0; i <= timeMax - 2; i++) {
            if(onboard[i] == 0){
                minTemp = Math.min(t1, temperature);
                maxTemp = Math.max(t2, temperature);
            }else if(onboard[i] == 1){
                minTemp = t1;
                maxTemp = t2;
            }

            for (int j = minTemp; j <= maxTemp; j++) {
                // 에어컨 OFF -> 0 소모
                int nextTemp = j;
                if (j < temperature && j < 50) {
                    nextTemp = j + 1;
                } else if (j > temperature && j >= 1) {
                    nextTemp = j - 1;
                } else if (j == temperature) {
                    nextTemp = j;
                }
                dp[i + 1][nextTemp] = Math.min(dp[i + 1][nextTemp], dp[i][j]);

                // 에어컨 ON -> a 혹은 b 소모
                // b 희망온도 == 현재온도 -> b
                dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + b);
                // a 희망온도 != 현재온도 -> a
                if (j - 1 >= 0) {
                    dp[i + 1][j - 1] = Math.min(dp[i + 1][j - 1], dp[i][j] + a);
                }
                if (j + 1 <= 50) {
                    dp[i + 1][j + 1] = Math.min(dp[i + 1][j + 1], dp[i][j] + a);
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int j = 0; j <= 50; j++) {
            // 반드시 아래 조건 넣기 안 넣으면 오답
            if (onboard[onboard.length - 1] == 1 && (j < t1 || j > t2)) continue;
            answer = Math.min(dp[onboard.length - 1][j], answer);
            //answer = Math.min(answer, dp[timeMax-1][j]);
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

        int res = new Solution().solution(temperature, t1, t2, a, b, onboard);
        System.out.println(res);
    }
}

