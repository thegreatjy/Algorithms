package prg_1844;

import java.util.*;

public class Solution2 {
    static int result = Integer.MAX_VALUE;
    static int[] rows = {1, -1, 0, 0};
    static int[] cols = {0, 0, 1, -1};

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
        int n = maps.length;
        int m = maps[0].length;
        int result = -1;


        Queue<node> q = new LinkedList<>();
        q.add(new node(0, 0, 1));
        boolean[][] visited = new boolean[n][m];

        int r = 0, newR = 0, c = 0, newC = 0, cnt = 0;
        while(!q.isEmpty()){
            node cur = q.poll();
            r = cur.r;
            c = cur.c;
            cnt = cur.cnt;

            // 도착 및 종료
            if(r == n-1 && c == m-1){
                result = cnt;
                break;
            }

            // 이동
            for(int i=0; i<4; i++){
                newR = r + rows[i];
                newC = c + cols[i];

                if(newR < 0 || newR >= n || newC < 0 || newC >= m || maps[newR][newC] == 0 || visited[newR][newC]) continue;

                visited[newR][newC] = true;
                q.add(new node(newR, newC, cnt + 1));
            }
        }

        return result;
    }

    public static void main(String[] args){

    }

}
