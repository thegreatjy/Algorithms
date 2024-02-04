package Bj_1915;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int n,m, max = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);

        int[][] map = new int[n][m];
        int[][] dp = new int[n][m];
        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<m; j++){
                map[i][j] = str.charAt(j) - '0';
                dp[i][j] = map[i][j];

                if(i-1 >= 0 && j-1 >= 0 && dp[i][j] == 1){
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }

                if (dp[i][j] > max) {
                    max = dp[i][j];
                }
            }
        }

        System.out.print(max * max);
    }
}
