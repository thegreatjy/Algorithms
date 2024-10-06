package prg_87946;

import java.util.*;

// 8;51-9;12
public class Solution {
    static int max = 0;

    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        int n = dungeons.length;
        System.out.println(dungeons.length);

        boolean[] visited = new boolean[n];
        dfs(0, k, 0, dungeons, visited);


        return max;
    }

    // 던전 인덱스, 현재피로도, 던전개수
    public void dfs(int curDg, int curK, int depth, int[][] dungeons, boolean[] visited){
        // depth 갱신
        max = Math.max(max, depth);

        // 종료
        if(curDg >= dungeons.length){
            return;
        }

        for(int i=0; i<dungeons.length; i++){
            // i 던전 간다.
            if(!visited[i] && curK >= dungeons[i][0]){
                visited[i] = true;
                dfs(i, curK-dungeons[i][1], depth+1, dungeons, visited);
                visited[i] = false;
            }
            // i 던전 안 간다.
        }
    }
}