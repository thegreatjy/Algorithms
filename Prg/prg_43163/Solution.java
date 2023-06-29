package prg_43163;

import java.util.*;

public class Solution {
	class node{
		String str;
		int cnt;
		
		node(String str, int cnt){
			this.str = str;
			this.cnt = cnt;
		}
	}
	public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        //words에 target 여부 확인 
        for(int i=0;i<words.length;i++) {
        	if(words[i].equals(target)) {
        		break;
        	}
        	//words에 target이 없음
        	if(i==words.length-1) {
        		return answer;
        	}
        }
        
        node nd;
        String ndString;
        int level;
        //변환되었던 단어의 집합
        HashSet<String> used = new HashSet<>();
        //변경 가능한 단어를 넣어둔다
        Queue<node> q = new LinkedList<>();
        q.add(new node(begin, 0));
        
        while(!q.isEmpty()) {
        	nd = q.poll();
        	ndString = nd.str;
        	level = nd.cnt;
        	
        	//target으로 변환이 되었다
        	if(ndString.equals(target)) {
        		answer = level;
        		break;
        	}
        	
        	//변환될 수 있는 단어를 찾는다
        	for(int i=0;i<words.length;i++) {
        		//본인은 건너뛴다
        		if(ndString.equals(words[i]))	continue;
        		//한 번도 변환된 적이 없어야 함
        		if(!used.contains(words[i])) {
        			//현재 단어인 ndString에서 한 글자만 변환한 단어를 찾음
        			if(compare(ndString, words[i])) {
        				q.add(new node(words[i], level + 1));
        			}
        		}
        	}
        }
        
        return answer;
    }
	
	//str1과 str2의 단어 차이가 1개면 true를 리턴하는 함수 
	public boolean compare(String str1, String str2) {
		boolean result = false;
		
		//다른 알파벳 개수를 구한다.
		int cnt = 0;
		for(int i=0;i<str1.length();i++) {
			if(str1.charAt(i)!=str2.charAt(i)) {
				cnt++;
				if(cnt > 2) {
					return result;
				}
			}
		}
		
		if(cnt==1) result = true;
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String begin = "hit";
		String target = "cog";
		//String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
		String[] words = {"hot", "dot", "dog", "lot", "log"};
		int result = new Solution().solution(begin, target, words);
		System.out.println(result);
	}

}
