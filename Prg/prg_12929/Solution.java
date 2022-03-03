package prg_12929;

//올바른 괄호의 개수 
public class Solution {
	static int N, result = 0;
	
	public static void dfs(int length, int sum) {
		if(length >= 2*N) {
			if(sum == 0) {
				++result;
			}
			return;
		}
		
		// ( 을 만듦 
		dfs(length+1, sum+1);
		// (을 만든 적이 있으면 )을 만듦
		if(sum>0)	dfs(length+1, sum-1);
		return ;
	}
	public int solution(int n) {
        int answer = 0;
        N = n;
        
        dfs(0, 0);
        
        return result;
    }
	
	public static void main(String[] args) {
		int temp = 3;
		System.out.println(new Solution().solution(temp));
	}
}
