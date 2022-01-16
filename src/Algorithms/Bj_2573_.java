package Algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj_2573_ {
	static int N, M;
	static int[][] ice;
	static boolean[][] visited;
	static int[][] decrease;
	//사방위 
	static int[] row= {-1, 0, 1, 0};
	static int[] col= {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		ice=new int[N][M];//얼음 높이 
		decrease=new int[N][M];//decrease[i][j]==(i,j)주변 0의 개수 
		visited=new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				ice[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		int mass=0;//덩어리 개수 
		int year=0;
		while(true) {
			//1년의 decrease 구해줌 
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(ice[i][j]!=0 && !visited[i][j]) {
						func(i, j);
						mass++;
					}
				}
			}
			
			if(mass>=2) {
				//year++;
				break;
			}
			if(mass==0) {
				year=0;
				break;
			}
			
			//얼음 높이 갱신 
			//방문, 주변 0의 개수(decrease) 초기화
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					ice[i][j]=ice[i][j]-decrease[i][j];
					if(ice[i][j]<0)	ice[i][j]=0;
					visited[i][j]=false;
					decrease[i][j]=0;
				}
			}	
			year++; 
			mass=0;
		}
		System.out.println(year);
	}
	
	//한 덩어리 
	public static void func(int r, int c) {
		int nr, nc, qr, qc;
		Queue<node> q=new LinkedList<>();
		q.offer(new node(r, c));
		visited[r][c]=true;
		node nd;
		while(!q.isEmpty()) {
			nd=q.poll();
			qr=nd.x; 
			qc=nd.y;
			//visited[qr][qc]=true;
			int zeroCnt=0;
			for(int a=0;a<4;a++) {
				nr=qr+row[a];
				nc=qc+col[a];
				if(nr>=0&&nr<N&&nc>=0&&nc<M) {
					if(ice[nr][nc]==0) {
						decrease[qr][qc]++;
					}
					if(ice[nr][nc]!=0 && !visited[nr][nc]) {
						q.offer(new node(nr, nc));
						visited[nr][nc]=true;
					}
				}
			}
		}
	}

}

/*class node {
int x;
int y;

node(int x, int y){
	this.x=x;
	this.y=y;
}
}*/