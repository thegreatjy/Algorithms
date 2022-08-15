package Bj_14503;

import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int r, c, d, cnt = 0;
	static int[][] map;
	static boolean[][] cleaned;
	static int[] row = {0,1,0,-1};
	static int[] col = {-1,0,1,0};
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		cleaned = new boolean[N][M];
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		if(cleaned[r][c]==false && map[r][c]==0) {
			dfs(r, c);
		}
		
		System.out.println(cnt);
		return ;
		
	}

	static void dfs(int r, int c) {
		int nr = 0, nc = 0;
		//현재 위치 청소 
		cleaned[r][c]=true;
		++cnt;
		
		//System.out.println(r+", "+c);
		
		//현재 위치 주변 탐색 
		for(int i=0;i<4;i++) {
			int rot = (4-d+i)%4;
			nr = r + row[rot];
			nc = c + col[rot];
			//주변 청소할 곳 찾으면 회전(방향d바꿈) 후, 그 곳으로 이동 
			if(cleaned[nr][nc]==false && map[nr][nc]==0) {
				d = d - (i+1);
				dfs(nr, nc);
				return ;
			}
		}
		
		//네 방향 모두 청소||벽 -> 방향 유지 & 후진
		nr = r +row[(4-d+1)%4];
		nc = c +col[(4-d+1)%4];
		if(map[nr][nc] == 0) {
			--cnt;
			dfs(nr, nc);
			return ;
		}else {
			return ;
		}
	}
}
