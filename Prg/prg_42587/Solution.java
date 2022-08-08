package prg_42587;

import java.util.*;

public class Solution {
	public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i=0;i<priorities.length;i++) {
        	pq.add(priorities[i]);
        	q.add(priorities[i]);
        }
        
        int max = 0, cur = 0, cnt = 0, test = 0;
        max = pq.peek();
        
        while(!q.isEmpty()) {
        	cur = q.poll();
        	max = pq.peek();
        	
        	if(cur == max) {
        		//더 높은 중요도의 문서가 없다. 현재 문서를 인쇄 
        		pq.poll();
        		cnt++;
        		//원하던 문서를 인쇄함 
        		if(location == 0)	break;
        	}else {
        		//더 높은 중요도의 문서가 있음. 현재 문서를 뒤로 보낸다.
        		q.add(cur);
        	}
        	
        	location--;
        	if(location<0)	location = q.size()-1;
        }
        
        return cnt;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] priorities = {1, 1, 9, 1, 1, 1};
		int location = 0;
		int result = new Solution().solution(priorities, location);
		System.out.println(result);
	}

}
