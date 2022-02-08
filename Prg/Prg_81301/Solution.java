package Prg_81301;

public class Solution {
	public int solution(String s) {
		String[] words = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for (int i = 0; i < words.length; i++) {
            s = s.replaceAll(words[i], String.valueOf(i));
        }
        return Integer.parseInt(s);
    }

	public static void main(String[] args) {
    	String s="one4seveneight";	
    	int result=new Solution().solution(s);
    	System.out.println(result);
    }
}
