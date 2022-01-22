package Bj_1753;

import java.io.*;
import java.util.*;

public class Main_2 {
	static int V, E, K;
	static int[] distance;	//시작점 K로부터 최단 거리
	static ArrayList<ArrayList<node>> graph;	//정점, weight 저장 
	
	static class node{
		int dest;	//정점 
		int cost;	//그 정점까지의 거리 
		node(int dest, int cost){
			this.dest=dest;
			this.cost=cost;
		}
	}

	public static void dijk(int start) {
		PriorityQueue<node> pq=new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
		distance[start]=0;
		pq.offer(new node(start, distance[start]));
		
		while(!pq.isEmpty()) {
			node nd = pq.poll();	//distance가 갱신된 적 있는 노드  
			
			//현재 계산된 정점v까지의 거리가 정점v까지 최단거리보다 짧으면
			//정점v에 연결되어있는 다른 정점들의 시작점으로부터 최단 거리(distance)를 갱신해봐야한다.
			if(nd.cost>distance[nd.dest]) {	
				continue;
			}
			
			//노드와 연결되어있는 노드의 distance 갱신 
			for(int i=0;i<graph.get(nd.dest).size();i++) {
				node nearnd = graph.get(nd.dest).get(i);
				if(distance[nearnd.dest]>distance[nd.dest]+nearnd.cost) {
					distance[nearnd.dest]=distance[nd.dest]+nearnd.cost;
					pq.offer(new node(nearnd.dest, distance[nearnd.dest]));
				}
			}
			
		}
		
	}
	
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] str=br.readLine().split(" ");
		V=Integer.parseInt(str[0]);	//정점 개수 
		E=Integer.parseInt(str[1]);	//간선 개수 
		K=Integer.parseInt(br.readLine())-1;	//시작 정점 
		
		graph=new ArrayList<ArrayList<node>>(V);
		for(int i=0;i<V;i++) {
			graph.add(new ArrayList<node>());
		}
		
		for(int i=0;i<E;i++	) {
			str=br.readLine().split(" ");
			int s=Integer.parseInt(str[0])-1;
			int f=Integer.parseInt(str[1])-1;
			int val=Integer.parseInt(str[2]);
			graph.get(s).add(new node(f, val));
		}
		
		distance=new int[V];
		Arrays.fill(distance, Integer.MAX_VALUE);
		dijk(K);
		
		for(int dis:distance) {
			if(dis==Integer.MAX_VALUE)	System.out.println("INF");
			else	System.out.println(dis);
		}
	}
}
