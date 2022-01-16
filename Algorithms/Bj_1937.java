package Algorithms;

import java.io.*;
import java.util.*;

public class Bj_1937 {
	static int n;
	
	static int arr[][];
	static int max[][];
	//사방위
	static int row[]= {-1, 0, 1, 0};
	static int col[]= {0, 1, 0, -1};

	//arr[r][c]로부터 얻을 수 있는 가장 긴 경로 길이를 리턴함 
	public static int search(int[][] arr, int r, int c) {
		//방문한 적이 있으면 계산하지 않는다 
		if(max[r][c]!=0)	return max[r][c];
		
		int result=1;
		
		for(int i=0;i<4;i++) {
			int nr=r+row[i];
			int nc=c+col[i];
			
			//이동하려는 칸이(nr, nc) NxN범위안에 있으며
			//						현재칸보다 크면
			if(nr>=0 && nr<n && nc>=0 && nc<n && arr[r][c]<arr[nr][nc]) {
				result=Math.max(search(arr, nr, nc)+1, result);
				max[r][c]=result;
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken());
		arr=new int[n][n];
		max=new int[n][n];
		
		for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
		
		int result=0;
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				result=Math.max(search(arr, i, j), result);
			}
		}
		
		System.out.println(result);
		
	}

}
