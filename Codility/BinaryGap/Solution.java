package BinaryGap;

public class Solution {
	public int solution(int N) {
        // Implement your solution here
		//the max number of 0 
		int max = 0;
		//make binary representation of N 
		String bin = Integer.toBinaryString(N);
		//yield longest bg
		int cntZero = 0;
		for(int i=0;i<bin.length();i++) {	//max length of bin is 32
			if(bin.charAt(i)=='1') {
				//renewal max
				max = Math.max(cntZero, max);
				cntZero = 0;
			}else {
				cntZero++;
			}
		}
		
		return max;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 5;
		int result = new Solution().solution(N);
		System.out.println(result);
	}

}
