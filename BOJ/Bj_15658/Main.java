package Bj_15658;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int MIN = Integer.MAX_VALUE, MAX = Integer.MIN_VALUE;
    static int[] prog;

    // update MIN, MAX
    // by calculating pre (+, -, *, /) prog[curIdx]
    public static void dfs(int pre, int curIdx, int[] op){
        if(curIdx >= prog.length){
            MIN = Integer.min(MIN, pre);
            MAX = Integer.max(MAX, pre);

            return;
        }

        int result; // 사칙연산 계산 결과
        for(int i=0; i<4; i++){
            if(op[i] <= 0) continue;

            if(i == 0)          result = pre + prog[curIdx];
            else if(i == 1)     result = pre - prog[curIdx];
            else if(i == 2)     result = pre * prog[curIdx];
            else                result = pre / prog[curIdx];

            --op[i];
            dfs(result, curIdx + 1, op);
            ++op[i];
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        prog = new int[N]; // 피연산자 수열
        for(int i=0; i<N; i++){
            prog[i] = Integer.parseInt(line[i]);
        }
        line = br.readLine().split(" ");
        int[] op = new int[4]; // 연산자 개수
        for(int i=0; i<4; i++){
            op[i] = Integer.parseInt(line[i]);
        }

        dfs(prog[0], 1, op);

        System.out.println(MAX);
        System.out.println(MIN);
    }
}
