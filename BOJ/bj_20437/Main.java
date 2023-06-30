package bj_20437;

import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			String W = br.readLine();
			int K = Integer.parseInt(br.readLine());
			int min = 10001, max = 0;
			ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
			for(int a=0;a<26;a++) {
				list.add(new ArrayList<>());
			}
			
			//W 탐색 
			for(int j=0;j<W.length();j++) {
				int unicode = W.charAt(j) - 97;
				list.get(unicode).add(j);
				
				//어떤 알파벳(W[j])가 K번 나왔을 때 연속 문자열 길이를 구한다  
				int size = list.get(unicode).size();
				if(size >= K) {
					int start = list.get(unicode).get(size - K);
					int end = list.get(unicode).get(size-1);
					int len = end - start + 1;
					if(len<min) {
						//System.out.println("min: "+end+" "+start);
						min = len;
					}
					if(len>max) {
						//System.out.println("max: "+end+" "+start);
						max = len;
					}
				}
			}
			if(min==10001) {
				sb.append("-1\n");
				continue;
			}
			sb.append(min+" "+max+"\n");
		}
		System.out.println(sb.toString());
	}
}
