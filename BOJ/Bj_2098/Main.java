package Bj_2098;

import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] map;
	static int[][] dp;
	static final int INF = Integer.MAX_VALUE;
	
	public static int dfs(int cur, int visitBit) {
		if(visitBit == (1<<N)-1) {
			return map[cur][0];
		}
		
		if(dp[cur][visitBit] != INF) {
			return dp[cur][visitBit];
		}
		
		for(int i=0;i<N;i++) {
			//i 도시에 방문한 적 없음 && cur -> i에 길 있음
			if((visitBit & (1<<i))<=0 && map[cur][i] != 0) {
				dp[cur][visitBit] = Math.min(dp[cur][visitBit], dfs(i, visitBit|(1<<i))+ map[cur][i]);
			}
		}
		
		return dp[cur][visitBit];
	}
	
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dp = new int[N][(1<<N)];
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++	) {
				map[i][j] = Integer.valueOf(st.nextToken());
			}
			Arrays.fill(dp[i], INF);
		}
				
		int result = dfs(0, 1);
		System.out.println(result);
	}

}
