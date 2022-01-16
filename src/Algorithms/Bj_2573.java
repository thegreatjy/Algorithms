package Algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj_2573 {
	static int N, M;
	static int[][] ice;
	static boolean[][] visited;
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
		int[][] decrease=new int[N][M];//decrease[i][j]==(i,j)주변 0의 개수 
		visited=new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				ice[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		int year=1;
		int mass=0;
		int ni,nj;
		while(true) {
			//주변 0개수 구하기 
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					//상하좌우 0 개수 세기 
					int zero=0;
					for(int a=0;a<4;a++) {
						ni=i+row[a];
						nj=j+col[a];
						if(ni>=0&&ni<N&&nj>=0&&nj<M) {
							if(ice[ni][nj]==0)	zero++;
						}
					}
					decrease[i][j]+=zero;
				}
			}
			//빙산 높이 줄이기 
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++){
					ice[i][j]=ice[i][j]-decrease[i][j];
					if(ice[i][j]<0)	ice[i][j]=0;
				}
			}
			//덩어리 세기 
			mass=func(0,0);
			
			//덩어리가 분리됨  
			if(mass>1) {
				year++;
				break;
			}
			if(mass==0) {//전부 녹음 
				year=0;
				break;
			}
			year++;
		}
		System.out.println(year);
	}
	
	public static int func(int r, int c) {
		if(ice[r][c]!=0)	visited[r][c]=true;
		for(int a=0;a<4;a++) {
			int nr=r+row[a];
			int nc=c+col[a];
			if(nr>=0&&nr<N&&nc>=0&&nc<M) {
				if(ice[nr][nc]!=0) {
					
				}
			}
		}
		return 0;
	}

}
