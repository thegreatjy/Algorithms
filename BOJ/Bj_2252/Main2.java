package Bj_2252;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer stringBuffer = new StringBuffer(); // 정답 문자열을 저장한다.

        int n = Integer.parseInt(st.nextToken()); // 학생 수 (정점 수 vertex)
        int m = Integer.parseInt(st.nextToken()); // 학생-학생 연결 수 (간선 수 edge)

        // 학생 간선 생성
        List<Integer>[] student = new ArrayList[n+1];
        for(int i=0; i<=n; i++){
            student[i] = new ArrayList<Integer>(); // 학생 i의 뒤에 연결된 학생들을 저장하는 ArrayList
        }

        // 진입차수 계산 + 간선 연결
        int[] inDegree = new int[n+1]; // 각 학생(정점)에서 진입차수를 저장한다. inDegree[i] = i 학생의 진입차수
        for(int i=0; i<m; i++){
            // 학생 a -> 학생 b
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // a->b 간선 연결
            student[a].add(b);

            // b의 진입차수 증가
            ++inDegree[b];
        }

        // 진입차수가 0인 학생(정점) 찾기
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i=1; i<=n; i++){
            if(inDegree[i] == 0){
                queue.add(i);
                stringBuffer.append(i+" "); // 정답 문자열에 추가
            }
        }

        // 큐에서 노드 하나를 꺼내서 연결된 노드들의 진입차수를 감소한다. 큐가 빌 때까지!
        while(!queue.isEmpty()){
            // 큐에서 노드 하나를 꺼냄
            int num = queue.poll();

            // 그 노드의 인접 노드들을 조회
            List<Integer> adjacent = student[num];

            // 인접 노드들의 진입차수를 1만큼 감소
            for(int a: adjacent){
                --inDegree[a];

                // 진입 차수가 0이 되었다면 큐에 추가한다.
                if(inDegree[a] == 0){
                    queue.add(a);
                    stringBuffer.append(a+" "); // 정답 문자열에 추가
                }
            }
        }

        System.out.println(stringBuffer.toString());
    }
}
