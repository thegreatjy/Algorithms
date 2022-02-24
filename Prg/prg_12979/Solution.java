package prg_12979;

public class Solution {
	public int solution (int n, int[] stations, int w) {
		int s=0, cnt=0;
		double cover = 2*w+1;	//기지국 하나 세웠을 때 전파 범위
		for(int i=0;i<stations.length;i++) {
			int ns=(stations[i]-1)-w-1;	//기지국의 왼쪽 전파 범위가 닿지 않기 시작하는 인덱스 
			if(ns>=0 && ns<n) {
				int temp=(stations[i]-1)-w-s;	//기지국 왼쪽에 전파가 닿지 않는 범위 
				if(temp>0) {
					cnt+=(int)Math.ceil(temp/cover);
				}
			}
			//기지국의 오른쪽 전파 범위 끝을 s로 갱신 
			s = (stations[i]-1)+w+1;
		}
		
		if(s<n) {
			cnt+=(int)Math.ceil((n-s)/cover);
		}
		
		return cnt;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 11;
		int[] stations = {4, 11};
		int w = 1;
		int result = new Solution().solution(n, stations, w);
		System.out.println(result);
	}

}
