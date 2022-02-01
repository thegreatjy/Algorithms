package Bj_10971;

import java.util.*;
import java.io.*;

public class Main {
	static int N, result;
	static int[][] W;
	static ArrayList<Integer> list;

	//현재 위치, 방문 도시 리스트, 누적 비용 
	public static void tsp(int cur, ArrayList<Integer> list, int cost) {
		//모든 도시를 다 방문 
		if(list.size()==N) {
			int first=list.get(0);
			int last=list.get(list.size()-1);
			if(W[last][first]!=0) {
				cost=cost+W[last][first];
				if(cost<result) {
					result=cost;
				}
			}
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(W[cur][i]!=0 && !list.contains(i)) {
				list.add(i);
				tsp(i, list, cost+W[cur][i]);
				list.remove(list.size()-1);
			}
		}
	}
	
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		W=new int[N][N];
		list=new ArrayList<Integer>();
		
		for(int i=0;i<N;i++) {
			String line[]=br.readLine().split(" ");
			for(int j=0;j<N;j++) {
				W[i][j]=Integer.parseInt(line[j]);
			}
		}
		result=Integer.MAX_VALUE;
		//시작점이 0
		//모든 점을 다 방문하는 순회이므로 모든 점을 시작점으로 tsp를 계산해주지 않아도 된다.
		list.add(0);
		tsp(0, list, 0);
			
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(Integer.toString(result));
		bw.flush(); bw.close();		
	}

}
