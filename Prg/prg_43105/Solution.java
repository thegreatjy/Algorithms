package prg_43105;

public class Solution {
	public int solution(int[][] triangle) {
		int height = triangle.length;
        int[][] dp = new int[height][height];	//dp[r][c] == (r,c)까지의 최대 누적합
        
        int r = 0, result = 0;
        dp[0][0] = triangle[0][0];
        while(r <= height-2) {
        	for(int i=0;i<=r;i++) {
	        	//왼쪽 아래 
	        	dp[r+1][i] = Math.max(dp[r+1][i], dp[r][i] + triangle[r+1][i]);
	        	//오른쪽 아래 
	        	dp[r+1][i+1] = Math.max(dp[r+1][i+1], dp[r][i] + triangle[r+1][i+1]);
	        	//맨 아랫줄에서 제일 큰 수가 정답 
	        	if(r == height-2) {
	        		result = Math.max(result, dp[r+1][i]);
	        	}
        	}
        	//아래층으로 이동 
        	++r;
        }
        
        result = Math.max(result, dp[height-1][height-1]);
        return result;
    }
	
	public static void main(String[] args) {
		int[][] triangle = {
				{7},
				{3, 8},
				{8, 1, 0},
				{2, 7, 4, 4},
				{4, 5, 2, 6, 5}
		};
		System.out.println(new Solution().solution(triangle));
	}
}
