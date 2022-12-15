package Bj_11055;

import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] A;
	
	
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String[] num = br.readLine().split(" ");
		A = new int[N];
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(num[i]);
		}
		int[] dp = new int[N];
		dp[N-1] = A[N-1];
		int first = A[N-1];
		
		for(int i=N-2; i>=0; i--) {
			if(A[i]<first) {
				dp[i] = dp[i+1] + A[i];
				first = A[i];
			}else {
				if(A[i]>dp[i+1]) {
					dp[i] = A[i];
					first = A[i];
				}else {
					dp[i] = dp[i+1];
				}
			}
		}
		System.out.println(dp[0]);
	}

}
