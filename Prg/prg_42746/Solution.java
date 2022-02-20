package prg_42746;

import java.util.*;

public class Solution {
	public String solution(int[] numbers) {
        String answer = "";
        String[] str = new String[numbers.length];
        for(int i=0; i<numbers.length; i++) {
        	str[i] = Integer.toString(numbers[i]);
        }
        /*
        Arrays.sort(str, new Comparator<String>() {
        	public int compare(String str1, String str2) {
        		return (str2+str1).compareTo(str1+str2);
        	}
        });
        */
        Arrays.sort(str, (a,b)->((b+a).compareTo(a+b)));
        
        if(str[0].equals("0")) {
        	return "0";
        }
        
        for(String s:str) {
        	answer+=s;
        }
        return answer;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = {3, 30, 34, 5, 9};
		String result = new Solution().solution(numbers);
		System.out.println(result);
	}

}
