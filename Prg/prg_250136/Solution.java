package prg_250136;

import java.util.*;

class Solution {
    static int n, m;
    static int[] oils;  // i 위치에서의 석유량

    public int solution(int[][] land) {
        int answer = Integer.MIN_VALUE;
        n = land.length;
        m = land[0].length;
        oils = new int[m];

        // 덩어리 찾기
        boolean[][] visited = new boolean[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++) {
                if (visited[i][j] || land[i][j] == 0) continue;
                // 덩어리 정보 구하기
                bfs(i, j, visited, land);
            }
        }

        for(int i: oils){
            answer = Math.max(answer, i);
        }

        return answer;
    }

    // 덩어리 정보 구하기
    public void bfs(int r, int c, boolean[][] visited, int[][] land){
        int[] cols = {0, 0, 1, -1};
        int[] rows = {1, -1, 0, 0};

        // 방문해야 할 곳
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c});
        visited[r][c] = true;

        Set<Integer> colSet = new HashSet<>();  // 덩어리의 열 범위
        int size = 0;   // 덩어리 크기
        while(!q.isEmpty()){
            int[] current = q.poll();
            size++;
            colSet.add(current[1]);

            int newI = 0, newJ = 0;
            for(int seq=0; seq<4; seq++){
                newI = current[0] + rows[seq];
                newJ = current[1] + cols[seq];

                if(newI < 0 || newI >= n || newJ < 0 || newJ >= m)  continue;
                if(visited[newI][newJ] || land[newI][newJ] == 0)    continue;

                q.add(new int[]{newI, newJ});
                visited[newI][newJ] = true;
            }
        }

        // 구한 덩어리 크기를 oils 배열에 더한다.
        for(Integer col: colSet){
            oils[col] += size;
        }
    }

    public static void main(String[] args) {
        /*
        int[][] land = {{1, 0, 1, 0, 1, 1},
                        {1, 0, 1, 0, 0, 0},
                        {1, 0, 1, 0, 0, 1},
                        {1, 0, 0, 1, 0, 0},
                        {1, 0, 0, 1, 0, 1},
                        {1, 0, 0, 0, 0, 0},
                        {1, 1, 1, 1, 1, 1}};
         */
        int[][] land = {{0, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 0, 0, 0, 1, 1, 0}, {1, 1, 1, 0, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0, 1, 1}};
        int result = new Solution().solution(land);
        System.out.println(result);
    }
}
