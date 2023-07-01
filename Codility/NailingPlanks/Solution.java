package NailingPlanks;

import java.util.Arrays;

public class Solution {
	public int minNails(int plankStart, int plankEnd, int[][] sortedC, int prev) {
		int start = 0, end = sortedC.length-1, mid = 0;
		
		int minIdx = -1;	//조건 만족하기 시작하는 nail idx
		while(start<=end) {
			mid = (start+end)/2;
			
			if(sortedC[mid][0] < plankStart) {
				start = mid + 1;
			}else if(sortedC[mid][0] > plankEnd) {
				end = mid - 1;
			}else {
				minIdx = mid;
				end = mid - 1;
			}
		}
		//조건 만족하는 nail이 없다
		if(minIdx == -1) {
			return -1;
		}
		
		int minOrgIdx = sortedC[minIdx][1];
		for(int i=minIdx;i<sortedC.length;i++) {
			if(sortedC[i][0] > plankEnd)	break;
			minOrgIdx = Math.min(sortedC[i][1], minOrgIdx);
			if(minOrgIdx<=prev) {
				return prev;
			}
		}
		
		return minOrgIdx;
	}
	public int solution(int[] A, int[] B, int[] C) {
        // Implement your solution here
		int N = A.length;
		int M = C.length;
		
		int[][] sortedC = new int[M][2];
		for(int i=0;i<M;i++) {
			sortedC[i][0] = C[i];
			sortedC[i][1] = i;
		}
		Arrays.sort(sortedC, (c1, c2)->{
			return c1[0] - c2[0];
		});
		
		//한 널빤지의 못 사용 최소 개수 구하기 
		int result = 0, numberOfNails = 0;
		for(int i=0;i<N;i++) {
			numberOfNails = minNails(A[i], B[i], sortedC, result);
			if(numberOfNails == -1)		return -1;
			result = Math.max(result, numberOfNails);
		}
		return result + 1;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,4,5,8};
		int[] B = {4,5,9,10};
		int[] C = {4,6,7,10,2};
		
		int result = new Solution().solution(A, B, C);
		System.out.println(result);
	}

}
