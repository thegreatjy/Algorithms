package Algorithms;

import java.io.*;
import java.util.*;

public class Bj_7569 {
	static int N,M,H;
	//static boolean[][][] visited;
	static int [][][] map;
	static boolean[][][] near;//상하좌우앞뒤에 익은 토마토가 있는 지 없는 지 
	
	//상하좌우앞뒤
	static int[] row= {0, 0, -1, 0, 1, 0};
	static int[] col= {0, 0, 0, 1, 0, -1};
	static int[] dim= {1, -1, 0, 0, 0, 0};

	
	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		M=Integer.parseInt(st.nextToken()); 
		N=Integer.parseInt(st.nextToken());
		H=Integer.parseInt(st.nextToken());
		
		//visited=new boolean[N][M][H];
		map=new int[N][M][H];
		near=new boolean[N][M][H];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<H;j++) {
				st=new StringTokenizer(bf.readLine());
				for(int k=0;k<M;k++) {
					map[i][k][j]=Integer.parseInt(st.nextToken());
				}
			}
		}
		
		//Queue<Point3D> q=new LinkedList<>();
		int days=0;
		boolean flagNRT=false;	//Non-Ripen Tomato 가 있음. 안익은 토마토 flag
		boolean flagC=false;	//익힐 토마토가 있는지 알리는 flag 
		while(true) {
			//주변에 익은 토마토가 있는지 없는지 확인 
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					for(int k=0;k<H;k++) {
						//안익은 토마토가 있으면 
						if(map[i][j][k]==0) {
							flagNRT=true;
							int x,y,z;
							//상하좌우위아래 
							for(int a=0;a<6;a++) {
								x=i+row[a];
								y=j+col[a];
								z=k+dim[a];
								
								if(x>=0&&x<N&&y>=0&&y<M&&z>=0&&z<H) {
									if(map[x][y][z]==1) {
										flagC=true;
										near[i][j][k]=true;
										break;
									}
								}
							
							}
						}
						
					}
							
						}
							
			}
			if(!flagNRT) {//토마토가 모두 익음 
				break;
			}
			
			//익힐 토마토가 있으면 토마토를 익힘. 날짜도 바꿔줌 
			if(flagC) {
				for(int i=0;i<N;i++) {
					for(int j=0;j<M;j++) {
						for(int k=0;k<H;k++) {
							if(near[i][j][k]) {
								map[i][j][k]=1;
								near[i][j][k]=false;	//초기화
							} 
						}
					}
				}
				days++;
			}
			
			if(!flagC && flagNRT) {//익힐 토마토가 없음 && 안 익은 토마토가 있음
				days=-1;
				break;
			}
			flagNRT=false;
			flagC=false;
		}
		
		System.out.println(days);
		
		/*
		for(int k=0;k<H;k++) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					System.out.print(map[i][j][k]+" ");
				}
				System.out.println();
			}
			System.out.println("==");
		}
		*/
		
	}
}

class Point3D{
	int x;
	int y;
	int z;
	Point3D(int x, int y, int z)	{
		this.x=x;
		this.y=y;
		this.z=z;
	}
}