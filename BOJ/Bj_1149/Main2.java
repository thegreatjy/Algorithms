package Bj_1149;

import java.util.*;
import java.io.*;

public class Main2 {
	static int N;
	static int[][] map;
	
	
	public static void main(String[ ]args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][3];
		String[] line = new String[3];
		for(int i=0;i<N;i++) {
			line = br.readLine().split(" ");
			for(int j=0;j<3;j++) {
				map[i][j] = Integer.parseInt(line[j]);
			}
		}
		
		int[][] dp = new int[N][3];
		int temp = 0;
		for(int i=0;i<N;i++	) {
			for(int j=0;j<3;j++) {
				if(i==0) {
					temp = 0;
				}else {
					temp = Math.min(dp[i-1][(j+1)%3], dp[i-1][(j+2)%3]);
				}
				dp[i][j] = temp + map[i][j];
			}
		}
		int result = Math.min(dp[N-1][0], dp[N-1][1]);
		result = Math.min(result, dp[N-1][2]);
		System.out.println(result);
	}
}
