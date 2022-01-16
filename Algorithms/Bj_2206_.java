package Algorithms;

import java.util.*;
import java.io.*;

public class Bj_2206_ {
	static int N, M, ans;
	static int[][] accum, map;	//누적 공사 횟수 
	static int[] row= {0,0,1,-1};
	static int[] col= {1,-1,0,0};
	
	static class node{
		int x;
		int y;
		int length;
		int work;	//벽 공사 횟수 
		
		node(int x, int y, int length, int work){
			this.x=x; this.y=y;
			this.length=length;
			this.work=work;
		}
	}
	
	public static void bfs(int r, int c) {
		Queue<node> q=new LinkedList<>();
		q.offer(new node(r, c, 1, 0));
		accum[r][c]=0;
		
		while(!q.isEmpty()) {
			node nd=q.poll();
			
			if(nd.x==N && nd.y==M) {//도착 
				ans=nd.length;
				break;
			}
			
			for(int a=0;a<4;a++) {
				int nr=nd.x+row[a];
				int nc=nd.y+col[a];
				
				if(nr>0&&nr<=N&&nc>0&&nc<=M) {
					if(accum[nr][nc] > nd.work) {////현재 노드까지의 공사 횟수(0 || 1)<가볼 곳의 누적 공사 횟수(0 || 1 || max) 
						if(map[nr][nc]==0) {//벽이 없으면 
							accum[nr][nc]=nd.work;
							q.offer(new node(nr, nc, nd.length+1, nd.work));
						}else {//벽이 있음 
							if(nd.work==0) {//벽 공사를 한 적 없으면 
								accum[nr][nc]=nd.work+1;//갈 곳의 누적 공사 횟수를 늘려줌 
								q.offer(new node(nr, nc, nd.length+1, nd.work+1));
							}
						}
					}	
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str[]=br.readLine().split(" ");
		N=Integer.parseInt(str[0]);
		M=Integer.parseInt(str[1]);
		map=new int[N+1][M+1];
		accum=new int[N+1][M+1];
		
		for(int i=1;i<=N;i++) {
			str=br.readLine().split("");
			for(int j=1;j<=M;j++) {
				map[i][j]=Integer.parseInt(str[j-1]);
				accum[i][j]=Integer.MAX_VALUE;
			}
		}
		ans=Integer.MAX_VALUE;
		bfs(1,1);
		
		if(ans==Integer.MAX_VALUE)	System.out.println(-1);
		else	System.out.println(ans);
		
	}

}