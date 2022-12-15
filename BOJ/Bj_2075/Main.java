package Bj_2075;

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());
		Queue<Integer> q = new PriorityQueue<>();
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(q.size() == n) {
					if(q.peek() < num) {
						q.poll();
						q.add(num);
					}
				}else {
					q.add(num);
				}
			}
		}
		System.out.println(q.poll());
	}
}
