package Prg_42889;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

    
public class Solution {
	class rate{
		int level;
		double rate;
		rate(int level, double rate){
			this.level=level;
			this.rate=rate;
		}
	}

    public int[] solution(int N, int[] stages) {
    	int[] num=new int[N+1];
    	//클리어하지 못한 플레이어 수 num
    	for(int i=0;i<stages.length;i++) {
    		if(stages[i]==N+1)	continue;
    		num[stages[i]]++;
    	}
    	
    	ArrayList<rate> list=new ArrayList<>();
    	int denom=stages.length;//스테이지에 도달한 플레이어 수(분모)
    	double rt;
    	//실패율(rt) 계산하여 list에 넣음
    	for(int i=1;i<num.length;i++) {
    		if(denom==0) {//분모가 0이면 
    			list.add(new rate(i, 0));
    			continue;
    		}
    		rt=(double)num[i]/denom;
    		list.add(new rate(i, rt));
    		denom=denom-num[i];
    	}
    	
        //실패율 내림차순 정렬 
    	Collections.sort(list, ((o1, o2) -> Double.compare(o2.rate, o1.rate)));

        //실패율의 스테이지 레벨을 answer배열에 넣음
        int[] answer = new int[N];
        for(int i=0;i<list.size();i++) {
        	answer[i]=list.get(i).level;
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N=4;
		int[] stages= {4,4,4,4,4};
		int[] result=new Solution().solution(N, stages);
    	for(int temp:result) {
    		System.out.print(temp+" ");
    	}
	}

}
