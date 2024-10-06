package prg_12909;

// 9;18 - 9;24
import java.util.*;

public class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Queue<String> queue = new LinkedList<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            String curStr = String.valueOf(c);

            if(queue.size() == 0){
                queue.add(curStr);
                continue;
            }

            // ) 들어왔는데 아래에 (있으면 둘다 제거
            if(curStr.equals(")") && queue.peek().equals("(")){
                queue.poll();
                continue;
            }

            // ( 들어오거나 ))
            queue.add(curStr);
        }

        if(queue.size() == 0)   return true;
        else return false;
    }
}