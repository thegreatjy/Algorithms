package Bj_2637;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] result = new int[n+1]; // arr[i] = n 노드(완제품)까지 필요한 i 부품의 개수
        int[][] dag = new int[n+1][n+1]; // dag[x][y] = k. x->y n개. y 부품을 만드는데 x 부품이 k개 필요하다.
        boolean[] notOriginal = new boolean[n+1]; // i 부품이 중간 부품인지 아닌지 여부
        int[] outDegree =  new int[n+1]; // outDegree[i] = i 부품의 진출 차수

        // 연결 관계 dag 초기화
        int x, y, k;
        for(int i=1; i<=m ; i++){
            st = new StringTokenizer(br.readLine());
            y = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            dag[x][y] = k; // x -> y : k
            ++outDegree[x];
            notOriginal[y] = true; // y 부품은 기본 부품이 아니고 중간 부품이, 완제품이다.
        }

        // 진출차수가 0인 노드를 Queue에 넣는다.
        // 진출 차수가 0인 노드 = 완제품.
        Queue<Integer> queue = new ArrayDeque<Integer>();
        for(int i=1; i<=n; i++){
            if(outDegree[i] == 0){
                queue.add(i);
                result[i] = 1;
            }
        }

        // queue에서 노드 하나씩 빼면서 인접 노드를 순회한다. queue가 빌 때까지.
        while(!queue.isEmpty()){
            // queue에서 노드 하나를 꺼낸다.
            int q = queue.poll();

            // 그 노드의 인접 노드들(그 노드로 진입하는 노드들)을 탐색
            for(int i=1; i<=n ; i++){
                if(dag[i][q] > 0){ // 인접 노드라면 (i = 인접노드)
                    // 완제품을 만드는데 필요한 제품으로 추가한다.
                    result[i] = result[i] + (result[q] * dag[i][q]);
                    // 인접 노드의 진출노드를 감소한다.
                    --outDegree[i];
                    // 인접 노드의 진출노드가 0이 되었다면, queue에 추가한다.
                    if(outDegree[i] == 0) {
                        queue.add(i);
                    }
                }
            }
        }

        // 완제품을 만드는데 필요한 기본 부품의 개수를 출력
        for(int i=1; i<n; i++){
            if(!notOriginal[i]){
                sb.append(i + " " + result[i] + "\n");
            }
        }
        System.out.printf(sb.toString().trim());
    }
}
