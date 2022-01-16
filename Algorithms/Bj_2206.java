package Algorithms;

import java.util.*;
import java.io.*;

public class Bj_2206 {
	static int N, M, min=1111112;
	static boolean[][] visited;
	static int[][] map;
	//사방위
	static int row[]= {0, 0, 1, -1};
	static int col[]= {1, -1, 0, 0};
	//static boolean flag=false;	//벽을 1번 이상 부순 경우 true
	
	public static int func(int r, int c, boolean flag) {
		visited[r][c]=true;
		int nr,nc, result=11111117;
		
		if(r==N && c==M) {	//도착 
			return 1;
		}
		int temp=1111113;
		for(int a=0;a<4;a++) {
			nr=r+row[a];
			nc=c+col[a];
			
			if(nr>0&&nr<=N&&nc>0&&nc<=M && !visited[nr][nc]) {
				if(map[nr][nc]==0) {
					temp=func(nr, nc, flag);
				}else if(!flag) {//벽이 있으며 벽을 깬 적이 없는 경우 
					temp=Math.min(func(nr, nc, true), func(nr, nc, false));
				}
				else {//벽이 있으며 벽을 깬 적이 있는 경우 
					temp=11111111;
				}
				result=Math.min(temp, result);
				visited[nr][nc]=false;
			}
			
		}
		
		return result+1;
	}
	
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new int[N+1][M+1];
		visited=new boolean[N+1][M+1];
		
		for(int i=1;i<=N;i++) {
			//st=new StringTokenizer(bf.readLine());
			String l=bf.readLine();
			for(int j=1;j<=M;j++) {
				map[i][j]=l.charAt(j-1)-'0';
			}
		}
		
		for(int i=1;i<=N;i++) {
			//st=new StringTokenizer(bf.readLine());
			//String l=bf.readLine();
			for(int j=1;j<=M;j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		
		System.out.println(func(1, 1, false));
		System.out.println(min);
	}

}
