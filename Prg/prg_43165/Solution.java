package prg_43165;

public class Solution {
	public int solution(int[] numbers, int target) {
        int answer = 0;
        
        answer = dfs(0, 0, numbers, target);
        
        return answer;
    }
	
	public int dfs (int cur, int sum, int[] numbers, int target) {
		int result = 0;
		if(cur>=0 && cur<numbers.length) {
			result += dfs(cur+1, sum + numbers[cur], numbers, target);
			result += dfs(cur+1, sum - numbers[cur], numbers, target);
		}else {
			if(sum==target) {
				return 1;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] numbers = {1,1,1,1,1};
		int[] numbers = {4,1,2,1};
		int target = 4;
		int result = new Solution().solution(numbers, target);
		System.out.println(result);
	}

}
