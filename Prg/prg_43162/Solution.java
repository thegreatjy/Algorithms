package prg_43162;
import java.util.*;

public class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];

        for(int i=0; i<n; i++){
            if(!visited[i]){
                ++answer;
                bfs(i, computers, visited);
            }
        }

        return answer;
    }

    // 하나의 네트워크에 대해 방문 찍기
    public void bfs(int current, int[][] map, boolean[] visited){
        Queue<Integer> q = new LinkedList<>();
        q.add(current);
        visited[current] = true;

        int n = map.length;
        while(!q.isEmpty()){
            Integer i = q.poll();

            for(int j=0; j<n; j++){
                if(!visited[j] && map[i][j] == 1){
                    visited[j] = true;
                    q.add(j);
                }
            }
        }
    }
}