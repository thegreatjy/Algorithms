package Bj_1167;

import java.io.*;
import java.util.*;

public class Main2 {
	static int V;
	
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		/*
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(br.readLine());
		ArrayList<ArrayList<edge>> vList = new ArrayList<>();
		for(int i=0;i<V;i++) {
			vList.add(new ArrayList<edge>());
		}
		int s, v, c;
		for(int i=0; i<V; i++) {
			s = Integer.parseInt(st.nextToken());
			
			while(true) {
				v = Integer.parseInt(st.nextToken());
				if(v == -1)	break;
				c = Integer.parseInt(st.nextToken());
				
				vList.get(s).add(new edge(v, c));
			}
		}
		*/
	}
	
	class edge{
		int cost;
		int destV;
		
		edge(int destV, int cost){
			this.cost=cost;
			this.destV=destV;
		}
	}
}
