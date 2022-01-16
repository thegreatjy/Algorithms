package Algorithms;

import java.util.*;

public class Prg_43162 {
    static int visit[];
    
	public static int solution(int n, int[][] computers) {
        int answer = 0;
        visit = new int[n];
        
        for(int i = 0; i < n; i++){
            if(visit[i] == 0){
                answer++;
                search (n, i, computers);
            }
        }
        return answer;
    }
	
    static void search (int n, int node, int[][] computers){
        LinkedList<Integer> q = new LinkedList<>();
        q.add(node);
        visit[node] = 1;
    
        while(!q.isEmpty()){
            int tmp = q.poll();
        
            for(int i = 0; i < n; i++){
                if(computers[tmp][i] == 1 && visit[i] == 0) {
                    q.add(i);
                    visit[i] = 1;
                }
            }
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m=3;
		int[][] temp={{1,1,0}, {1,1,0}, {0,0,1}};
		System.out.println(solution(m, temp));
	}
}