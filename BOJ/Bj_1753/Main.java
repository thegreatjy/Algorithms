package Bj_1753;

import java.util.*;
import java.io.*;

//메모리 초과 뜸 !
public class Main {
	static int V, E, K;
	static int[] distance;	//시작점 K로부터 최단 거리
	static boolean[] visited;
	static int[][] map;
	
	//정점 s->정점 f 최단 경로 
	public static int dijk(int s, int f) {
		Arrays.fill(distance, Integer.MAX_VALUE);
		Arrays.fill(visited, false);
		Queue<Integer> q=new LinkedList<Integer>();	//방문할 정점을 넣음 
		q.offer(s);
		distance[s]=0;
		while(!q.isEmpty()) {
			int a=q.poll();
			if(a==f) {
				return distance[f];
			}
			visited[a]=true;
			int nextq=-1;	//방문하지 않은 정점 중에서 distance가 최소인 정점  
			int min=Integer.MAX_VALUE;	//min=distance[]중 제일 작은 수 
			for(int i=0;i<V;i++) {
				if(map[a][i]==Integer.MAX_VALUE)	continue;
				distance[i]=Math.min(distance[i], distance[a]+map[a][i]);
				if(!visited[i] && distance[i]<min) {
					min=distance[i];
					nextq=i;
				}
			}
			if(nextq!=-1)	q.offer(nextq);
		}
		return Integer.MAX_VALUE;
	}
	
	
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] str=br.readLine().split(" ");
		V=Integer.parseInt(str[0]);	//정점 개수 
		E=Integer.parseInt(str[1]);	//간선 개수 
		K=Integer.parseInt(br.readLine())-1;	//시작 정점 
		
		map=new int[V][V];
		for(int i=0;i<V;i++) {
			Arrays.fill(map[i], Integer.MAX_VALUE);
		}
		for(int i=0;i<E;i++	) {
			str=br.readLine().split(" ");
			int s=Integer.parseInt(str[0])-1;
			int f=Integer.parseInt(str[1])-1;
			int val=Integer.parseInt(str[2]);
			if(val<map[s][f]) {
				map[s][f]=val;
			}
		}
		
		distance=new int[V];
		visited=new boolean[V];
		for(int i=0;i<V;i++) {
			int result=dijk(K, i);
			if(result==Integer.MAX_VALUE)	System.out.println("INF");
			else	System.out.println(result);
		}
		
	}

}
