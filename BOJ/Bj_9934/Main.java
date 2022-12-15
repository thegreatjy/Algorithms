package Bj_9934;

import java.io.*;
import java.util.*;

public class Main {
	static int k;
	static StringBuilder[] sb;
	static int[] numbers;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		k = Integer.parseInt(st.nextToken()); 
		sb = new StringBuilder[k];
		for(int i=0;i<k;i++) {
			sb[i] = new StringBuilder();
		}
		st = new StringTokenizer(br.readLine());
		int n = (int)(Math.pow(2.0, k) - 1);
		numbers = new int[n];
		for(int i=0;i<n;i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		func(0, n - 1, 0);
		
		for (int i = 0; i < k; i++)
			bw.write(sb[i].toString() + "\n");
		bw.flush();
	}
	
	//numbers[start] - numbers[finish] 에서 중간값(root node)을 찾아서 리턴 
	static void func(int start, int finish, int level) {
		if(start == finish) {
			sb[level].append(numbers[start]+" ");
			return;
		}
		
		int mid = (start + finish) / 2;
		sb[level].append(numbers[mid]+" ");
		
		func(start, mid - 1, level + 1);
		func(mid + 1, finish, level + 1);
	}

}
