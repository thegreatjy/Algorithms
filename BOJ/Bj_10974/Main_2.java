package Bj_10974;

import java.io.*;
import java.util.*;

public class Main_2 {
	static int N;
	
	//list는 지나왔던 길을 순서대로 저장 
	public static void func(int cur, boolean[] visited, ArrayList<Integer> list) {
		if(list.size()>=N)	{//지나온 길의 길이가 N 이상이면(순열이라 N이상 불가능) 
			for(int i:list) {
				System.out.print(i+" ");
			}
			System.out.println();
			return;
		}
		for(int i=1;i<=N;i++) {
			if(!visited[i]) {
				visited[i]=true;
				list.add(i);
				func(i+1, visited, list);
				visited[i]=false;
				list.remove(list.size()-1);	//리스트 마지막 요소 삭제 
			}
		}
	}
	
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		boolean[] visited=new boolean[N+1];
		ArrayList<Integer> st=new ArrayList<>();
		func(1, visited, st);
	}
}
