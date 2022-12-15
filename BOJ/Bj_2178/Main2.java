package Bj_2178;

import java.io.*;
import java.util.*;

public class Main2 {
	static int N, M, result;
	static int[][] map;
	static boolean[][] visited;
	static int[] row = {0,0,1,-1};
	static int[] col = {-1,1,0,0};
	
	static void dfs(int r, int c) { 
		if(r == N-1 && c == M-1) {
			result = map[r][c];
		}
		
		visited[r][c] = true;
		int tempR;
		int tempC;
		for(int i=0;i<4;i++) {
			tempR = r + row[i];
			tempC = c + col[i];
			
			if(tempR >= N || tempR<0 || tempC >=M || tempC<0)	continue;
			if(map[tempR][tempC] == 0 || visited[tempR][tempC])	continue;
			map[tempR][tempC] = map[r][c] + 1;
			dfs(tempR, tempC);
		}
	}
	//질문 1. 인터넷 검색? /// 질문 2. 코딩테스트 1차수, 2차수 시간이 다른데 시간 변경이 가능한지? //몇문제?
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		N = Integer.parseInt(line[0]); 
		M = Integer.parseInt(line[1]);
		map = new int[N][M];
		visited = new boolean[N][M];
		for(int i=0;i<N;i++) {
			line[0] = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j] = line[0].charAt(j) - '0';
			}
		}
		
		result = 0;
		
		//bfs
		/*
		Queue<node> q = new LinkedList<>();
		q.add(new node(0,0));
		int qr, curR;
		int qc, curC;
		while(!q.isEmpty()) {
			node curNode = q.poll();
			qr = curNode.r;
			qc = curNode.c;
			
			if(qr == N-1 && qc == M-1) {
				result = map[qr][qc];
				break;
			}
			
			visited[qr][qc] = true;
			
			for(int i=0;i<4;i++) {
				curR = qr + row[i];
				curC = qc + col[i];
				if(curR >= N || curR<0 || curC >=M || curC<0)	continue;
				if(map[curR][curC] == 0 || visited[curR][curC]) continue;
				q.add(new node(curR, curC));
				map[curR][curC] = map[qr][qc] + 1;
			}
			
		}
		
		
		*/
		
		
		//dfs
		dfs(0, 0);
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println(result);
	}
	
	static class node{
		int r;
		int c;
		node (int r, int c){
			this.r = r;
			this.c = c;
		}
	}
}
