package Prg_49191;

public class Solution {
	public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] map = new int[n+1][n+1];
        for(int i=0;i<results.length;i++) {
        	map[results[i][0]][results[i][1]] = 1;
        	map[results[i][1]][results[i][0]] = -1;
        }
        
        for(int mid=1;mid<=n;mid++) {
        	for(int i=1;i<=n;i++) {
        		if(mid==i)	continue;
        		for(int j=1;j<=n;j++) {
        			if(i==j)			continue;
        			if(map[i][j]!=0)	continue;
        			
        			if(map[i][mid]==1 && map[mid][j]==1) {
        				map[i][j] = 1;
        				map[j][i] = -1;
        			}else if(map[j][mid]==1 && map[mid][i]==1) {
        				map[j][i] = 1;
        				map[i][j] = -1;
        			}
        		}
        	}
        }
        
        int cnt = 0;
        for(int i=1;i<=n;i++) {
        	cnt = 0;
        	for(int j=1;j<=n;j++) {
        		if(i==j)			continue;
        		if(map[i][j]==0)	break;
        		++cnt;
        	}
        	if(cnt==n-1)	++answer;
        }
        
        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
		int res = new Solution().solution(5, results);
		System.out.println(res);
	}

}
