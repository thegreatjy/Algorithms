package prg_42747;

import java.util.*;

public class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        /*
        Arrays.sort(citations);
        int max=citations[citations.length-1], min=citations[0];
        
        int h = (max-min)/2;
        int num = -1;//h보다 높은 인용횟수를 가진 논문의 개수 
        while(true) {
        	h = (max-min)/2;
        	//num 구하기 
        	for(int i=0;i<citations.length;i++) {
        		if(citations[i] > h) {
        			num = citations.length - i;
        			break;
        		}
        	}
        	
        	if(num > h) {
        		
        	}else {
        		
        	}
        }
        */
        
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] citations = {};
		int result = new Solution().solution(citations);
		System.out.println(result);
	}

}
