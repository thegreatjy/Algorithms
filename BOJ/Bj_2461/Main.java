package Bj_2461;

import java.util.*;
import java.io.*;

public class Main {
	/*
	static int N, M;
	static int[][] map;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		N = 4;
		M = 3;
		
		for(int i=0;i<N;i++) {
			Arrays.sort(map[i]);
		}
		
		int max, min, res_temp , res=0;
		
		//i : 0반의 i번째 학생 
		for(int i=0;i<M;i++) {
			min = map[0][i];
			max = map[0][i];
			res_temp = Integer.MAX_VALUE;
			
			//j : 1~N-1반 
			for(int j=1;j<N;j++) {
				int temp;
				//k : j반의 k번째 학생 
				for(int k=0;k<M;k++) {
					temp = (int) Math.sqrt(map[0][i] - map[j][k]);
					if(temp<res_temp) {
						res_temp = temp;
						if(map[j][k]<=min) {
							min = map[j][k];
						}else if(map[j][k]>max) {
							max = map[j][k];
						}
						res=Math.min(res, res_temp);
					}
				}
			}
		}
		
		//i학급의 
		for(int i=0;i<N-1;i++) {
			for(int j=0;j<M-1;j++) {
				if(max-map[i][j] < res_temp) {
					max = map[i][j];
				}else if(min-map[i][j] < res_temp) {
					min = map[i][j];
				}
			}
		}
	}
	*/
}
	
	/*
	 * //i : 0반의 i번째 학생 
		for(int i=0;i<M;i++) {
			min = map[0][i];
			max = map[0][i];
			res_temp = Integer.MAX_VALUE;
			
			//j : 1~N-1반 
			for(int j=1;j<N;j++	) {
				int temp;
				//k : j반의 k번째 학생 
				for(int k=0;k<M;k++) {
					temp = (int) Math.sqrt(map[0][i] - map[j][k]);
					if(temp<res_temp) {
						res_temp = temp;
						if(map[j][k]<=min) {
							min = map[j][k];
						}else if(map[j][k]>max) {
							max = map[j][k];
						}
						res=Math.min(res, res_temp);
					}
				}
			}
		}
		*/
