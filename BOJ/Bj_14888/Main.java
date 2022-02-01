package Bj_14888;

import java.util.*;
import java.io.*;

public class Main {
	static int N, min, max;
	static int[] A, op;
	
	public static void func(int cur, int result) {
		if(cur==N-1) {
			if(result>max)	max=result;
			if(result<min)	min=result;
		}
		int temp;
		for(int i=0;i<4;i++) {
			if(op[i]>0) {
				temp=result;
				if(i==0)		temp=temp+A[cur+1];
				else if(i==1)	temp=temp-A[cur+1];
				else if(i==2)	temp=temp*A[cur+1];
				else if(i==3)	temp=temp/A[cur+1];
				op[i]--;
				func(cur+1, temp);
				op[i]++;
			}
		}
	}
	
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		A=new int[N];
		String nums[]=br.readLine().split(" ");
		for(int i=0;i<N;i++) {
			A[i]=Integer.parseInt(nums[i]);
		}
		op=new int[4];
		nums=br.readLine().split(" ");
		for(int i=0;i<4;i++) {
			op[i]=Integer.parseInt(nums[i]);
		}
		
		min=Integer.MAX_VALUE;
		max=Integer.MIN_VALUE;
		
		func(0, A[0]);
		
		System.out.println(max+"\n"+min);
	}
}