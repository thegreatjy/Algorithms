package Bj_1253;

import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] A;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int temp = 0;
		while(st.hasMoreTokens()) {
			A[temp++] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);
		
		int result=0;
		//A[i]+A[j]==A[k]를 만족하는 A[k]의 개수==result
		for(int k=0;k<N;k++) {
			LoopI:for(int i=0;i<N;i++) {
				LoopJ:for(int j=i+1;j<N;j++) {
					if(i==j || i==k || j==k) {
						continue;
					}
					if(A[i]+A[j]==A[k]) {
						++result;
						//System.out.println(A[i]+"+"+A[j]+"="+A[k]);
						break LoopI;
					}
					if(A[i]+A[j]>A[k]) {
						break LoopJ;
					}
				}
			}
		}
		
		System.out.println(result);
	}

}
