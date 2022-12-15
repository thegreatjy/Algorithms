package Bj_2133;

import java.io.*;
import java.util.*;

public class Main {
	static int N, result = 0;
	static boolean[][] map;
	
	public static void dfs(int r, int c) {
		if(r>=3 || c>=N) {
			return;
		}
		if(r==2 && c==N-1) {
			if(map[r][c])	++result;
			return;
		}
		
		//이미 타일이 깔려 있음 
		if(map[r][c]) {
			int nc = (r+1)/3;
			dfs((r+1)%3, c+nc);
			return;
		}
		//2X1 
		if(r<=1 && !map[r+1][c]) {
			map[r][c]=true;
			map[r+1][c]=true;
			dfs(r+1, c);
			map[r][c]=false;
			map[r+1][c]=false;
		}
		//1X2
		if(c+1<N && !map[r][c+1]) {
			map[r][c]=true;
			map[r][c+1]=true;
			dfs((r+1)%3, c+((r+1)/3));
			map[r][c]=false;
			map[r][c+1]=false;
		}
		
	}
	
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new boolean[3][N];
		dfs(0, 0);
		System.out.println(result);
	}

}
