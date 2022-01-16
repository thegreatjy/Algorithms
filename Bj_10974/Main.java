package Bj_10974;

import java.util.*;

public class Main {
	static boolean[] visited;
	static int[] arr;
	static int N;
	
	public static void fun(int level) {
		if(level>N) {
			for(int i=1;i<=N;i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=1;i<=N;i++) {
			if(!visited[i]) {
				arr[level]=i;
				visited[i]=true;
				fun(level+1);
				visited[i]=false;
			}
		}
		
	}
	
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		N=scan.nextInt();
		
		visited=new boolean[N+1];
		arr=new int[N+1];
		
		fun(1);
	}
}
