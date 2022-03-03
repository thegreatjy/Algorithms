package prg_1844;

import java.util.*;

public class Solution {
	static int[] row = {0,0,1,-1};
	static int[] col = {1,-1,0,0};
	
	public int solution(int[][] maps) {
        int answer = -1;
        int N = maps.length;
        int M = maps[0].length;
        boolean[][] visited = new boolean[N][M];
        
        Queue<node> q = new LinkedList<>();
        
        q.offer(new node(N-1, M-1));
        visited[N-1][M-1] = true;
        
        int nx, ny;
        while(!q.isEmpty()) {
        	node nd = q.poll();
        	
        	if(nd.x == 0 && nd.y==0) {
        		return maps[nd.x][nd.y]; 
        	}
        	
        	for(int i=0;i<4;i++) {
        		nx = nd.x + row[i];
        		ny = nd.y + col[i];
        		if(nx<0 || nx>=N || ny<0 || ny>=M || visited[nx][ny])	continue;
        		if(maps[nx][ny]==1) {
        			q.offer(new node(nx, ny));
        			visited[nx][ny] = true;
        			maps[nx][ny] = maps[nd.x][nd.y] + 1;
        		}
        	}
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		int[][] map = {
				{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}
		};
		int[][] maps2 = {
				{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}
		};
		int result = new Solution().solution(maps2);
		System.out.print(result);
	}
	
	static class node{
		int x, y;
		
		node(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
}
