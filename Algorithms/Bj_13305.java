package Algorithms;

import java.util.Scanner;

public class Bj_13305 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		
		long[] length = new long[N - 1];	// 도로 길이 
		long[] price = new long[N];			// 가격 
		
		// 길이  입력 
		for(int i = 0; i < N - 1; i++) {
			length[i] = in.nextLong();
		}
		
		// 리터당 기름값 입력
		for(int i = 0; i < N; i++) {
			price[i] = in.nextLong();
		}
		
		long result = 0;
		long min = price[0];	// 최소 기름값  
 
		for(int i = 0; i < N - 1; i++) {
			if(price[i] < min) {
				min = price[i];
			}
			result += (min * length[i]);
		}
		System.out.println(result);
	}
}
