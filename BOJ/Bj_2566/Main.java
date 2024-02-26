package Bj_2566;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        int max = Integer.MIN_VALUE, maxR = 0, maxC = 0, cur;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int i=0; i<9; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<9; j++){
                cur = Integer.parseInt(st.nextToken());
                if(cur > max){
                    max = cur;
                    maxR = i + 1;
                    maxC = j + 1;
                }
            }
        }

        System.out.println(max);
        System.out.print(maxR + " " + maxC);
    }
}