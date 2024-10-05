package Bj_14501;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int n = 0, price = -1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[] t = new int[n];
        int[] p = new int[n];
        String[] line;
        for(int i=0; i<n; i++){
            line = br.readLine().split(" ");
            t[i] = Integer.parseInt(line[0]);
            p[i] = Integer.parseInt(line[1]);
        }

        dfs(0, 0, t, p);

        System.out.println(price);
    }

    public static void dfs(int curIdx, int pSum, int[] t, int[] p){
        price = Math.max(price, pSum);

        // 종료
        if(curIdx >= n){
            price = Math.max(price, pSum);
            return;
        }

        for(int i=curIdx; i<n; i++){
            // 상담 i를 한다.
            if(i+t[i] <= n) {
                dfs(i+t[i], pSum+p[i], t, p);
            }
            // 상담 i를 안 한다.
        }

    }
}
