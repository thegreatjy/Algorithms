package Bj_2512;

import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] budgets;
	
	public static void func() {
		
	}
	
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String[] str = br.readLine().split(" ");
		for(int i=0;i<N;i++) {
			budgets[i] = Integer.parseInt(str[i]);
		}
		M = Integer.parseInt(br.readLine());
		Arrays.sort(budgets);
		
		int max = budgets[budgets.length-1], min = budgets[0];
		int mid = (min+max)/2;
		int result = 0;
		while(min<=max) {
			mid = (min+max)/2;
			
			int sum = 0;
			for(int i : budgets) {
				if(i>mid) {
					sum+=mid;
				}else {
					sum+=i;
				}
			}
			
			if(sum>M) {
				max = budgets[mid - 1];
			}else {
				min = budgets[mid + 1];
				
			}
		}
		
		
	}

}
