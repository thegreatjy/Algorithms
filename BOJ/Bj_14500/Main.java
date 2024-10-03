package Bj_14500;

import java.io.*;

public class Main {
    static int result = -1;
    static int n = 0, m = 0;
    static int[] rows = {0, 0, 1, -1};
    static int[] cols = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);
        int[][] map = new int[n][m];
        for(int i=0; i<n; i++){
            line = br.readLine().split(" ");
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        boolean[][] visited = new boolean[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                visited[i][j] = true;
                // t 테트리스 제외 탐색
                dfs(i, j, 1, map[i][j], map, visited);

                // t 테트리스 탐색
                combination(0, i, j, 1, map[i][j], map);
                visited[i][j] = false;
            }
        }

        System.out.println(result);
    }

    public static void dfs(int r, int c, int depth, int sum, int[][] map, boolean[][] visited){
        // 종료
        if(depth >= 4){
            result = Math.max(result, sum);
            return;
        }

        int newR, newC;
        for(int i=0; i<4; i++){
            newR = r + rows[i];
            newC = c + cols[i];

            if(newR < 0 || newR >= n || newC < 0 || newC >= m)    continue;
            if(visited[newR][newC])    continue;

            visited[newR][newC] = true;
            dfs(newR, newC, depth + 1, sum + map[newR][newC], map, visited);
            visited[newR][newC] = false;
        }
    }

    public static void combination(int currentIdx, int r, int c, int depth, int sum, int[][] map){
        // 종료
        if(depth >= 4){
            result = Math.max(result, sum);
            return;
        }
        if(currentIdx >= 4){
            return;
        }

        // 조합 - rows 4개 중에서 조합
        int newR, newC;
        for(int i=currentIdx; i<4; i++){
            // i 방향을 포함
            newR = r + rows[i];
            newC = c + cols[i];

            if(newR < 0 || newR >= n || newC < 0 || newC >= m)    continue;

            combination(i + 1, r, c, depth + 1, sum + map[newR][newC], map);
            // i 방향 포함 x
        }
    }
}