package Bj_1213;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int[] alphabet = new int[26];
        for(int i=0; i<input.length(); i++){
            ++alphabet[input.charAt(i) - 'A'];
        }

        Boolean status = true;
        int cntOdd = 0; // 홀수 개수
        int oddChar = 0;    // 가운데에 위치할 캐릭터
        StringBuilder sb = new StringBuilder();
        String str;
        for(int i=0; i<26; i++){
            if(alphabet[i]%2 == 0){
                // 짝수
                str = Character.toString(i + 'A');
                sb.append(str.repeat(alphabet[i] / 2));
            }else{
                // 홀수
                if(cntOdd >= 1){
                    // 홀수 2개이므로 불가능
                    status = false;
                    break;
                }

                // 1개 제외한 짝수개를 str에 포함
                str = Character.toString(i + 'A');
                sb.append(str.repeat(alphabet[i] / 2));

                oddChar = i;
                ++cntOdd;
            }
        }

        String result;
        if(status){
            result = sb.toString();

            if(cntOdd == 1){
                str = Character.toString(oddChar + 'A');
                result += str;
            }

            result += sb.reverse();
        }else{
            result = "I'm Sorry Hansoo";
        }

        System.out.println(result);
    }
}
