package prg_42576;

import java.util.*;

public class Solution {
	public String solution(String[] participant, String[] completion) {
        String answer = "";
        int num = 0;
        //참가자 해시에 넣음 
        HashMap<String, Integer> partMap = new HashMap<>();
        for(int i=0;i<participant.length;i++) {
        	//동명이인있으면 사람 수 증가
        	if(partMap.containsKey(participant[i])) {
        		num = partMap.get(participant[i]);
        		partMap.put(participant[i], num + 1);
        	}else {//처음 나오는 이름이면 1명 추가 
        		partMap.put(participant[i], 1);
        	}
        }
        //완주자 해시에서 검색 
        for(int i=0;i<completion.length;i++) {
        	num = partMap.get(completion[i]);
        	if(num > 0) {
        		partMap.put(completion[i], num - 1);
        	}
        }
        //나머지 한 명 리턴 
        for(String name : partMap.keySet()){ //저장된 key값 확인
        	//System.out.println("[Key]:" + name + " [Value]:" + partMap.get(name));
        	if(partMap.get(name) > 0) {
        		answer = name;
        		return answer;
        	}
        }
   
        return answer;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
		String[] completion = {"josipa", "filipa", "marina", "nikola"};
		
		String result = new Solution().solution(participant, completion);
		System.out.println(result);
	}

}
