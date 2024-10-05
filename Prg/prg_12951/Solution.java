package prg_12951;

class Solution {
    public String solution(String s) {
        String answer = "";
        String newStr = " " + s;
        for(int i=1; i<newStr.length(); i++){
            if(newStr.charAt(i-1) == ' '){
                // 뒤 문자를 대문자
                answer += Character.toUpperCase(newStr.charAt(i));
            }else{
                answer += Character.toLowerCase(newStr.charAt(i));
            }
        }

        return answer;

    }
}