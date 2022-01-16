package Bj_9935;

import java.util.*;

public class Main {
	static String input, exp, result;
	static Stack<Character>stk;
	
	static void func(int i_cur, int e_cur) {
		for(int a=0;a<input.length();a++, i_cur++) {
			char i=input.charAt(i_cur);
			stk.add(i);

			//스택 맨 윗 요소가 exp의 맨 마지막 글자와 같으면
			if(i==exp.charAt(e_cur) && stk.size()>=exp.length()) {
				//스택에서 pop하며 exp의 뒤를 훑으며 비교한다
				for(int j=stk.size()-1; j>stk.size()-exp.length()-1; j--) {
					//System.out.println("j="+j+"ecur="+e_cur);
					//스택의 맨 위 요소!=explosion글자
					if(exp.charAt(e_cur)!=stk.get(j)) {
						e_cur=exp.length()-1;
						break;
					}
					//explosion찾음 
					if(e_cur==0) {
						for(int k=0;k<exp.length();k++) {
							stk.pop();
						}
						e_cur=exp.length()-1;
						break;
					}
					e_cur--;
				}
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		input=scan.next();
		exp=scan.next();
		
		stk=new Stack<>();
		func(0, exp.length()-1);
		
		if(stk.isEmpty()) {
			System.out.println("FRULA");
		}else {
			StringBuilder sb = new StringBuilder();
			for (Character character : stk) { 
				sb.append(character);
			} 
			System.out.println(sb.toString());
		}
		

	}

}
