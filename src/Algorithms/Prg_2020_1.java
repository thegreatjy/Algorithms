package Algorithms;
//괄호 변환 
public class Prg_2020_1 {
    public static String solution(String p) {
        String answer = "";
        StringBuilder u = new StringBuilder();
        StringBuilder v = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        StringBuilder u_reverse = new StringBuilder();
        
        int chk_u=0;
        boolean isRegular=true;
        
        //입력이 빈 문자열인 경우, 빈 문자열을 반환
        if(p.length()==0) {
        	return "";
        }
        
        //p->u, v
        for(int i=0;i<p.length();i++) {
        	char c=p.charAt(i);
        	if(c=='(') {
        		chk_u++;
        		u_reverse.append(')');
        	}else if(c==')') {
        		chk_u--;
        		u_reverse.append('(');
        	}
        	//탐색하면서 한 번이라도 chk_u가 음수가 된 적이 있으면 u는 올바른 문자열이 아니다
        	if(chk_u<0 && isRegular) {
        		isRegular=false;
        	}
        	
        	//균형잡힌 문자열 u 구함
        	if(chk_u==0) {
        		u.append(p.substring(0,i+1));
        		v.append(p.substring(i+1));
        		
        		//u가 올바른 문자열이 아님 
        		if(!isRegular) {
        			temp.append("(");
        			temp.append(solution(v.toString()));
        			temp.append(")");
        			String str="";
        			if(u_reverse.length()>2) {
        				str=u_reverse.toString().substring(1, u_reverse.length()-1);
        			}
        			temp.append(str);
        			answer=temp.toString();
        		}else {//u가 올바른 문자열 
        			answer=u+solution(v.toString());
        		}
        		
        		break;
        	}
        }
        return answer;
    }

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str=")))(((";
		System.out.println("result:"+solution(str));
	}

}
