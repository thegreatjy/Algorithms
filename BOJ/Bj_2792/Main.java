package Bj_2792;

import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[] nums;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		
		N = Integer.parseInt(str[0]);//	아이들 수 
		M = Integer.parseInt(str[1]);// 보석 색상 종류 수 
		nums = new int[M];
		int minNV = 1, maxNV = 0;
		for(int i=0; i<M; i++) {
			nums[i] = Integer.parseInt(br.readLine());
			if(nums[i] > maxNV)	maxNV = nums[i];
		}
		
		int result = 0;
		int exp = 0, expNums = 0;//예상 질투심 값, 그에 의하여 보석 배분을 받는 사람 수
		while(minNV <= maxNV) {
			expNums = 0;
			exp = (minNV + maxNV)/2;
			//보석 분배 
			for(int i=0;i<M;i++) {
				//expNums += ((nums[i]/exp) + 1);
				expNums += nums[i] / exp;
				if (nums[i] % exp != 0) {
					expNums++;
				}
			}
			
			if(expNums > N) {//너무 잘게 배분됨 > 예상 질투심이 높아야 됨 
				minNV = exp + 1;
			}else {//만족 || 너무 크게 배분됨 > 질투심을 줄여야 함 
				maxNV = exp - 1;
				result = exp;
			}
		}
		
		System.out.println(result);
	}

}
