package Bj_11403;

import java.io.*;

public class Main {
	static int N;
	static int[][] map;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		String[] line = new String[N];
		for(int i=0;i<N;i++) {
			line = br.readLine().split(" ");
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(line[j]);
			}
		}
		
		//m 중간 정점  
		for(int m=0;m<N;m++) {
			//i 시작 정점 
			for(int i=0;i<N;i++) {
				//j 도착 정점 
				for(int j=0;j<N;j++) {
					if(map[i][j] == 1)	continue;
					if(map[i][m]==1 && map[m][j]==1) {
						map[i][j] = 1;
					}
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}

}