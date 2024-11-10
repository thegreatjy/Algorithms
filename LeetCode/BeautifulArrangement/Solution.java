package BeautifulArrangement;

public class Solution {
    private int n;
    private int resultBacktracking = 0;

    public void backtracking(int currentIdx, boolean[] visited){
        if(currentIdx > n){
            ++resultBacktracking;
        }

        // 순열의 currentIdx 위치에 i 수를 넣어보기
        for(int i=1; i<= n; i++){
            if(!visited[i] && (currentIdx%i==0 || i%currentIdx==0)){
                visited[i] = true;
                backtracking(currentIdx + 1, visited);
                visited[i] = false;
            }
        }
    }

    public int dfs(int currentIdx, int visitedBit, int[] dp){
        if(currentIdx >= n+1)   return 1;
        if(dp[visitedBit] != 0) return dp[visitedBit];

        // 순열의 currentIdx 위치에 i 수를 넣어보기
        int count = 0;
        for(int i=1; i<=n; i++){
            if((visitedBit & (1<<(i-1))) == 0 && (currentIdx%i==0 || i%currentIdx==0)){
                count += dfs(currentIdx+1, visitedBit | (1<<(i-1)), dp);
            }
        }
        dp[visitedBit] = count;

        return dp[visitedBit];
    }


    public int countArrangement(int n) {
        int result = 0;

        this.n = n;

        // 백트래킹
        /*
        boolean[] visited = new boolean[n+1];
        backtracking(1, visited);

        return result = resultBacktracking;
         */

        // DP 비트마스킹
        int[] dp = new int[1<<(n)];
        result = dfs(1, 0, dp);
        return result;
    }

    public static void main(String[] args) {
        int n = 2;
        int result = new Solution().countArrangement(n);
        System.out.println(result);
    }
}
