package GenerateParentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static int n;
    public static List<String> list;

    public static void backtracking(int currentIdx, int cnt, StringBuilder sb){
        // base case
        if(currentIdx >= n*2){
            if(cnt == 0)    list.add(sb.toString());
            return;
        }

        // 괄호 열기
        backtracking(currentIdx + 1, cnt + 1, sb.append("("));
        sb.deleteCharAt(sb.length() - 1);

        // 괄호 닫기
        if(cnt > 0) {
            backtracking(currentIdx + 1, cnt - 1, sb.append(")"));
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static List<String> generateParenthesis(int n) {
        list = new ArrayList<>();
        // this.n = n;

        backtracking(0, 0, new StringBuilder());

        return list;
    }

    public static void main(String[] args) {
        n = 3;
        new Solution().generateParenthesis(n);

        list.stream().forEach(e -> System.out.print(e + ", "));
    }
}
