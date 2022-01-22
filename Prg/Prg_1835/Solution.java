package Prg_1835;

import java.util.*;
import java.io.*;

class Solution {
	static boolean[] visited;
    static String[] friends= {"A", "C", "F", "J", "M", "N", "R", "T"};
    static int cnt=0;
    
    public int solution(int n, String[] data) {
        int answer = 0;
        visited=new boolean[8];
        perm("", visited, data);
        System.out.println(cnt);
        return answer;
    }
    
    //순열 Perm
    public void perm (String line, boolean[] visit, String[] data)	{
    	if(line.length()==7) {
    		if(check(line, data)) cnt++;
    		//System.out.println(line);
    		return;
    	}
    	
    	for(int b=0;b<8;b++) {
    		if(!visit[b]) {
    			String line2=line+friends[b];
    			visit[b]=true;
    			perm(line2, visit, data);
    			visit[b]=false;
    			//line=line.substring(0, line.length()-1);
    		}
    	}
    }
    
    //line에 대해서 조건이 맞는지 확인 
    public boolean check(String line, String[] datas) {
    	//조건 한 개씩 검사 
    	for (String data : datas) {
            int position1 = line.indexOf(data.charAt(0));
            int position2 = line.indexOf(data.charAt(2));
            char op = data.charAt(3);
            int index = data.charAt(4) -'0';
            if (op == '=') {
                if (!(Math.abs(position1 - position2) == index+1)) return false;
            } else if (op == '>') {
                if (!(Math.abs(position1 - position2) > index+1)) return false;
            } else if (op == '<') {
                if (!(Math.abs(position1 - position2) < index+1)) return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
    	int n=2;
    	String[] str= {"N~F=0", "R~T>2"};
    	
    	new Solution().solution(n, str);
    	System.out.println(cnt);
    }
}


