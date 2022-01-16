package Algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Bj_10026 {
	//사방위
	static int row[]= {-1, 0, 1, 0};
	static int col[]= {0, 1, 0, -1};
	
	static int n;
	static boolean visited[][];
	static boolean visited_b[][];
	static char arr[][];
	static char arr_b[][];
	
	//arr[r][c] 주변을 탐색 
	public static void search(char[][]arr, boolean[][] visited, int r, int c) {
		visited[r][c]=true;
		
		for(int i=0;i<4;i++) {
			int nr=r+row[i];
			int nc=c+col[i];
			
			//이동하려는 칸이(nr, nc) NxN범위안에 있으며
			//					방문한 적이 없으며
			//					현재 칸의 색깔과 동일하면 
			if(nr>=0 && nr<n && nc>=0 && nc<n && !visited[nr][nc] && arr[r][c]==arr[nr][nc]) {
				search(arr, visited, nr, nc);
			}
		}
	}
	
	
	
	public static void main(String[] args)	throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n=Integer.parseInt(br.readLine());
		
		arr=new char[n][n];
		arr_b=new char[n][n];
		visited=new boolean[n][n];
		visited_b=new boolean[n][n];
		
		//NxN 입력받음
		for(int i=0;i<n;i++) {
			String line = br.readLine();
			for(int j=0;j<n;j++	) {
				arr[i][j]=line.charAt(j);
				arr_b[i][j]=arr[i][j];
				if(arr_b[i][j]=='G')	arr_b[i][j]='R';	//적록색맹용 배열을 만들어준다.
			}
		}
		
		//구역나눔
		int result=0;
		int result_b=0;
		
		for(int r=0;r<n;r++) {
			for(int c=0;c<n;c++) {
				//일반인 
				if(!visited[r][c]) {
					search(arr, visited, r, c);
					result++;
				}
				//적록색맹 
				if(!visited_b[r][c]) {
					search(arr_b, visited_b, r, c);
					result_b++;
				}
			}
		}
		
		System.out.println(result+" "+result_b);
		
	}

}
