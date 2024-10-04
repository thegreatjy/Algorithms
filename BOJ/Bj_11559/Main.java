package Bj_11559;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] map = new char[12][6];
        String line;
        for(int i=0; i<12; i++){
            line = br.readLine();
            map[i] = line.toCharArray();
        }

        int result = 0;
        boolean[][] visited;
        Queue<Node> q;
        boolean flag = true;    // 연쇄 일어났는지 여부
        while(true){
            visited = new boolean[12][6];
            flag = false;

            // 하나의 연쇄 bfs
            for(int i=0; i<12; i++){
                for(int j=0; j<6; j++){
                    if(visited[i][j] || map[i][j] == '.')   continue;

                    // (i, j)와 같은 색 그룹 찾기
                    ArrayList<int[]> list = new ArrayList<>();
                    q = new LinkedList<>();
                    q.add(new Node(i, j));
                    list.add(new int[]{i, j});
                    visited[i][j] = true;

                    while(!q.isEmpty()){
                        Node node = q.poll();

                        // 현재에서 상하좌우
                        for(int dir=0; dir<4; dir++){
                            int newR = node.r + rows[dir];
                            int newC = node.c + cols[dir];
                            if(newR < 0 || newR >= 12 || newC < 0 || newC >= 6)  continue;
                            if(visited[newR][newC] || map[newR][newC] != map[node.r][node.c])   continue;

                            q.add(new Node(newR, newC));
                            visited[newR][newC] = true;
                            list.add(new int[]{newR, newC});
                        }
                    }

                    // 같은 색 그룹 연쇄
                    if(list.size() >= 4){
                        flag = true;
                        for(int[] l: list){
                            map[l[0]][l[1]] = '.';
                        }
                    }
                }
            }

            if(!flag)   break;
            ++result;   // 연쇄 개수 증가

            // 내리기
            down(map);
        }

        System.out.println(result);
    }

    public static void down(char[][] map){
        int cnt = 0;

        for(int c=0; c<6; c++){
            cnt = 0;    // 하나의 열의 . 개수
            for(int r=11; r>=0; r--){
                if(map[r][c] == '.')    cnt++;
                else{
                    // map[r][c] -> map[r+cnt][c] 로 이동
                    if(cnt !=0){
                        map[cnt+r][c] = map[r][c];
                        map[r][c] = '.';
                    }
                }
            }
        }
    }
}
