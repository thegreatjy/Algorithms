package Bj_2606;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] list = new ArrayList[v+1];
        boolean[] visited = new boolean[v+1];
        // 초기화
        for(int i=0; i<=v; i++){
            list[i] = new ArrayList<>();
        }

        int start, finish;
        StringTokenizer st;
        for(int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            finish = Integer.parseInt(st.nextToken());
            list[start].add(finish);
            list[finish].add(start);
        }

        int cur, cnt = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(1);
        visited[1] = true;
        while(!deque.isEmpty()){
            cur = deque.removeLast();   // 현재 노드
            for(int i: list[cur]){  // 현재 노드에서 갈 수 있는 노드를 deque에 넣는다.
                // 방문하지 않았을 때
                if(!visited[i]){
                    deque.addLast(i);
                    visited[i] = true;  // 방문 체크
                    ++cnt;
                }
            }
        }

        System.out.println(cnt);
    }
}