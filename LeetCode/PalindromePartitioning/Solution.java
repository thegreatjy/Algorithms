package PalindromePartitioning;

import java.util.ArrayList;
import java.util.List;
// 6시~
public class Solution {
    public List<List<String>> partition(String s) {
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        for(int i=0; i<length; i++){
            dp[i][i] = true;
        }
        for (int len = 2; len <= length; len++) {
            for (int i = 0; i <= length - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && (len == 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                }
            }
        }
        /* 틀림
        for(int i=0; i<length; i++){
            for(int j=0; j<length; j++){
                if(s.charAt(i)==s.charAt(j)){
                    if(i+1 == j){
                        dp[i][j] = true;
                    }else if(i+1 < length && j-1 >=0 && dp[i+1][j-1]){
                        dp[i][j] = true;
                    }
                }
            }
        }
         */

        List<List<String>> result = new ArrayList<>();
        dfs(s, 0, new ArrayList<>(), result, dp);

        return result;
    }

    public void dfs(String s, int start, List<String> palindromeList, List<List<String>> result, boolean[][] dp){
        // 종료 조건
        if(start >= s.length()){
            result.add(new ArrayList<>(palindromeList));
            return;
        }

        for(int end=start; end<s.length(); end++){  // 끝점을 변화하여 순회. start~end 문자열을 확인
            if(dp[start][end]){
                // backtracking
                palindromeList.add(s.substring(start, end+1));
                dfs(s, end+1, palindromeList, result, dp);
                palindromeList.remove(palindromeList.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        String s = "aab";
        List<List<String>> res = new Solution().partition(s);
        for(List<String> r: res){
            r.stream().forEach(s1 -> System.out.print(s1 + ", "));
            System.out.println();
        }
    }
}
