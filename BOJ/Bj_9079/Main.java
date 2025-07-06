package Bj_9079;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int T = 0, curStatus = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        String[] line;
        int result = 0;

        for(int i=0; i<T; i++){
            curStatus = 0;

            for(int j=0; j<3; j++){
                line = br.readLine().split(" ");

                for(int k=0; k<3; k++){
                    curStatus = curStatus << 1;

                    if(line[k].equals("H")){
                        curStatus += 1;
                    }else { // T
                        curStatus += 0;
                    }
                }
            }

            result = bfs(curStatus, 0);
            sb.append(result + "\n");
        }

        System.out.print(sb.toString().trim());
    }

    /**
     *
     * @param status: 현재 동전 상태
     * @param cnt: 연산 횟수
     * @return: 모두 같은 면으로 만드는 최소 연산 횟수 혹은 -1(불가능)
     */
    public static int bfs(int status, int cnt){
        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[512];   // 111111111(2)

        queue.add(new Node(status, cnt));
        visited[status] = true;

        while(!queue.isEmpty()){
            Node nd = queue.poll();

            if(nd.status == 0 || nd.status == 511)  return nd.cnt;

            Node n;
            // 행 뒤집기
            for(int i=0; i<3; i++){
                n = new Node(nd.status, nd.cnt);
                n.status ^= (448 >> (i*3)); // i번째 행의 값을 111과 xor 연산하여 뒤집기 (111000000(2) = 448(10))

                if(!visited[n.status]){
                    visited[n.status] = true;
                    queue.add(new Node(n.status, n.cnt + 1));
                }
            }

            // 열 뒤집기
            for(int i=0; i<3; i++){
                n = new Node(nd.status, nd.cnt);
                n.status ^= (292 >> (i)); // i번째 열의 값을 100100100, 010010010, 001001001과 xor 연산하여 뒤집기 (100100100(2) = 292(10))

                if(!visited[n.status]){
                    visited[n.status] = true;
                    queue.add(new Node(n.status, n.cnt + 1));
                }
            }

            // 대각선 뒤집기 (0, 4, 8)
            n = new Node(nd.status, nd.cnt);
            n.status ^= 273; // 100010001(2) = 273(10)와 xor 연산하여 뒤집기

            if(!visited[n.status]){
                visited[n.status] = true;
                queue.add(new Node(n.status, n.cnt + 1));
            }

            // 대각선 뒤집기 (2, 4, 6)
            n = new Node(nd.status, nd.cnt);
            n.status ^= 84; // 001010100(2) = 84(10)와 xor 연산하여 뒤집기

            if(!visited[n.status]){
                visited[n.status] = true;
                queue.add(new Node(n.status, n.cnt + 1));
            }
        }

        return -1;
    }

    private static class Node{
        int status;
        int cnt;

        public Node(int status, int cnt) {
            this.status = status;
            this.cnt = cnt;
        }
    }
}
