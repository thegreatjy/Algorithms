package Bj_11779;

import java.util.*;
import java.io.*;

public class Main {
	static ArrayList<Node>[] list;
    static int n, m, start, end; 
    static int[] dist;
    static int[] route; // 직전 노드 저장
    static boolean[] visited; 
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        
        list = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        
        String[] temp = new String[3];
        for(int i = 0; i < m; i++) {
        	temp = br.readLine().split(" ");
            int s = Integer.parseInt(temp[0]);
            int e = Integer.parseInt(temp[1]);
            int c = Integer.parseInt(temp[2]);
            list[s].add(new Node(e, c));
        }
        temp = br.readLine().split(" ");
        start = Integer.parseInt(temp[0]);
        end = Integer.parseInt(temp[1]);
        
        dist = new int[n + 1];
        route = new int[n + 1];
        Arrays.fill(dist, 1000000001);
        visited = new boolean[n + 1];
        
        dijkstra();
        
        //최소비용 
        System.out.println(dist[end]);
        
        //경로에 포함된 도시 개수 
        ArrayList<Integer> routes = new ArrayList<>();
        int current = end;
        while(current != 0) {
            routes.add(current);
            current = route[current];
        }
        System.out.println(routes.size());
        
        //경로 출력 
        for(int i = routes.size() - 1; i >= 0; i--) {
            System.out.print(routes.get(i) + " ");
        }
    }
    
    public static void dijkstra() {
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(start, 0));
        dist[start] = 0;
        route[start] = 0;
        
        while(!q.isEmpty()) {
            Node current = q.poll();
            
            if(!visited[current.e]) visited[current.e] = true;
            else continue;
            
            for(int i = 0; i < list[current.e].size(); i++) {
                Node next = list[current.e].get(i);
                if(dist[next.e] > dist[current.e] + next.cost) {
                    dist[next.e] = dist[current.e] + next.cost;
                    q.offer(new Node(next.e, dist[next.e]));
                    route[next.e] = current.e;
                }
            }
        }
    }
    
    public static class Node implements Comparable<Node> {
        int e;
        int cost;
        
        public Node(int e, int cost) {
            this.e = e;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node n) {
            return this.cost - n.cost;
        }
    }
}
