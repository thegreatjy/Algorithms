package prg_12973;

// 5;26 - 33
import java.util.*;

public class Solution
{
    public int solution(String s)
    {
        int answer = 0;

        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            Character cur = s.charAt(i);

            if(stack.size() == 0){
                stack.push(cur);
                continue;
            }

            Character last = stack.peek();
            if(last == cur){
                stack.pop();
            }else{
                stack.push(cur);
            }
        }

        if(stack.size() == 0){
            answer = 1;
        }

        return answer;
    }
}