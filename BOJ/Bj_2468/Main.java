package Bj_2468;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int n = 0;
    static int[] rows = {0, 0, 1, -1};
    static int[] cols = {1, -1, 0, 0};

    static class Node{
        int r;
        int c;
        Node(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        int max = -1, min = Integer.MAX_VALUE;  // map 중 min, max
        int result = 0;

        String[] line;
        for(int i=0; i<n; i++){
            line = br.readLine().split(" ");
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(line[j]);

                max = Math.max(max, map[i][j]);
                min = Math.min(min, map[i][j]);
            }
        }

        // 비 양을 정한다.
        int cnt = 0, newR, newC;
        boolean[][] visited = new boolean[n][n];
        Node node;
        Queue<Node> q;
        for(int rain=0; rain<=max; rain++){
            cnt = 0;    // rain 양일 때의 안전 영역 개수
            visited = new boolean[n][n];

            q = new LinkedList<>();
            // rain 일 때, 안전 영역 구하기
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(map[i][j] - rain > 0 && !visited[i][j]){
                        // 현재칸 (i,j)가 물에 잠기지 않았을 때
                        // bfs
                        visited[i][j] = true;
                        q.add(new Node(i, j));
                        ++cnt;

                        while(!q.isEmpty()){
                            node = q.poll();

                            for(int dir=0; dir<4; dir++){
                                newR = node.r + rows[dir];
                                newC = node.c + cols[dir];

                                if(newR < 0 || newR >= n || newC < 0 || newC >= n)    continue;
                                if(visited[newR][newC] || (map[newR][newC] - rain <= 0))    continue;

                                q.add(new Node(newR, newC));
                                visited[newR][newC] = true;
                            }
                        }
                    }
                }
            }

            result = Math.max(result, cnt);
        }

        System.out.println(result);
    }
}
