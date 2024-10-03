package Bj_15686;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main2 {
    static int n, m, result = Integer.MAX_VALUE;   // 치킨집 개수

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
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);
        int[][] map = new int[n][n];
        List<Node> chList = new ArrayList<>();  // 치킨집 리스트
        for(int i=0; i<n; i++){
            line = br.readLine().split(" ");
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(line[j]);

                if(map[i][j] == 2) {
                    chList.add(new Node(i, j));
                }
            }
        }

        boolean[] visited = new boolean[chList.size()];
        combination(0, 0, visited, map, chList);

        System.out.println(result);
    }

    // 현재 인덱스, 선택한 치킨집 개수, 방문
    public static void combination(int curIdx, int cnt, boolean[] visited, int[][] map, List chList){
        // 종료
        if(cnt >= m){
            /*
            for(int v=0; v<visited.length; v++){
                System.out.print(visited[v] + " ");
            }
            System.out.println();

            for(Object o: chList){
                Node node = (Node)o;
                System.out.println(node.r + " " + node.c);
            }
            System.out.println(" ===== ");

             */
            // 치킨 거리 구하기
            count(visited, map, chList);

            return;
        }

        // 조합
        for(int i=curIdx; i< visited.length; i++){
            // i 치킨집 선택
            visited[i] = true;
            combination(i + 1, cnt + 1, visited, map, chList);
            // i 치킨집 미선택
            visited[i] = false;
        }
    }

    public static void count(boolean[] visited, int [][] map, List chList){
        int sum = 0, minDistance = Integer.MAX_VALUE;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j] != 1)  continue;

                minDistance = Integer.MAX_VALUE;    // (i, j)집의 치킨 거리
                for(int v=0; v < visited.length; v++){
                    if(!visited[v]) continue;
                    // v 치킨집에 대해서 (i,j) 집과의 거리를 구한다.
                    // 최소일 경우 minDistance에 갱신되어 치킨 거리가 된다.
                    Node node = (Node)chList.get(v);
                    minDistance = Math.min(minDistance, Math.abs(node.r - i) + Math.abs(node.c - j));
                }
                sum += minDistance;
            }
        }

        result = Math.min(result, sum);
    }
}
