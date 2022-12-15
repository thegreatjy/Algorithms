package Bj_2003;

import java.io.*;

public class Main {
	static int N, M;
	static int[] A;
	
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		N = Integer.parseInt(temp[0]); M = Integer.parseInt(temp[1]);
		temp = br.readLine().split(" ");
		A = new int[N];
		for(int i=0;i<N;i++) {
			A[i] = Integer.parseInt(temp[i]);
		}
		
		int start=0, fin=0, sum=A[start];
		int result = 0;
		
		while(true) {
			if(sum>M) {
				sum-=A[start];
				++start;
			}else if(sum<M) {
				++fin;
				if(fin>=N) {
					break;
				}
				sum+=A[fin];
			}else {
				//sum==M
				++result;
				sum-=A[start];
				++start;
			}
			
			//후처리 
			if(start>fin) {
				++fin;
				if(fin>=N) {
					break;
				}
				sum=A[fin];
			}
			
		}
		
		System.out.println(result);
	}

}
