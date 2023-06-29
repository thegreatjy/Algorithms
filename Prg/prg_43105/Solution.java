package prg_43105;

import java.util.*;

public class Solution {
	public int solution(int[][] triangle) {
		int preMax = 0, result = 0;
		int r = triangle.length;
		int[][] max = new int[r][r];
		max[0][0] = triangle[0][0];
		
		for(int i=1;i<r;i++) {
			for(int j=0;j<=i;j++) {
				if(j-1<0) {	//왼쪽 위가 없다.
					preMax = max[i-1][j];
				}else {
					//왼쪽 위vs오른쪽 위
					preMax = Math.max(max[i-1][j-1], max[i-1][j]);
				}
				max[i][j] = preMax + triangle[i][j];
				
				//마지막층에서는 그 층에서의 최댓값을 구함
				if(i==r-1) {
					result = Math.max(max[i][j], result);
				}
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		int result = new Solution().solution(triangle);
		System.out.println(result);
	}

}
