package Bj_2302;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] dp = new int[41];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        int result = 1, last = 0;
        for(int i=0; i<m; i++){
            int cur = Integer.parseInt(br.readLine());
            result = result * dp[cur - last - 1];
            last = cur;
        }
        result = result * dp[n - last];

        System.out.println(result);
    }
}
