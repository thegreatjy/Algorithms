package prg_43238;

import java.util.*;

public class Solution {
	public long solution(int n, int[] times) {
		long answer = Long.MAX_VALUE;
		Arrays.sort(times);
		
		long min = 0, max = (long)times[times.length-1]*n;
		long mid = 0, maxN = 0;
		
		while(min <= max) {
			mid = (min+max)/2;
			maxN = 0;
			for(long t:times) {
				maxN += mid/t;
			}
			
			if(maxN>=n) {//일단 됨. 시간을 줄여 본다.
				answer = Math.min(answer, mid);
				max = mid - 1;
			}else {//안 됨. 시간을 늘려 본다.
				min = mid + 1;
			}
		}
		
		return answer;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 6;
		int[] times = {7, 10};
		
		long result = new Solution().solution(n, times);
		System.out.println(result);
	}

}