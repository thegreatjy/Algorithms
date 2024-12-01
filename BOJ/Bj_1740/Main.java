package Bj_1740;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Long N = Long.parseLong(br.readLine());

        String binStr = Long.toBinaryString(N);
        long answer = 0L;
        for(int i=0; i<binStr.length(); i++){
            char c = binStr.charAt(i);
            if(c == '1'){
                answer += pow(binStr.length()-1-i);
            }
        }

        System.out.print(answer);
    }

    // return Math.pow(3, i);
    public static long pow (int i){
        long result = 1L;
        for(int a=0; a<i; a++){
            result *= 3;
        }
        return result;
    }
}
