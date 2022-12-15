package Bj_12665;

import java.io.*;
import java.util.*;

public class Main {
	static int n = 1;
	static int[][] map, dp;
	static int[] row = {0,0,1,-1};
	static int[] col = {1,-1,0,0};
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for(int i=0;i<n;i++) {
			String line = br.readLine();
			for(int j=0;j<n;j++) {
				map[i][j] = line.charAt(j)-'0';
			}
		}
		dp = new int[n][n];
		dp[0][0] = 0;
		int upper = 0, left = 0, min = Integer.MAX_VALUE;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(i == 0) {		//제일 윗줄 
					upper = Integer.MAX_VALUE;
					if(j == 0)	left = 0;	//좌표 0,0
					else		left = dp[i][j-1];
				}else if(j==0) {	//제일 왼쪽줄 
					upper = dp[i-1][j];
					left = Integer.MAX_VALUE;
				}else {
					upper = dp[i-1][j];
					left = dp[i][j-1];
				}
				int wall = map[i][j]==0?1:0;	//검은방이면(0) 1, 흰색방이면(1) 0  
				dp[i][j] = Math.min(upper, left) + wall;
			}
		}
		
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(0, 0));
		while(!q.isEmpty()) {
			Node cur = q.poll();
			int r = cur.r;
			int c = cur.c;
			for(int i=0;i<4;i++) {
				int nr = r + row[i];
				int nc = c + col[i];
				if(nr<0 || nr>=n || nc<0 || nc>=n) {
					continue;
				}
				if(map[nr][nc]==0) {
					dp[nr][nc] = dp[r][c] + 1;
				}
			}
		}
		
		System.out.println(dp[n-1][n-1]);
		
	}
}

class Node{
	int r;
	int c;
	Node(int r, int c){
		this.r = r;
		this.c = c;
	}
}