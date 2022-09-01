package Bj_1613;

import java.io.*;

public class Main {
	static int n, k, s;
	static int[][] map;
		
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		n = Integer.parseInt(line[0]);
		k = Integer.parseInt(line[1]);
		map = new int[n][n];
		int pre, post;
		for(int i=0;i<k;i++) {
			line = br.readLine().split(" ");
			pre = Integer.parseInt(line[0]) - 1;
			post = Integer.parseInt(line[1]) - 1;					
			map[pre][post] = 1;
			map[post][pre] = -1;
		}
		
		for(int mid=0;mid<n;mid++) {
			for(int i=0;i<n;i++) {
				if(mid == i)	continue;
				for(int j=0;j<n;j++) {
					if(i==j && i==k)			continue;
					if(map[i][j]!=0)	continue;
					
					if(map[i][mid]==1 && map[mid][j]==1) {
						map[i][j] = 1;
						map[j][i] = -1;
					}else if(map[j][mid]==1 && map[mid][i]==1) {
						map[j][i] = 1;
						map[i][j] = -1;
					}
				}
			}
		}
		
		line = br.readLine().split(" ");
		s = Integer.parseInt(line[0]);
		//StringBuilder sb = new StringBuilder();
		int result = 0;
		for(int i=0;i<s;i++) {
			line = br.readLine().split(" ");
			pre = Integer.parseInt(line[0]) - 1;
			post = Integer.parseInt(line[1]) - 1;
			result = map[pre][post] * -1;
			System.out.println(result);
		}
	}
/*
 line = br.readLine().split(" ");
		s = Integer.parseInt(line[0]);
		StringBuilder sb = new StringBuilder();
		int result = 0;
		for(int i=0;i<s;i++) {
			line = br.readLine().split(" ");
			pre = Integer.parseInt(line[0]) - 1;
			post = Integer.parseInt(line[1]) - 1;
			result = map[pre][post] * -1;
			sb.append(result+"\n");
		}
		System.out.println(sb.toString());
 */
}
