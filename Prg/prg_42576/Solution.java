package prg_42576;

import java.util.*;

public class Solution {
	public String solution(String[] participant, String[] completion) {
        String answer = "";
        int num = 0;
        //참가자 해시에 넣음 
        HashMap<String, Integer> partMap = new HashMap<>();
        for(String name:participant) {
        	//(이름, 1명) 추가, 동명이인있으면 사람 수 증가
        	partMap.put(name, partMap.getOrDefault(name, 0) + 1);
        }
        //완주자 해시에서 검색 
       for(String name:completion) {
    	   partMap.put(name, partMap.get(name) - 1);
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
