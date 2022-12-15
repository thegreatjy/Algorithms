package Bj_13305;

import java.io.*;

public class Main2 {
	static int N;
	static int[] cost;
	static int[] dist;
	
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String[] temp = br.readLine().split(" ");
		dist = new int[N-1];
		for(int i=0;i<N-1;i++) {
			dist[i] = Integer.parseInt(temp[i]);
		}
		temp = br.readLine().split(" ");
		cost = new int[N];
		int min = 0;	//가장 작은 오일 가격을 갖는 도시의 인덱스 
		for(int i=0;i<N;i++) {
			cost[i] = Integer.parseInt(temp[i]);
			if(cost[i] <= cost[min]) {
				min = i;
			}
		}
		
		int result = 0;
		int dest = N-1;
		
		while(true) {
			//System.out.println(dest+", "+result);
			if(dest <= 0) {
				break;
			}
			//현재도시>도착지 거리 
			int dSum = 0;	
			for(int i=min; i<dest; i++) {
				dSum+=dist[i];
			}
			result = result + cost[min]*dSum;
			
			dest = min;
			min = 0;
			for(int i=0;i<dest;i++) {
				if(cost[i] <= cost[min]) {
					min = i;
				}
			}
		}
		
		System.out.println(result);
	}

}
