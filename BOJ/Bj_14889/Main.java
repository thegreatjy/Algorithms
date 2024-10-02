package Bj_14889;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int[][] map;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[] line;
        map = new int[n][n];
        for(int i=0; i<n; i++){
            line = br.readLine().split(" ");
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        // 팀 조합 구하기
        boolean[] visited = new boolean[n];
        func(0, 0, visited);

        System.out.println(result);
    }

    public static void func(int currentIdx, int cnt, boolean[] visited){
        // 종료
        if(cnt >= n/2){
            countDiff(visited);
            return;
        }
        if(currentIdx >= n){
            return;
        }

        for(int i=currentIdx; i<n; i++){
            // currentIdx 포함
            visited[i] = true;
            func(i + 1, cnt + 1, visited);
            // currentIdx 포함 x
            visited[i] = false;
        }
    }

    public static void countDiff(boolean[] visited){
        int startSum = 0, linkSum = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(visited[i] && visited[j]){
                    startSum += map[i][j];
                }else if(!visited[i] && ! visited[j]){
                    linkSum += map[i][j];
                }
            }
        }
        result = Math.min(result, Math.abs(startSum - linkSum));


        /*
        int startIdx = 0, linkIdx = 0;
        for(int i=0; i<n; i++){
            if(visited[i]){
                start[startIdx++] = i;
            }else{
                link[linkIdx++] = i;
            }
        }

        int startSum = 0, linkSum = 0;
        for(int i=0; i<n/2; i++){
            for(int j=0; j<n/2; j++){
                startSum += map[start[i]][start[j]];
                linkSum += map[link[i]][link[j]];
            }
        }
         */
    }
}
