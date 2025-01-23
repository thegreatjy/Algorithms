package Bj_16194;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        int[] prices = new int[N+1];
        for(int i=1; i<=N; i++){
            prices[i] = Integer.parseInt(line[i-1]);
        }

        int[] dp = new int[N+1];
        int min = Integer.MAX_VALUE;
        dp[0] = 0; dp[1] = prices[1];

        for(int i=2; i<=N; i++){
            min = prices[i];
            for(int j=1; j<i; j++){
                min = Math.min(min, dp[j] + dp[i-j]);
            }
            dp[i] = min;
        }

        System.out.println(dp[N]);
    }
}
