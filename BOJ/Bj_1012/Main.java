package Bj_1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int T=0, M=0, N=0, K=0;
    static int[] rows = {0, 0, 1, -1};
    static int[] cols = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int[][] map;
        boolean[][] visited;
        String[] line;
        int x = 0, y = 0, cnt = 0;

        for(int i=0; i<T; i++){
            cnt = 0;
            line = br.readLine().split(" ");
            M = Integer.parseInt(line[0]);
            N = Integer.parseInt(line[1]);
            K = Integer.parseInt(line[2]);

            map = new int[M][N];
            visited = new boolean[M][N];
            for(int j=0; j<K; j++){
                line = br.readLine().split(" ");
                x = Integer.parseInt(line[0]);
                y = Integer.parseInt(line[1]);

                map[x][y] = 1;
            }

            for(int a=0; a<M; a++){
                for(int b=0; b<N; b++){
                    if(!visited[a][b] && map[a][b] == 1){
                        bfs(map, visited, a, b);
                        ++cnt;
                    }
                }
            }

            sb.append(cnt+"\n");
        }

        System.out.print(sb.toString().trim());
    }

    private static void bfs(int[][] map, boolean[][] visited, int r, int c) {
        visited[r][c] = true;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(r, c));

        while(!queue.isEmpty()) {
            Node nd = queue.poll();
            int curR = nd.r;
            int curC = nd.c;

            for (int i = 0; i < 4; i++) {
                int newR = curR + rows[i];
                int newC = curC + cols[i];

                if(newR < 0 || newR >= M || newC < 0 || newC >= N)  continue;

                if(!visited[newR][newC] && map[newR][newC] == 1){
                    visited[newR][newC] = true;
                    queue.add(new Node(newR, newC));
                }
            }
        }
    }

    private static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
