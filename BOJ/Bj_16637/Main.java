package Bj_16637;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N, MAX = Integer.MIN_VALUE;
    static String expression;

    public static void dfs(int pre, int curIdx){
        if(curIdx >= N){
            MAX = Integer.max(MAX, pre);
            return ;
        }

        // 괄호 없음
        int result = calc(pre, expression.charAt(curIdx - 1), expression.charAt(curIdx) - '0');
        dfs(result, curIdx + 2);

        // 괄호 추가
        if(curIdx + 2 < N){ // 현재 숫자 뒤에 피연산자 숫자가 존재한다면 괄호 넣어보기
            int post = calc(expression.charAt(curIdx) - '0', expression.charAt(curIdx + 1), expression.charAt(curIdx + 2) - '0');
            result = calc(pre, expression.charAt(curIdx - 1), post);
            dfs(result, curIdx + 4);
        }
    }

    // return a+b || a-b || a*b
    public static int calc(int a, char op, int b){
        if(op == '+'){
            return a+b;
        }else if(op == '-'){
            return a-b;
        } else if (op == '*') {
            return a*b;
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        expression = br.readLine();

        dfs(expression.charAt(0) - '0', 2);

        System.out.println(MAX);
    }
}
