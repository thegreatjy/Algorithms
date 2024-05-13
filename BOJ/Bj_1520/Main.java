package Bj_1520;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N, M;
    static int[] rows = {0,0,1,-1};
    static int[] cols = {1,-1,0,0};
    static int[][][] dp;

    // (r, c) -> (m-1, n-1) 경로 개수 반환
    public static int dp(int r, int c, int[][] map, int[][][] dp){
        // 도착
        if(r == M-1 && c == N-1){
            return 1;
        }

        // 이미 계산한 적이 있다.
        if(dp[r][c][0] == 1)   return dp[r][c][1];

        // 상하좌우 칸의 내리막길 경로 개수를 합산한다.
        int result = 0;
        int newR, newC;
        for(int i=0; i<4; i++){
            newR = r + rows[i];
            newC = c + cols[i];

            // map 범위
            if(newR < 0 || newR >= M || newC < 0 || newC >= N)  continue;

            // 내리막길
            if(map[r][c] <= map[newR][newC])    continue;

            result += dp(newR, newC, map, dp);
        }

        dp[r][c][0] = 1; // 계산했다고 표기
        dp[r][c][1] = result;

        return result;
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        M = Integer.parseInt(line[0]);   // 세로
        N = Integer.parseInt(line[1]);   // 가로

        int[][] map = new int[M][N];

        for(int i=0; i<M; i++){
            line = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        dp = new int[M][N][2];
        int result = dp(0, 0, map, dp);

        System.out.print(result);
    }
}
