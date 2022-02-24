package prg_12987;

import java.util.*;

public class Solution {
	public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        boolean[] visited = new boolean[B.length];
        
        int cnt = 0;
        int Bidx = 0;
        for(int a : A) {
        	for(int i = Bidx; i<B.length; i++) {
        		if(B[i] > a && !visited[i]) {
        			cnt++;
        			visited[i] = true;
        			Bidx = i+1;
        			break;
        		}
        	}
        	//남은 a보다 큰 b가 존재하지 않는다.
        	if(Bidx > B.length) {
        		break;
        	}
        }
        
        return cnt;
    }
	
	public int solution2(int[] A, int[] B) {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int idxA = 0, idxB = 0;
        while (idxA < A.length) {
        	if(idxB >= B.length)	break;
            if (A[idxA] < B[idxB]) {
                answer++;
                idxB++;
                idxA++;
            }else{
            	idxB++;
            	
            }
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {5,1,3,7};
		int[] B = {2,2,6,8};
		int result = new Solution().solution2(A, B);
		System.out.println(result);
	}

}
