package Bj_1920;

import java.util.Scanner;
import java.util.Arrays;
 
public class Main {
	public static int binarySearch(int[] arr, int input) {
		 
		int fst = 0;	//맨 왼쪽 인덱스 
		int lst = arr.length - 1;	//오른쪽 
 
		//왼쪽 인덱스가 오른쪽 인덱스보다 작을 때까지 수행 
		while(fst <= lst) {
 
			int mid = (fst + lst) / 2;	//중간 
 
			if(input < arr[mid]) {
				lst = mid - 1;
			}

			else if(input > arr[mid]) {
				fst = mid + 1;
			}

			else {
				return mid;
			}
		}
 
		//존재하지 않는 경우 -1 리턴 
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = scan.nextInt();
		}

		Arrays.sort(arr);
		
		int M = scan.nextInt();

		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			if(binarySearch(arr, scan.nextInt()) >= 0) {
				sb.append(1).append('\n');
			}
			else {
				sb.append(0).append('\n');
			}
		}
		System.out.println(sb);
	}
}