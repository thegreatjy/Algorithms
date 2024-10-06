package prg_76502;
// 6;19 - 7:08 => 48분 참고
import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = -1;
        int[] gh = new int[3];
        int cnt = 0;
        Stack<String> stack;
        for(int i=0; i<s.length(); i++){
            // i번 회전
            stack = new Stack<>();

            // i인덱스 ~ (i+length-1)%length
            for(int j=0; j<s.length(); j++){
                int finish = (i+j)%s.length();
                char c = s.charAt(finish);
                String input = String.valueOf(c);

                // 스택이 비어있으면 넣음
                if(stack.size()<=0){
                    stack.push(input);
                    continue;
                }

                // ), }, ] 들어옴
                String peek = stack.peek();
                // 조건에 맞으면 삭제
                if(input.equals(")") && peek.equals("(")){
                    stack.pop();
                    continue;
                } else if(input.equals("}") && peek.equals("{")){
                    stack.pop();
                    continue;
                }else if(input.equals("]") && peek.equals("[")){
                    stack.pop();
                    continue;
                }

                // 그냥 넣음
                stack.push(input);
            }

            // i번 회전이 올바름
            if(stack.size() == 0)    ++cnt;
        }

        return cnt;
    }
}