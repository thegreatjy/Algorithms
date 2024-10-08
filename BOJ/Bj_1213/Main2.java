package Bj_1213;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = str.length();
        int[] cnt = new int[26];
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            int ci = c - 'A';
            cnt[ci]++;
        }

        boolean flag = true;
        int cntOdd = 0;
        String odd = "";
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<26; i++){
            String s = String.valueOf((char)(i+'A'));
            // 짝수개 반복
            sb.append(s.repeat(cnt[i]/2));

            if(cnt[i]%2 == 1){
                if(n%2==0){
                    // 안 됨
                    flag = false;
                    break;
                }else{
                    if(cntOdd >= 1){
                        // 안 됨
                        flag = false;
                        break;
                    }else if(cntOdd == 0){
                        // 일단 저장
                        odd = s;
                        cntOdd++;
                    }
                }
            }
        }

        if(!flag){
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        String original = sb.toString();

        System.out.println(original + odd + sb.reverse());
    }
}
