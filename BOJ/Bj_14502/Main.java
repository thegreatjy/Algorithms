package Bj_14502;

import java.util.*;
import java.io.*;

public class Main {
	static int N, M, max=Integer.MIN_VALUE;
	static int[][] map;
	static int[] row= {0,0,1,-1};
	static int[] col= {1,-1,0,0};
	
	public static void func(int left) {
		if(left<=0) {
			safeZone(map);
			return;
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==0) {
					map[i][j]=1;
					func(left-1);
					map[i][j]=0;
				}
			}
		}
	}
	
	public static void safeZone(int[][] map) {
		Queue<Point> q=new LinkedList<>();
		int[][] newMap=new int[N][M];

		//2인 map[i][j]을 큐에 넣는다. 
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				newMap[i][j]=map[i][j];
				if(map[i][j]==2) {
					q.offer(new Point(i,j));
				}
			}
		}
		
		//바이러스 퍼트림 
		while(!q.isEmpty()) {
			Point p=q.poll();
			int x=p.x;
			int y=p.y;
			for(int i=0;i<4;i++) {
				int nx=x+row[i];
				int ny=y+col[i];
				if(nx<0||nx>=N||ny<0||ny>=M||newMap[nx][ny]!=0)	continue;
				newMap[nx][ny]=2;
				q.offer(new Point(nx, ny));
			}
		}
		
		//0을 센다.
		int cnt=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(newMap[i][j]==0) {
					cnt++;
				}
			}
		}
		if(cnt>max) {
			max=cnt;
		}
		return;
	}
	
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String str[]=br.readLine().split(" ");
		N=Integer.parseInt(str[0]);
		M=Integer.parseInt(str[1]);
		map=new int[N][M];
		for(int i=0;i<N;i++) {
			str=br.readLine().split(" ");
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(str[j]);
			}
		}
		func(3);
		System.out.println(max);
	}
	
	static class Point {
		int x,y;
		Point(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
}