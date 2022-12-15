package Bj_2805;

import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] tree;
	
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		tree = new int[N];
		int minH = 0, maxH = 0;
		for(int i=0;i<N;i++	) {
			tree[i] = Integer.parseInt(st.nextToken());
			if(tree[i] > maxH)	maxH = tree[i];
		}
		
		int tempH = 0;
		long tempResult = 0;	//주의 
		//binary search_upper bound
		while(minH < maxH) {
			tempH = (minH + maxH)/2;
			tempResult = 0;
			for(int i=0;i<N;i++) {
				int temp = (tree[i] - tempH);
				tempResult += (temp > 0)? temp : 0;
			}
			
			if(tempResult<M) {//H를 줄여야 함 
				maxH = tempH;
			}else {//H를 늘려본다
				//if(minH == tempH)	break;
				minH = tempH + 1;
			}
		}
		
		System.out.println(minH - 1);
	}

}
