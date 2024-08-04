package Bj_1662;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
    private static String str;

    // s = i + k(q)
    // s의 길이를 반환한다.
    public static int func(int startIdx, int lastIdx){
        if(startIdx >= str.length()) return 0;

        int sSize = 0;
        for(int a=startIdx; a<=lastIdx; a++){
            char c = str.charAt(a);

            if(c == '('){
                --sSize;
                int k = str.charAt(a - 1) - '0';

                int tempLastIdx = getClosingBracketIdx(a);
                sSize = sSize + (k * func(a + 1, tempLastIdx));
                // 현재 (와 대응되는 )로 인덱스 a를 이동한다.
                a = tempLastIdx;
            }else if(c >= '0' && c <= '9'){
                ++sSize;
            }

        }

        return sSize;
    }

    public static int getClosingBracketIdx(int openingBracketIdx){
        int openingBracketCnt = 1;

        for(int i=openingBracketIdx + 1; i<str.length(); i++){
            char c = str.charAt(i);
            if(c == '('){
                ++openingBracketCnt;
            }else if(c == ')'){
                --openingBracketCnt;
                if(openingBracketCnt == 0)  return i;
            }
        }

        return openingBracketIdx;
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();

        int res = func(0, str.length() - 1);
        System.out.println(res);
    }
}
