package Bj_2579;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] score = new int[n];
        for(int i=0; i<n; i++){
            score[i] = Integer.parseInt(br.readLine());
        }

        int temp0 = 0, temp1 = 0;
        int[] dp = new int[n];
        for(int i=0; i<n; i++){
            if(i==0){
                dp[0] = score[0];
                continue;
            }
            if(i==1){
                dp[1] = score[0] + score[1];
                continue;
            }

            temp0 = 0; temp1 = 0;
            temp0 = dp[i-2] + score[i];
            if(i<3){
                temp1 = score[i-1] + score[i];
            }else{
                temp1 = dp[i-3] + score[i-1] + score[i];
            }

            dp[i] = Math.max(temp0, temp1);
        }

        System.out.println(dp[n-1]);
    }
}
