package Bj_1987;

import java.util.*;
import java.io.*;

public class Main_2 {
	static int R, C, result=0;
	static int[][] map;
	static boolean[] visited;
	static int[] row= {0,0,1,-1};
	static int[] col= {1,-1,0,0};
	
	public static void dfs(int r, int c, int cnt) {//r,c 현재 위치/cnt 여태까지 온 길 개수
		visited[map[r][c]]=true;
		if(cnt+1>result) {
			result=cnt+1;
		}
		for(int i=0;i<4;i++) {
			int nr=r+row[i];
			int nc=c+col[i];
			if(nr<0||nr>=R||nc<0||nc>=C)	continue;
			if(!visited[map[nr][nc]]) {
				dfs(nr, nc, cnt+1);
				visited[map[nr][nc]]=false;
			}
		}
	}
	
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] str=br.readLine().split(" ");
		R=Integer.parseInt(str[0]);
		C=Integer.parseInt(str[1]);
		map=new int[R][C];
		visited=new boolean[26];
		for(int i=0;i<R;i++) {
			String temp=br.readLine();
			for(int j=0;j<C;j++) {
				map[i][j]=temp.charAt(j)-'A';
			}
		}
		dfs(0, 0, 0);
		System.out.println(result);
	}
}