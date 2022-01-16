package Bj_7576;

import java.io.*;
import java.util.*;

public class Main {
	static class node{
		int x, y;
		
		node(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
	static int N, M, days;
	static int[][] map;
	static int[] row= {0,0,1,-1};
	static int[] col= {1,-1,0,0};
	
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str[]=br.readLine().split(" ");
		M=Integer.parseInt(str[0]);
		N=Integer.parseInt(str[1]);
		
		map=new int[N][M];
		Queue<node> q=new LinkedList<>();	//새롭게 익은 토마토를 넣는다 
		int zeros=0;	//안익은 토마토 개수 
		for(int i=0;i<N;i++) {
			str=br.readLine().split(" ");
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(str[j]);
				if(map[i][j]==1)	q.offer(new node(i, j));
				else if(map[i][j]==0)	zeros++;
			}
		}
		
		days=0;
		
		while(!q.isEmpty() && zeros!=0) {	//새로 익힌 토마토가 있고, 안익은 토마토가 존재한다. 
			if(zeros==0) {//다 익음 
				break;		
			}
			//하루 
			int s=q.size();
			for(int a=0;a<s;a++) {
				node nd=q.poll();
				for(int i=0;i<4;i++) {
					int nr=nd.x+row[i];
					int nc=nd.y+col[i];
					
					if(nr<0||nr>=N||nc<0||nc>=M)	continue;
					
					if(map[nr][nc]==0) {//주변에 안익은 토마토가 있으면 익힌다. 
						map[nr][nc]=1;
						q.offer(new node(nr, nc));
						zeros--;
					}
				}	
			}
			days++;
		}
		if(zeros!=0)	days=-1;	//안 익은 토마토가 존재 
		System.out.println(days);

	}

}
