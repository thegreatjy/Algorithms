package Bj_14226;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static boolean[][] visited = new boolean[2001][2001];    // clipboard, total
    public static int resultTime = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int s = Integer.parseInt(br.readLine());
        bfs(s);

        System.out.println(resultTime);
    }

    public static void bfs(int s){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 1, 0));
        visited[0][1] = true;

        while(!q.isEmpty()) {
            Node nd = q.poll();

            if(nd.total == s){
                resultTime = nd.time;
                break;
            }

            // 연산 1
            q.add(new Node(nd.total, nd.total, nd.time + 1));

            // 연산 2
            if(nd.clipboard > 0 && !visited[nd.clipboard][nd.total + nd.clipboard] && nd.total + nd.clipboard <= s){
                q.add(new Node(nd.clipboard, nd.total + nd.clipboard, nd.time + 1));
                visited[nd.clipboard][nd.total + nd.clipboard] = true;
            }

            // 연신 3
            if(nd.total > 0 && !visited[nd.clipboard][nd.total - 1]) {
                q.add(new Node(nd.clipboard, nd.total - 1, nd.time + 1));
                visited[nd.clipboard][nd.total - 1] = true;
            }
        }
    }

    public static class Node {
        int clipboard;
        int total;
        int time;

        public Node(int clipboard, int total, int time) {
            this.clipboard = clipboard;
            this.total = total;
            this.time = time;
        }
    }
}
