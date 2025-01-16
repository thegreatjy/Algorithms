package Bj_9095;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        int[] dp = new int[12];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i=4; i<=11; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3] ;
        }

        int n = 0;
        for(int i=0; i<t; i++){
            n = Integer.parseInt(br.readLine());

            sb.append(dp[n] + "\n");
        }

        System.out.println(sb.toString().trim());
    }
}
