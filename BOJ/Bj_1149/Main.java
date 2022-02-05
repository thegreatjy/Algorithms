package Bj_1149;

import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[][] house;
	
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		int[][] dp=new int[N][3];
		house=new int[N][3];
		String[] str;
		int temp=Integer.MAX_VALUE;
		for(int i=0;i<N;i++) {
			str=br.readLine().split(" ");
			for(int j=0;j<3;j++) {
				house[i][j]=Integer.parseInt(str[j]);
			}
			
			if(i==0) {
				dp[0][0]=house[0][0];
				dp[0][1]=house[0][1];
				dp[0][2]=house[0][2];
			}else {
				for(int j=0;j<3;j++) {
					temp=Math.min(dp[i-1][(j+1)%3], dp[i-1][(j+2)%3]);
					dp[i][j]=temp+house[i][j];
				}
			}
		}
		int result=Math.min(dp[N-1][0], dp[N-1][1]);
		result=Math.min(result, dp[N-1][2]);
		System.out.println(result);
	}
}