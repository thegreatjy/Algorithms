package Bj_1937;

import java.io.*;

public class Main {
	static int n;
	static int[][] map;
	static int[][] ch;
	static int[] row = {0,0,1,-1};
	static int[] col = {1,-1,0,0};
	
	//ch[r][c]를 리턴. (r, c)에서 출발해서 이동할 수 있는 최대 칸 수 
	public static int func(int r, int c) {
		if(ch[r][c]!=0) {
			return ch[r][c];
		}
		
		for(int i=0; i<4; i++) {
			int nr = r + row[i];
			int nc = c + col[i];
			if(nr<0 || nr>=n || nc<0 || nc>=n) {
				continue;
			}
			if(map[r][c] >= map[nr][nc]) {
				continue;
			}
			
			int temp = func(nr, nc) + 1;
			if(ch[r][c] == 0) {
				ch[r][c] = temp;
			}else {
				ch[r][c] = Math.max(ch[r][c], temp);
			}
		}
		
		return ch[r][c];
	}
	
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		String[] temp = new String[n];
		map = new int[n][n];
		for(int i=0;i<n;i++	) {
			temp = br.readLine().split(" ");
			for(int j=0;j<n;j++) {
				map[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
		ch = new int[n][n];
		int result = Integer.MIN_VALUE;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				result = Math.max(result, func(i,j));
				//System.out.print(ch[i][j]+" ");
			}
			//System.out.println();
		}
		
		System.out.println(result+1);
	}

}
