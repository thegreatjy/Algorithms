package Bj_2252;

import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		N = Integer.parseInt(line[0]);
		M = Integer.parseInt(line[1]);
		
		int[] inD = new int[N+1];
		ArrayList<Integer>[] outD = new ArrayList[N+1];
		
		for(int i = 1; i<=N; i++) {
			outD[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i<M ; i++) {
			line = br.readLine().split(" ");
			int a = Integer.parseInt(line[0]);
			int b = Integer.parseInt(line[1]);
			
			inD[b] +=1;
			outD[a].add(b);
		}
		
		
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i = 1; i<=N; i++) {
			if(inD[i]==0) q.add(i);
		}
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			q.add(cur);
			
			for(int i = 0; i<outD[cur].size(); i++) {
				int next = outD[cur].get(i);
				inD[next] -= 1;
				if(inD[next] == 0) q.add(next);
			}
		}
		
		for(int i = 0; i<result.size(); i++) {
			System.out.print(result.get(i) + " ");
		}
	}

}
