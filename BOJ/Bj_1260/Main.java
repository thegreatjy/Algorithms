package Bj_1260;

import java.util.*;
import java.io.*;

public class Main {
	static int N, M, V;
	static ArrayList<ArrayList<Integer>> graph;
	static boolean[] visited;
	static ArrayList<Integer> List;
	
	public static void dfs(int s) {
		visited[s]=true;
		List.add(s);
		for(int i:graph.get(s)) {
			if(!visited[i]) {
				dfs(i);
			}
		}
	}
	
	public static void bfs(int s) {
		Queue<Integer> q=new LinkedList<>();	//탐색해 볼 정점을 넣음 
		q.add(s);
		visited[s]=true;
		List.add(s);
		while(!q.isEmpty()) {
			int cur=(int) q.poll();
			for(int i:graph.get(cur)) {
				if(!visited[i]) {
					q.offer(i);
					visited[i]=true;
					List.add(i);
				}
			}
		}
	}
	
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str[]=br.readLine().split(" ");
		N=Integer.parseInt(str[0]);
		M=Integer.parseInt(str[1]);
		V=Integer.parseInt(str[2])-1;
		
		int v1, v2;
		graph=new ArrayList<ArrayList<Integer>>(N);
		for(int i=0;i<N;i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i=0;i<M;i++) {
			str=br.readLine().split(" ");
			v1=Integer.parseInt(str[0])-1;
			v2=Integer.parseInt(str[1])-1;
			
			graph.get(v1).add(v2);
			graph.get(v2).add(v1);
		}
	
		visited=new boolean[N];
		List=new ArrayList<Integer>();
		
		for (int i = 0; i < N; i++) { Collections.sort(graph.get(i)); }

		dfs(V);
		for(int i:List) {
			System.out.print((i+1)+" ");
		}
		System.out.println();
		
		Arrays.fill(visited, false);
		List.clear();
		
		bfs(V);
		for(int i:List) {
			System.out.print((i+1)+" ");
		}
	}
}