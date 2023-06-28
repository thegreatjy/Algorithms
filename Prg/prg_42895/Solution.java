package prg_42895;

import java.util.*;

public class Solution {
	public int solution(int N, int number) {
		int solution = -1;
		
		ArrayList<HashSet<Integer>> list = new ArrayList<>();
		for(int i=0;i<9;i++) {
			list.add(new HashSet<Integer>());
		}
		
		list.get(1).add(N);
		if(number==N)	return 1;
		int temp = 0;
		
		for(int i=2;i<9;i++) {
			//N을 i번 썼을 때 만들 수 있는 숫자 집합
			HashSet<Integer> set = list.get(i);
			
			//N으로 구성된 i자리의 수 
			temp = Integer.parseInt(String.valueOf(N).repeat(i));
			set.add(temp);
			
			//사칙연산
			for(int j=1;j<i;j++) {
				HashSet<Integer> preSet = list.get(j);
				HashSet<Integer> postSet = list.get(i-j);
				
				for(int pre: preSet) {
					for(int post: postSet) {
						set.add(pre+post);
						set.add(pre-post);
						set.add(pre*post);
						if(pre!=0 && post!=0) {
							set.add(pre/post);
						}
					}
				}
			}
			
			//number를 만들었으면 N 사용 횟수(i) 리턴 
			if(set.contains(number))	return i;
		}
		
		return solution;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 5;
		int number = 12;
		int result = new Solution().solution(N, number);
		System.out.println(result);
	}

}
