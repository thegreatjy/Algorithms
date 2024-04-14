package prg_1844;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    static int[] rows = {0, 0, 1, -1};
    static int[] cols = {1, -1, 0, 0};

    class node{
        int r;
        int c;
        int cnt;

        node(int r, int c, int cnt){
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
    
    public int solution(int[][] maps) {
        int answer = -1;
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];

        Deque<node> queue = new ArrayDeque<>();
        queue.addLast(new node(0, 0, 1));
        visited[0][0] = true;

        int newR, newC;
        while(!queue.isEmpty()){
            node cur = queue.removeFirst();

            if(cur.r == n - 1 && cur.c == m - 1){
                answer = cur.cnt;
            }

            for(int i=0; i<4; i++){
                newR = cur.r + rows[i];
                newC = cur.c + cols[i];

                if(newR < 0 || newR >= n || newC < 0 || newC >= m || maps[newR][newC] == 0 || visited[newR][newC]) continue;

                queue.addLast(new node(newR, newC, cur.cnt + 1));
                visited[newR][newC] = true;
            }
        }

        return answer;
    }
}
