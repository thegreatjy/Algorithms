package Bj_7569;

import java.util.*;
import java.io.*;

public class Main {
	static int N,M,H;
	static int [][][] map;
	static boolean[][][] near;//상하좌우앞뒤에 익은 토마토가 있는 지 없는 지 
	
	//상하좌우앞뒤
	static int[] row= {0, 0, -1, 1, 0, 0};
	static int[] col= {0, 0, 0, 0, 1, -1};
	static int[] dim= {1, -1, 0, 0, 0, 0};
	
	static class node{
		int x, y, z;
		node(int x, int y, int z){
			this.x=x;
			this.y=y;
			this.z=z;
		}
	}
	
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		M=Integer.parseInt(st.nextToken()); 
		N=Integer.parseInt(st.nextToken());
		H=Integer.parseInt(st.nextToken());
		
		map=new int[H][N][M];
		near=new boolean[H][N][M];
		Queue<node> q=new LinkedList<>();	//새로 익은 토마토를 넣어준다.
		int zeros=0;
		for(int i=0;i<H;i++) {
			for(int j=0;j<N;j++) {
				st=new StringTokenizer(br.readLine());
				for(int k=0;k<M;k++) {
					map[i][j][k]=Integer.parseInt(st.nextToken());
					if(map[i][j][k]==1)	q.offer(new node(j, k, i));
					else if(map[i][j][k]==0)	zeros++;
				}
			}
		}
		int days=0;
		while(!q.isEmpty() && zeros!=0) {
			if(zeros==0) {
				break;
			}
			int s=q.size();
			for(int qs=0;qs<s;qs++) {
				node nd=q.poll();
				for(int a=0;a<6;a++) {
					int nx=nd.x+row[a];
					int ny=nd.y+col[a];
					int nz=nd.z+dim[a];
					
					if(nx<0||nx>=N||ny<0||ny>=M||nz<0||nz>=H)	continue;
					if(map[nz][nx][ny]==0) {//주변의 안 익은 토마토 발견 
						q.offer(new node(nx, ny, nz));
						map[nz][nx][ny]=1;	//익힘 
						zeros--;
					}
				}
			}
			days++;
		}
		
		if(zeros!=0) {//안익은 토마토가 존재한다. 
			days=-1;
		}
		System.out.println(days);
	}
}