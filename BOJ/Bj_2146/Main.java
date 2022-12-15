package Bj_2146;

import java.util.*;

public class Main {
	static int[] abilities;
	static int k;
	
	//0~cur번째 원소까지 최대값 리턴 
	public static int func(int cur, int kk) {
		if(cur<0)	return 0;
		if(cur == 0) {
			if(kk>0)	return abilities[0];
			return 0;
		}
		int result = 0;
		if(kk > 0) {
			//cur에 우선권 사용 VS 사용 x (==cur-1 추가됨)
			result = Math.max(abilities[cur] + func(cur-2, kk-1), abilities[cur-1] + func(cur-2, kk));
		}else {
			result = abilities[cur-1] + func(cur-2, kk);
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] temp = {2, 8, 3, 6, 1, 9, 1, 9};
		int[] temp = {7, 6, 8, 9, 10};
		abilities = temp;
		//k = 2;
		k = 1;
		Arrays.sort(abilities);
		int last = abilities.length - 1;
		int res = func(last, k);
		System.out.println(res);
	}

}
