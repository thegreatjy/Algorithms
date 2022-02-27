package Bj_2178;

import java.util.*;
import java.io.*;

public class Main {
	static int N, M, result;
	static int[][] map;
	static boolean[][] visited;
	static int[] row = {0,0,1,-1};
	static int[] col = {-1,1,0,0};
	
	public static void dfs(int r, int c, int cnt) {
		if(r == N-1 && c == M-1) {
			result = Math.min(result, cnt);
			return ;
		}
		
		for(int i=0; i<4; i++) {
			int nr = r + row[i];
			int nc = c + col[i];
			if(nr<0 || nr>=N || nc<0 || nc>=M)	continue;
			
			if(map[nr][nc]==1 && !visited[nr][nc]) {
				visited[nr][nc]=true;
				dfs(nr, nc, cnt+1);
				visited[nr][nc] = false;
			}
		}
		
		return ;
	}
	
	public static void bfs() {
		Queue<node> q = new LinkedList<>();
		q.offer(new node(0,0));
		int r, c, nr, nc;
		while(!q.isEmpty()) {
			node cur = q.poll();
			r = cur.x;
			c = cur.y;
			
			if(r==N-1 && c==M-1) {
				result = map[r][c];
				return;
			}
			
			for(int i=0; i<4; i++) {
				nr = r + row[i];
				nc = c + col[i];
				if(nr<0 || nr>=N || nc<0 || nc>=M)	continue;
				if(map[nr][nc]!=0 && !visited[nr][nc]) {
					visited[nr][nc]=true;
					q.offer(new node(nr, nc));
					map[nr][nc] = map[r][c]+1;
				}
			}
		}
		
	}
	
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		N = Integer.parseInt(line[0]); M = Integer.parseInt(line[1]);
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			line[0] = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = line[0].charAt(j)-'0';
			}
		}
		visited = new boolean[N][M];
		/*
		 * result = Integer.MAX_VALUE;
		 * dfs(0,0,0);
		 * ++result;
		 */
		visited[0][0]=true;
		result = 0;
		bfs();
		System.out.println(result);
	}
	
	static class node{
		int x;
		int y;
		node (int x, int y){
			this.x=x;
			this.y=y;
		}
	}
}
