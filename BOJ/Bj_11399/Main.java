package Bj_11399;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[] P=new int[N];
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			P[i]=Integer.parseInt(st.nextToken());
		}
		//P 오름차순으로 정렬
		Arrays.sort(P);
		//누적합 구하기 
		int prevSum=0;
		int sum=0;
		for(int i=0;i<N;i++) {
			prevSum=prevSum+P[i];
			sum=sum+prevSum;
		}
		System.out.println(sum);
	}

}
