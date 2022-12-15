package Bj_2504;

import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		input = br.readLine();
		
		Stack<Integer> stk = new Stack<>();
		int sum = 0, result = 0;
		int top = 0, a = 0, b = 0;
		for(int i=0;i<input.length();i++) {
			char c = input.charAt(i);
			
			if(c=='(') {
				top = stk.pop();
				if(top != 2) {
					result = 0;
					break;
				}else if(top == 2) {
					
				}
				
			}else if(c==')') {
				stk.push(2);
			}else if(c=='[') {
				
			}else if(c==']') {
				stk.push(3);
			}
		}
		
	}

}
