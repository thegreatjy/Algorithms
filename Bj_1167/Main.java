package Bj_1167;

import java.util.*;

public class Main {    
 
    static ArrayList<Node>[] list;
    static boolean[] visited;
    static int max = 0;
    static int node;
    
    public static class Node {
    	int e;
    	int cost;
    	
    	public Node (int e, int cost){
    		this.e=e;
    		this.cost=cost;
    	}
    }
    
    //점 n에서 제일 먼 거리의 점을 구하여 node에 저장
    public static void dfs(int n, int sum) {
    	visited[n]=true;
    	if(sum>max) {
    		node=n;
    		max=sum;
    	}
    	for(int i=0; i<list[n].size(); i++) {
    		Node nd=list[n].get(i);
    		if(!visited[nd.e]) {
    			dfs(nd.e, sum+nd.cost);
    		}
    	}
    }
    
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        
        int V = scan.nextInt();
        list = new ArrayList[V + 1]; 
        for(int i = 1; i < V + 1; i++) {
            list[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < V; i++) {
            int s = scan.nextInt();
            while(true) {
                int e = scan.nextInt();
                if(e == -1) break;
                int cost = scan.nextInt();
                list[s].add(new Node(e, cost));
            }
        }
        
        //임의의 노드(1)에서 부터 가장 먼 노드를 찾는다. 이때 찾은 노드를 node에 저장한다.
        visited = new boolean[V + 1];
        dfs(1, 0);
        
        //node에서 부터 가장 먼 노트까지의 거리를 구한다.
        visited = new boolean[V + 1];
        dfs(node, 0);
        
        System.out.println(max);
    }
}
